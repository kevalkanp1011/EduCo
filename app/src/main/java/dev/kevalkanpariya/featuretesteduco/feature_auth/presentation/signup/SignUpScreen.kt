package dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.signup

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.asString
import dev.kevalkanpariya.featuretesteduco.core.util.Constants
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.util.AuthError
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.StandardTextField
import dev.kevalkanpariya.featuretesteduco.ui.theme.SpaceLarge
import dev.kevalkanpariya.featuretesteduco.ui.theme.SpaceMedium
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SignUpScreen(
    scaffoldState: ScaffoldState,
    onPopBackStack: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) {
    val usernameState = viewModel.usernameState.value
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val registerState = viewModel.registerState.value
    val context = LocalContext.current

    val keyboardController = LocalSoftwareKeyboardController.current

    LaunchedEffect(key1 = true) {
        viewModel.onRegister.collect {
            onPopBackStack()
        }
    }
    LaunchedEffect(key1 = keyboardController) {
        viewModel.eventFlow.collectLatest { event ->
            when(event) {
                is UiEvent.ShowSnackBar -> {
                    keyboardController?.hide()
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.uiText.asString(context),
                        duration = SnackbarDuration.Long
                    )
                }
                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
        ) {
            Text(
                text = stringResource(id = R.string.signup),
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    viewModel.onEvent(SignUpEvent.EnteredEmail(it))
                },
                error = when (emailState.error) {
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.error_field_empty)
                    }
                    is AuthError.InvalidEmail -> {
                        stringResource(id = R.string.not_a_valid_email)
                    }
                    else -> ""
                },
                keyboardType = KeyboardType.Email,
                hint = stringResource(id = R.string.email)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = usernameState.text,
                onValueChange = {
                    viewModel.onEvent(SignUpEvent.EnteredUsername(it))
                },
                error = when (viewModel.usernameState.value.error) {
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.error_field_empty)
                    }
                    is AuthError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short, Constants.MIN_USERNAME_LENGTH)
                    }
                    else -> ""
                },
                hint = stringResource(id = R.string.username)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(SignUpEvent.EnteredPassword(it))
                },
                hint = stringResource(id = R.string.password_hint),
                keyboardType = KeyboardType.Password,
                error = when (passwordState.error) {
                    is AuthError.FieldEmpty -> {
                        stringResource(id = R.string.error_field_empty)
                    }
                    is AuthError.InputTooShort -> {
                        stringResource(id = R.string.input_too_short, Constants.MIN_PASSWORD_LENGTH)
                    }
                    is AuthError.InvalidPassword -> {
                        stringResource(id = R.string.invalid_password)
                    }
                    else -> ""
                },
                isPasswordVisible = passwordState.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(SignUpEvent.TogglePasswordVisibility)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    viewModel.onEvent(SignUpEvent.SignUp)
                },
                enabled = !registerState.isLoading,
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.signup),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            if(registerState.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(CenterHorizontally)
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.already_have_an_account))
                append(" ")
                val signUpText = stringResource(id = R.string.sign_in)
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append(signUpText)
                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    onPopBackStack()
                }
        )
    }

}