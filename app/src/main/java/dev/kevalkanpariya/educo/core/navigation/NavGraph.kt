package dev.kevalkanpariya.educo.core.navigation


import android.app.Activity
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import dev.kevalkanpariya.educo.feature_auth.presentation.events.AuthEvent
import dev.kevalkanpariya.educo.feature_auth.presentation.viewmodels.AuthViewModel
import dev.kevalkanpariya.educo.presentation.screens.home.HomeScreen
import dev.kevalkanpariya.educo.presentation.screens.on_bording.OnBoardingScreen
import dev.kevalkanpariya.educo.presentation.screens.search.SearchScreen
import dev.kevalkanpariya.educo.feature_auth.presentation.screens.SignInScreen
import dev.kevalkanpariya.educo.feature_auth.presentation.screens.SignUpWithEmailScreen
import dev.kevalkanpariya.educo.feature_auth.presentation.screens.SignupScreen
import org.koin.android.ext.android.inject


@Composable
fun SetUpNavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String,
    appRef: Application
) {


    NavHost(navController = navController, startDestination = startDestination, route = "root") {

        composable(Routes.OnboardingScreen.route) {
            OnBoardingScreen(
                onNavigate = navController::navigate
            )
        }

        authNavGraph(navController = navController, appRef = appRef)

        mainNavGraph(navController = navController)


    }
}


fun NavGraphBuilder.authNavGraph(
    navController: NavHostController,
    appRef: Application
) {

    //create an authviewmodel only accesible to auth navgraph

    navigation(route = "auth", startDestination = Routes.SignInScreen.route) {


        val authViewModel by appRef.inject<AuthViewModel>()

        composable(route = Routes.SignUpScreen.route) {

            val context = LocalContext.current as Activity

            SignupScreen(
                errorText = "Account Not Found",
                onSignInClicked = {
                },
                onSignUpWithFormClicked = {

                },
                onSignUpWithGoogleClicked = {
                    authViewModel.onEvent(AuthEvent.OnSignInWithGoogleClicked(context))
                }
            )
        }

        composable(route = Routes.SignInScreen.route) {

            val context = LocalContext.current as Activity

            var username by remember { mutableStateOf("") }
            var pwd by remember { mutableStateOf("") }
            SignInScreen(
                errorText = null,
                username = username,
                password = pwd,
                onUsernameChanged = {},
                onPasswordChanged = {},
                onSignInWithGoogleClicked = {
                    authViewModel.onEvent(AuthEvent.OnSignInWithGoogleClicked(context))
                }
            )
        }

        composable(Routes.SignUpWithEmailScreen.route) {
            SignUpWithEmailScreen()
        }

        composable(Routes.ResetPasswordScreen.route) {

        }
    }


}

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController
) {

    navigation(route = "main", startDestination = Routes.SignInScreen.route) {

        composable(route = Routes.HomeScreen.route) {
            HomeScreen()
        }

        composable("search_screen") {
            SearchScreen()
        }
    }


}
