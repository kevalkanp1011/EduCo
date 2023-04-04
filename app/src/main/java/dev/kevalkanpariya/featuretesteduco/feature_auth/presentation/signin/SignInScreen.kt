package dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.signin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.kevalkanpariya.featuretesteduco.R.string
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.asString
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.util.AuthError
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.StandardTextField

import dev.kevalkanpariya.featuretesteduco.ui.theme.SpaceLarge
import dev.kevalkanpariya.featuretesteduco.ui.theme.SpaceMedium
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SignInScreen(
    scaffoldState: ScaffoldState,
    onNavigate: (String) -> Unit = {},
    onSignIn: () -> Unit = {},
    viewModel: SignInViewModel = hiltViewModel()
) {
    val emailState = viewModel.emailState.value
    val passwordState = viewModel.passwordState.value
    val state = viewModel.signInState.value
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
                is UiEvent.Navigate -> {
                    onNavigate(event.route)
                }
                is UiEvent.OnSignIn -> {
                    onSignIn()
                }
                else -> {}
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
                text = stringResource(id = string.login),
                style = MaterialTheme.typography.h2
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = emailState.text,
                onValueChange = {
                    viewModel.onEvent(SignInEvent.EnteredEmail(it))
                },
                keyboardType = KeyboardType.Email,
                error = when (emailState.error) {
                    is AuthError.FieldEmpty -> stringResource(id = string.error_field_empty)
                    else -> ""
                },
                hint = stringResource(id = string.login_hint)
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = passwordState.text,
                onValueChange = {
                    viewModel.onEvent(SignInEvent.EnteredPassword(it))
                },
                hint = stringResource(id = string.password_hint),
                keyboardType = KeyboardType.Password,
                error = when (passwordState.error) {
                    is AuthError.FieldEmpty -> stringResource(id = string.error_field_empty)
                    else -> ""
                },
                isPasswordVisible = state.isPasswordVisible,
                onPasswordToggleClick = {
                    viewModel.onEvent(SignInEvent.TogglePasswordVisibility)
                }
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    viewModel.onEvent(SignInEvent.SignIn)
                },
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = string.login),
                    color = MaterialTheme.colors.onPrimary
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = string.dont_have_an_account_yet))
                append(" ")
                val signUpText = stringResource(id = string.sign_up)
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
                    onNavigate(
                        Screen.SignUpScreen.route
                    )
                }
        )
    }

}