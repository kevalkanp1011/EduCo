package dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.signin

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.core.domain.states.StandardTextFieldState
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.SignInUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    private val _emailState = mutableStateOf(StandardTextFieldState())
    val emailState: State<StandardTextFieldState> = _emailState

    private val _passwordState = mutableStateOf(StandardTextFieldState())
    val passwordState: State<StandardTextFieldState> = _passwordState

    private val _signInState = mutableStateOf(SignInState())
    val signInState: State<SignInState> = _signInState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: SignInEvent) {
        when(event) {
            is SignInEvent.EnteredEmail -> {
                _emailState.value = emailState.value.copy(
                    text = event.email
                )
            }
            is SignInEvent.EnteredPassword -> {
                _passwordState.value = passwordState.value.copy(
                    text = event.password
                )
            }
            is SignInEvent.TogglePasswordVisibility -> {
                _signInState.value = signInState.value.copy(
                    isPasswordVisible = !signInState.value.isPasswordVisible
                )
            }
            is SignInEvent.SignIn -> {
                viewModelScope.launch {
                    _signInState.value = signInState.value.copy(isLoading = true)
                    val signInResult = signInUseCase(
                        email = emailState.value.text,
                        password = passwordState.value.text
                    )

                    _signInState.value = signInState.value.copy(isLoading = false)
                    if(signInResult.emailError != null) {
                        _emailState.value = emailState.value.copy(
                            error = signInResult.emailError
                        )
                    }
                    if(signInResult.passwordError != null) {
                        _passwordState.value = _passwordState.value.copy(
                            error = signInResult.passwordError
                        )
                    }
                    when(signInResult.result) {
                        is Resource.Success -> {
                            _eventFlow.emit(UiEvent.OnSignIn)
                        }
                        is Resource.Error -> {
                            _eventFlow.emit(
                                UiEvent.ShowSnackBar(
                                    signInResult.result.uiText ?: UiText.unknownError()
                                )
                            )
                        }

                        else -> {}
                    }
                }
            }
        }
    }
}