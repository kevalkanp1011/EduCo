package dev.kevalkanpariya.featuretesteduco.feature_settings.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.StandardTextField
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.asString
import dev.kevalkanpariya.featuretesteduco.ui.theme.*
import kotlinx.coroutines.flow.collectLatest

@Composable
fun PasswordChangeScreen(
    onNavigateUp: () -> Unit = {},
    viewModel: SettingsViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState
) {
    var oldPasswordState = viewModel.oldPasswordState.value
    var newPassword =viewModel.newPasswordState.value
    var confirmPassword =viewModel.confirmPasswordState.value


    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
                is UiEvent.OnResetPassword -> {
                    onNavigateUp()
                }
                else -> {}
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { onNavigateUp() },
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = "back_icon")
            }
            Text(text = "Password change", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        }
        Column(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(50.dp))
            StandardTextField(
                text = oldPasswordState.text,
                onValueChange = {
                    viewModel.onEvent(SettingsEvent.EnteredOldPassword(it))
                },
                hint = "Enter old password",
                backgroundColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth(),
            )
            Spacer(modifier = Modifier.height(20.dp))
            StandardTextField(
                text = newPassword.text,
                onValueChange = {
                    viewModel.onEvent(SettingsEvent.EnteredNewPassword(it))
                },
                hint = "new password",
                backgroundColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth(),

            )
            Spacer(modifier = Modifier.height(20.dp))
            StandardTextField(
                text = confirmPassword.text,
                onValueChange = {
                    viewModel.onEvent(SettingsEvent.EnteredConfirmPassword(it))
                },
                hint = "confirm your password",
                backgroundColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth(),

            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = { viewModel.onEvent(SettingsEvent.Reset) },
                colors = ButtonDefaults.buttonColors(backgroundColor = Primary600),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            ) {
                Text(
                    text = "Reset",
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }

        }
    }
}
