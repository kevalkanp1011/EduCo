package dev.kevalkanpariya.featuretesteduco.feature_settings.presentation

import android.net.Uri
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.core.domain.states.StandardTextFieldState
import dev.kevalkanpariya.featuretesteduco.core.domain.use_case.GetOwnUserIdUseCase
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.ResetPasswordUseCase
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.UpdateProfileData
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case.ProfileUseCases
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val getOwnUserId: GetOwnUserIdUseCase,
    private val profileUseCases: ProfileUseCases,
    private val resetPasswordUseCase: ResetPasswordUseCase,
): ViewModel() {
    private val _oldPasswordState = mutableStateOf(StandardTextFieldState())
    val oldPasswordState: State<StandardTextFieldState> = _oldPasswordState
    private val _newPasswordState = mutableStateOf(StandardTextFieldState())
    val newPasswordState: State<StandardTextFieldState> = _newPasswordState
    private val _confirmPasswordState = mutableStateOf(StandardTextFieldState())
    val confirmPasswordState: State<StandardTextFieldState> = _confirmPasswordState

    private val _usernameState = mutableStateOf(StandardTextFieldState())
    val usernameState: State<StandardTextFieldState> = _usernameState
    private val _bioState = mutableStateOf(StandardTextFieldState())
    val bioState: State<StandardTextFieldState> = _bioState
    private val _instagramUrlState = mutableStateOf(StandardTextFieldState())
    val instagramUrlState: State<StandardTextFieldState> = _instagramUrlState
    private val _facebookUrlState = mutableStateOf(StandardTextFieldState())
    val facebookUrlState: State<StandardTextFieldState> = _facebookUrlState
    private val _twitterUrlState = mutableStateOf(StandardTextFieldState())
    val twitterUrlState: State<StandardTextFieldState> = _twitterUrlState

    val selectedImageUri = mutableStateOf<Uri?>(null)


    private val _checkedState = mutableStateOf(true)
    val checkedState: State<Boolean> = _checkedState

    private val _resetState = mutableStateOf(ResetState())
    val resetState: State<ResetState> = _resetState

    private val _profileSettingsState = mutableStateOf(ProfileSettingsState())
    val profileSettingsState: State<ProfileSettingsState> = _profileSettingsState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun onEvent(event: SettingsEvent) {
        when(event) {
            is SettingsEvent.OnChecked -> {
                _checkedState.value = event.isChecked
            }
            is SettingsEvent.EnteredOldPassword -> {
                _oldPasswordState.value = oldPasswordState.value.copy(
                    text = event.oldPassword
                )
            }
            is SettingsEvent.EnteredNewPassword -> {
                _newPasswordState.value = newPasswordState.value.copy(
                    text = event.newPassword
                )
            }
            is SettingsEvent.EnteredConfirmPassword -> {
                _confirmPasswordState.value = confirmPasswordState.value.copy(
                    text = event.confirmPassword
                )
            }

            is SettingsEvent.TogglePasswordVisibility -> {
                _resetState.value = resetState.value.copy(
                    isPasswordVisible = !resetState.value.isPasswordVisible
                )
            }

            is SettingsEvent.EnteredUsername -> {
                _usernameState.value = usernameState.value.copy(
                    text = event.username
                )
            }

            is SettingsEvent.EnteredBio -> {
                _bioState.value = bioState.value.copy(
                    text = event.bio
                )
            }

            is SettingsEvent.EnteredInstagramUrl -> {
                _instagramUrlState.value = instagramUrlState.value.copy(
                    text = event.instagramUrl
                )
            }

            is SettingsEvent.EnteredFacebookUrl -> {
                _facebookUrlState.value = facebookUrlState.value.copy(
                    text = event.facebookUrl
                )
            }

            is SettingsEvent.EnteredTwitterUrl -> {
                _twitterUrlState.value = twitterUrlState.value.copy(
                    text = event.twitterUrl
                )
            }


            is SettingsEvent.Reset -> {
                viewModelScope.launch {
                    _resetState.value = resetState.value.copy(isLoading = true)
                    val resetResult = resetPasswordUseCase(
                        oldPassword = oldPasswordState.value.text,
                        newPassword = newPasswordState.value.text,
                        confirmPassword = confirmPasswordState.value.text
                    )
                    _resetState.value = resetState.value.copy(isLoading = false)
                    if(resetResult.oldPasswordError != null) {
                        _oldPasswordState.value = oldPasswordState.value.copy(
                            error = resetResult.oldPasswordError
                        )
                    }
                    if(resetResult.newPasswordError != null) {
                        _newPasswordState.value = newPasswordState.value.copy(
                            error = resetResult.newPasswordError
                        )
                    }
                    if(resetResult.confirmPasswordError != null) {
                        _confirmPasswordState.value = confirmPasswordState.value.copy(
                            error = resetResult.confirmPasswordError
                        )
                    }
                    when(resetResult.result) {
                        is Resource.Success -> {
                            _eventFlow.emit(UiEvent.OnResetPassword)
                        }
                        is Resource.Error -> {
                            _eventFlow.emit(
                                UiEvent.ShowSnackBar(
                                    resetResult.result.uiText ?: UiText.unknownError()
                                )
                            )
                        }
                        else -> Unit
                    }

                }
            }

            is SettingsEvent.Save -> {
                viewModelScope.launch {
                    val result = profileSettingsState.value.profileSettingsData?.let {
                        profileUseCases.updateProfile(
                            updateProfileData = it,
                            bannerImageUri = selectedImageUri.value,
                            profilePictureUri = selectedImageUri.value,
                            context = event.context,
                        )
                    }

                    when(result) {
                        is Resource.Success -> {
                            _eventFlow.emit(
                                    UiEvent.ShowSnackBar(
                                        result.uiText ?: UiText.unknownError()
                                    )
                                    )
                        }
                        is Resource.Error -> {
                            _eventFlow.emit(
                                UiEvent.ShowSnackBar(
                                    result.uiText ?: UiText.unknownError()
                                )
                            )
                        }
                        else -> {}
                    }
                }
            }

            is SettingsEvent.Cancel -> {
                viewModelScope.launch {

                    selectedImageUri.value = null
                    _usernameState.value = usernameState.value.copy(
                        text = ""
                    )
                    _bioState.value = bioState.value.copy(
                        text = ""
                    )
                    _instagramUrlState.value = instagramUrlState.value.copy(
                        text = ""
                    )
                    _facebookUrlState.value = facebookUrlState.value.copy(
                        text = ""
                    )
                    _twitterUrlState.value = twitterUrlState.value.copy(
                        text = ""
                    )
                }
            }

            is SettingsEvent.SignOut -> {
                viewModelScope.launch {
                    profileUseCases.logout
                    _eventFlow.emit(
                        UiEvent.OnSignOut
                    )
                }
            }
        }
    }

    init {
        loadProfileSettingsData()
    }



    fun loadProfileSettingsData() {
        viewModelScope.launch {
            _profileSettingsState.value = profileSettingsState.value.copy(
                isLoading = true
            )
            val result = profileUseCases.getProfile(
                userId = getOwnUserId()
            )

            when(result) {
                is Resource.Success -> {
                    _profileSettingsState.value = profileSettingsState.value.copy(
                        profileSettingsData =  result.data?.toUpdateProfileData(),
                        isLoading = false
                    )
                }
                is Resource.Error -> {
                    _profileSettingsState.value = profileSettingsState.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }


}