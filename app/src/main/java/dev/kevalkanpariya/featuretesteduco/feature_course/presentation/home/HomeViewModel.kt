package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Category
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.domain.states.StandardTextFieldState
import dev.kevalkanpariya.featuretesteduco.core.domain.use_case.GetOwnUserIdUseCase
import dev.kevalkanpariya.featuretesteduco.core.presentation.PagingState
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.StandardTextField
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.util.DefaultPaginator
import dev.kevalkanpariya.featuretesteduco.core.util.Event
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case.GetMostWatchedCourseUseCase
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case.GetPopularCategoriesUseCase
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.use_case.SearchCoursesUseCase
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case.GetProfileHeaderUseCase
import dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.profile.ProfileHeaderState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProfileHeader: GetProfileHeaderUseCase,
    private val getOwnUserId: GetOwnUserIdUseCase,
    private val getCategories: GetPopularCategoriesUseCase,
    private val getMostWatchedCourseUseCase: GetMostWatchedCourseUseCase,
    private val searchCourses: SearchCoursesUseCase
): ViewModel() {

    private val _eventFlow = MutableSharedFlow<Event>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _profileHeaderState = mutableStateOf(ProfileHeaderState())
    val profileHeaderState: State<ProfileHeaderState> = _profileHeaderState

    private val _categoryPagingState = mutableStateOf<PagingState<Category>>(PagingState())
    val categoryPagingState: State<PagingState<Category>> = _categoryPagingState

    private val _mostWatchedCoursePagingState = mutableStateOf<PagingState<CourseOverview>>(PagingState())
    val mostWatchedCoursePagingState: State<PagingState<CourseOverview>> = _mostWatchedCoursePagingState

    private val _searchQuery = mutableStateOf(StandardTextFieldState())
    val searchQuery: State<StandardTextFieldState> = _searchQuery
    private val _searchCoursesPagingState = mutableStateOf<PagingState<CourseOverview>>(PagingState())
    val searchCoursesPagingState: State<PagingState<CourseOverview>> = _searchCoursesPagingState


    fun onEvent(event: HomeEvent) {
        when(event) {
            is HomeEvent.EnteredSearchQuery -> {
                _searchQuery.value = searchQuery.value.copy(
                    text = event.query
                )
            }
        }

    }

    private val searchCoursesPaginator = DefaultPaginator(
        onLoadUpdated = { isLoading ->
            _searchCoursesPagingState.value = searchCoursesPagingState.value.copy(
                isLoading = isLoading
            )
        },
        onRequest = { page ->
            searchCourses(page = page, query = searchQuery.value.text)
        },
        onSuccess = { courses ->
            _searchCoursesPagingState.value = searchCoursesPagingState.value.copy(
                items = searchCoursesPagingState.value.items + courses,
                endReached = courses.isEmpty(),
                isLoading = false
            )
        },
        onError = { uiText ->
            _eventFlow.emit(UiEvent.ShowSnackBar(uiText))
        }
    )

    private val categoryPaginator = DefaultPaginator(
        onLoadUpdated = { isLoading ->
            _categoryPagingState.value = categoryPagingState.value.copy(
                isLoading = isLoading
            )
        },
        onRequest = { page ->
            getCategories(page = page)
        },
        onSuccess = { posts ->
            _categoryPagingState.value = categoryPagingState.value.copy(
                items = categoryPagingState.value.items + posts,
                endReached = posts.isEmpty(),
                isLoading = false
            )
        },
        onError = { uiText ->
            _eventFlow.emit(UiEvent.ShowSnackBar(uiText))
        }
    )

    private val mostWatchedCoursePaginator = DefaultPaginator(
        onLoadUpdated = { isLoading ->
            _mostWatchedCoursePagingState.value = mostWatchedCoursePagingState.value.copy(
                isLoading = isLoading
            )
        },
        onRequest = { page ->
            getMostWatchedCourseUseCase(page = page)
        },
        onSuccess = { posts ->
            _mostWatchedCoursePagingState.value = mostWatchedCoursePagingState.value.copy(
                items = mostWatchedCoursePagingState.value.items + posts,
                endReached = posts.isEmpty(),
                isLoading = false
            )
        },
        onError = { uiText ->
            _eventFlow.emit(UiEvent.ShowSnackBar(uiText))
        }
    )


    init {
        getProfileHeader()
        loadNextCategories()
        loadNextMostWatchedCourses()
        loadNextSearchCourses()
    }

    fun loadNextSearchCourses() {
        viewModelScope.launch {
            searchCoursesPaginator.loadNextItems()
        }
    }


     fun loadNextMostWatchedCourses() {
        viewModelScope.launch {
            mostWatchedCoursePaginator.loadNextItems()
        }
    }

    fun loadNextCategories() {
        viewModelScope.launch {
            categoryPaginator.loadNextItems()
        }
    }

    private fun getProfileHeader() {
        viewModelScope.launch {
            _profileHeaderState.value = profileHeaderState.value.copy(
                isLoading = true
            )
            val result = getProfileHeader(getOwnUserId())
            when (result) {
                is Resource.Success -> {
                    _profileHeaderState.value = profileHeaderState.value.copy(
                        profileHeader = result.data,
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _profileHeaderState.value = profileHeaderState.value.copy(
                        isLoading = false
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
}
