package dev.kevalkanpariya.featuretesteduco.presentation.signin

import android.annotation.SuppressLint
import android.app.Activity
import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.kevalkanpariya.featuretesteduco.domain.model.ApiRequest
import dev.kevalkanpariya.featuretesteduco.domain.model.ApiResponse
import dev.kevalkanpariya.featuretesteduco.navigation.Screen
import dev.kevalkanpariya.featuretesteduco.presentation.common.StartActivityForResult
import dev.kevalkanpariya.featuretesteduco.presentation.common.signIn
import dev.kevalkanpariya.featuretesteduco.util.RequestState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    val signedInState by loginViewModel.signedInState
    val messageBarState by loginViewModel.messageBarState
    val apiResponse by loginViewModel.apiResponse

    Log.d("LoginScreen", apiResponse.toString())

    Scaffold(
        topBar = {
            LoginTopBar()
        },
        content = {
            LoginContent(
                signedInState = signedInState,
                messageBarState = messageBarState,
                onButtonClicked = {
                    loginViewModel.saveSignedInState(signedIn = true)
                }
            )
        }
    )

    val activity = LocalContext.current as Activity

    StartActivityForResult(
        key = signedInState,
        onResultReceived = { tokenId ->
            loginViewModel.verifyTokenOnBackend(
                request = ApiRequest(tokenId = tokenId)
            )
        },
        onDialogDismissed = {
            loginViewModel.saveSignedInState(signedIn = false)
        }
    ) { activityLauncher ->
        if (signedInState) {
            signIn(
                activity = activity,
                launchActivityResult = { intentSenderRequest ->
                    activityLauncher.launch(intentSenderRequest)
                },
                accountNotFound = {
                    loginViewModel.saveSignedInState(signedIn = false)
                    loginViewModel.updateMessageBarState()
                }
            )
        }
    }

    LaunchedEffect(key1 = apiResponse) {
        when (apiResponse) {
            is RequestState.Success -> {
                val response = (apiResponse as RequestState.Success<ApiResponse>).data.success
                if (response) {
                    Log.d("LoginScreen", "Response Received from Server and server has approved request to Authenticate")
                    navigateToHomeScreen(navController = navController)
                } else {
                    Log.d("LoginScreen", "Response Received from Server but server Refused to Authenticate")
                    loginViewModel.saveSignedInState(signedIn = false)
                }
            }
            else -> {}
        }
    }
}

private fun navigateToProfileScreen(
    navController: NavHostController
) {
    navController.navigate(route = Screen.ProfileScreen.route) {
        popUpTo(route = Screen.SignInScreen.route) {
            inclusive = true
        }
    }
}

private fun navigateToHomeScreen(
    navController: NavHostController
) {
    navController.navigate(route = Screen.HomeScreen.route) {
        popUpTo(route = Screen.SignInScreen.route) {
            inclusive = true
        }
    }
}