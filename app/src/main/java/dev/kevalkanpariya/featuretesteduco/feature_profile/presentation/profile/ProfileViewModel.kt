package dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.profile

import android.content.SharedPreferences
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.domain.models.UserItem
import dev.kevalkanpariya.featuretesteduco.core.domain.use_case.GetOwnUserIdUseCase
import dev.kevalkanpariya.featuretesteduco.core.domain.use_case.ToggleFollowStateForUserUseCase
import dev.kevalkanpariya.featuretesteduco.core.presentation.PagingState
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.util.DefaultPaginator
import dev.kevalkanpariya.featuretesteduco.core.util.Event
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case.ProfileUseCases
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCases: ProfileUseCases,
    private val getOwnUserId: GetOwnUserIdUseCase,
    sharedPref: SharedPreferences,
    private val toggleFollowStateForUserUseCase: ToggleFollowStateForUserUseCase,

    ): ViewModel() {

    private val _userProfile = MutableStateFlow(ProfileState())
    val userProfile: StateFlow<ProfileState> = _userProfile

    private val _coursePagingState = mutableStateOf<PagingState<CourseOverview>>(PagingState())
    val coursePagingState: State<PagingState<CourseOverview>> = _coursePagingState

    private val _followingPagingState = mutableStateOf<PagingState<UserItem>>(PagingState())
    val followingPagingState: State<PagingState<UserItem>> = _followingPagingState


    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        sharedPref.getString("userId", "").let { userId ->
            loadCoursesForProfile(userId)
            loadUserItemsForProfile(userId)
        }

    }


    private val followingPaginator = DefaultPaginator(
        onLoadUpdated = { isLoading ->
            _followingPagingState.value = followingPagingState.value.copy(
                isLoading = isLoading
            )
        },
        onRequest = { page ->
            profileUseCases.getUserInfosUseCase(
                page = page,
                pageSize = 4
            )
        },
        onSuccess = { userItems ->
            _followingPagingState.value = followingPagingState.value.copy(
                items = followingPagingState.value.items + userItems,
                endReached = userItems.isEmpty(),
                isLoading = false
            )
        },
        onError = { uiText ->
            _eventFlow.emit(UiEvent.ShowSnackBar(uiText))
        }
    )


    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.Logout -> {
                profileUseCases.logout()
            }
            ProfileEvent.ShowLogoutDialog -> {
                _userProfile.value = userProfile.value.copy(
                    isLogoutDialogVisible = true
                )
            }
            is ProfileEvent.DismissLogoutDialog -> {
                _userProfile.value = userProfile.value.copy(
                    isLogoutDialogVisible = false
                )
            }
            is ProfileEvent.ToggleFollowStateForUser -> {
                toggleFollowStateForUser(followedUserId = event.userId)
            }
            else -> Unit
        }
    }


    fun loadNextFollowings() {
        viewModelScope.launch {
            followingPaginator.loadNextItems()
        }
    }

    private fun loadCoursesForProfile(userId: String?) {
        viewModelScope.launch {
            _userProfile.value = userProfile.value.copy(
                isLoadingProfile = true
            )
            val result = profileUseCases.getCoursesForProfile(
                userId = userId?: getOwnUserId(),
                page = 0,
                pageSize = 4
            )
            when(result) {
                is Resource.Success -> {
                    _userProfile.value = userProfile.value.copy(
                        courses = result.data ?: emptyList(),
                        isLoadingCourses = false
                    )
                }
                is Resource.Error -> {
                    _userProfile.value = userProfile.value.copy(
                        isLoadingCourses = false
                    )
                }


        }
    }
}

private fun loadUserItemsForProfile(userId: String?) {
    viewModelScope.launch {
        _userProfile.value = userProfile.value.copy(
            isLoadingUserItems = true
        )
        val result = profileUseCases.getUserInfosUseCase(
            page = 0,
            pageSize = 4
        )
            when(result) {
                is Resource.Success -> {
                    _userProfile.value = userProfile.value.copy(
                        userItems = result.data ?: emptyList(),
                        isLoadingUserItems = false
                    )
                }
                is Resource.Error -> {
                    _userProfile.value = userProfile.value.copy(
                        isLoadingUserItems = false
                    )
                }
            }
        }
    }


    fun getProfile(userId: String?) {
        viewModelScope.launch {
            _userProfile.value = userProfile.value.copy(
                isLoadingProfile = true
            )
            val result = profileUseCases.getProfile(
                userId ?: getOwnUserId()
            )
            when (result) {
                is Resource.Success -> {
                    _userProfile.value = userProfile.value.copy(
                        profile = result.data,
                        isLoadingProfile = false
                    )
                }
                is Resource.Error -> {
                    _userProfile.value = userProfile.value.copy(
                        isLoadingProfile = false
                    )
                    _eventFlow.emit(
                        UiEvent.ShowSnackBar(
                            uiText = result.uiText ?: UiText.unknownError()
                        )
                    )
                }
            }
        }
    }

    private fun toggleFollowStateForUser(followedUserId: String?) {
        viewModelScope.launch {
            val isFollowing = followingPagingState.value.items.find {
                it.userId == followedUserId
            }?.isFollowing == true


            _followingPagingState.value = followingPagingState.value.copy(
                items = followingPagingState.value.items.map {
                    if(it.userId == followedUserId) {
                        it.copy(isFollowing = !it.isFollowing)
                    } else it
                }
            )

            val result = followedUserId?.let {
                toggleFollowStateForUserUseCase(
                    followedUserId = it,
                    isFollowing = isFollowing
                )
            }
            when(result) {
                is Resource.Success -> Unit
                is Resource.Error -> {
                    _followingPagingState.value = followingPagingState.value.copy(
                        items = followingPagingState.value.items.map {
                            if(it.userId == followedUserId) {
                                it.copy(isFollowing = isFollowing)
                            } else it
                        }
                    )
                    _eventFlow.emit(UiEvent.ShowSnackBar(
                        uiText = result.uiText ?: UiText.unknownError()
                    ))
                }
                else -> {}
            }
        }
    }

}