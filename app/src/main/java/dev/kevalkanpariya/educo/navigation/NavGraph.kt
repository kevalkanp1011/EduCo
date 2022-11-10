package dev.kevalkanpariya.educo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.kevalkanpariya.educo.google.GoogleUserModel
import dev.kevalkanpariya.educo.presentation.AuthScreen
import dev.kevalkanpariya.educo.presentation.screens.HomeScreen
import dev.kevalkanpariya.educo.presentation.screens.SearchScreen
import dev.kevalkanpariya.educo.presentation.screens.WelcomeScreen
import dev.kevalkanpariya.educo.presentation.screens.signin.SigninScreen
import dev.kevalkanpariya.educo.presentation.screens.signup.SignupForm
import dev.kevalkanpariya.educo.presentation.screens.signup.SignupScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(navController = navController, startDestination = startDestination) {
        composable("welcome_screen") {
            WelcomeScreen(navController = navController)
        }
        composable("home_screen") {
            // Directly extract the argument from previousBackStackEntry
            var googleUserModel = navController.previousBackStackEntry?.arguments?.getParcelable<GoogleUserModel>("account")

            // Using that Parcelable in the destination Composable
            if (googleUserModel != null) {
                HomeScreen(navController = navController, userModel = googleUserModel)
            }
        }
        composable("login_screen") {
            SigninScreen(onClick = { /*TODO*/ }, errorText = "Account Not Found", navController)
        }
        composable("register_screen") {
            SignupScreen(errorText = "Account Not Found", navController)
        }
        composable("signup_form") {
            SignupForm()
        }
        composable("search_screen") {
            SearchScreen()
        }
        composable("auth_screen") {
            AuthScreen(navController = navController)
        }
    }
}
/*
@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "welcome_screen"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("welcome_screen") {
            WelcomeScreen(navController = navController)
        }
        /*composable("login_screen") {
            val authModel = AuthViewModel()
            LoginScreen(authViewModel = authModel, navController = navController)
        }*/
        composable("home_screen") {
            HomeScreen(
                userModel = GoogleUserModel("keval", "kevalkanpariya5051@gmail.com"),
                navController = navController
            )
        }
        composable("search_screen") {
            SearchScreen()
        }
    }
}*/