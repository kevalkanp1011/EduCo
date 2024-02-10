package dev.kevalkanpariya.educo.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.kevalkanpariya.educo.presentation.screens.AuthScreen
import dev.kevalkanpariya.educo.presentation.screens.HomeScreen
import dev.kevalkanpariya.educo.presentation.screens.WelcomeScreen
import dev.kevalkanpariya.educo.presentation.screens.search.SearchScreen
import dev.kevalkanpariya.educo.presentation.screens.signin.SigninScreen
import dev.kevalkanpariya.educo.presentation.screens.signup.SignupScreen
import dev.kevalkanpariya.educo.presentation.viewmodel.SharedViewModel

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    val sharedViewModel: SharedViewModel = viewModel()
    NavHost(navController = navController, startDestination = startDestination) {
        composable("welcome_screen") {
            WelcomeScreen(navController = navController, sharedViewModel)
        }
        composable("home_screen") {
            HomeScreen(navController = navController, sharedViewModel = sharedViewModel)
        }
        composable("login_screen") {
            SigninScreen(onClick = { /*TODO*/ }, errorText = "Account Not Found", navController)
        }
        composable("register_screen") {
            SignupScreen(errorText = "Account Not Found", navController)
        }
        composable("signup_form") {
            //
        }
        composable("search_screen") {
            SearchScreen()
        }
        composable("auth_screen") {
            AuthScreen()
        }
    }
}
