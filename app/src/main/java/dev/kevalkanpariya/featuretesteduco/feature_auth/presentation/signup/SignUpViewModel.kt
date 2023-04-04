package dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.states.PasswordTextFieldState
import dev.kevalkanpariya.featuretesteduco.core.domain.states.StandardTextFieldState
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.SignUpUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signupUseCase: SignUpUseCase
) : ViewModel() {

    private val _emailState = mutableStateOf(StandardTextFieldState())
    val emailState: State<StandardTextFieldState> = _emailState

    private val _usernameState = mutableStateOf(StandardTextFieldState())
    val usernameState: State<StandardTextFieldState> = _usernameState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _registerState = mutableStateOf(RegisterState())
    val registerState: State<RegisterState> = _registerState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _onRegister = MutableSharedFlow<Unit>(replay = 1)
    val onRegister = _onRegister.asSharedFlow()

    fun onEvent(event: SignUpEvent) {
        when(event) {
            is SignUpEvent.EnteredUsername -> {
                _usernameState.value = _usernameState.value.copy(
                    text = event.value
                )
            }
            is SignUpEvent.EnteredEmail -> {
                _emailState.value = _emailState.value.copy(
                    text = event.value
                )
            }
            is SignUpEvent.EnteredPassword -> {
                _passwordState.value = _passwordState.value.copy(
                    text = event.value
                )
            }
            is SignUpEvent.TogglePasswordVisibility -> {
                _passwordState.value = _passwordState.value.copy(
                    isPasswordVisible = !passwordState.value.isPasswordVisible
                )
            }
            is SignUpEvent.SignUp -> {
                signUp()
            }
        }
    }

    private fun signUp() {
        viewModelScope.launch {
            _usernameState.value = usernameState.value.copy(error = null)
            _emailState.value = emailState.value.copy(error = null)
            _passwordState.value = passwordState.value.copy(error = null)
            _registerState.value = RegisterState(isLoading = true)
            val signUpResult = signupUseCase(
                email = emailState.value.text,
                username = usernameState.value.text,
                password = passwordState.value.text
            )
            if(signUpResult.emailError != null) {
                _emailState.value = emailState.value.copy(
                    error = signUpResult.emailError
                )
            }
            if(signUpResult.usernameError != null) {
                _usernameState.value = _usernameState.value.copy(
                    error = signUpResult.usernameError
                )
            }
            if(signUpResult.passwordError != null) {
                _passwordState.value = _passwordState.value.copy(
                    error = signUpResult.passwordError
                )
            }
            when(signUpResult.result) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvent.ShowSnackBar(UiText.StringResource(R.string.success_registration))
                    )
                    _onRegister.emit(Unit)
                    _registerState.value = RegisterState(isLoading = false)
                    _usernameState.value = StandardTextFieldState()
                    _emailState.value = StandardTextFieldState()
                    _passwordState.value = PasswordTextFieldState()
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.ShowSnackBar(signUpResult.result.uiText ?: UiText.unknownError())
                    )
                    _registerState.value = RegisterState(isLoading = false)
                }
                null -> {
                    _registerState.value = RegisterState(isLoading = false)
                }
            }
        }
    }

}