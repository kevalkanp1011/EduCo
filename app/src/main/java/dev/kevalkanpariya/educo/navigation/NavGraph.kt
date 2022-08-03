package dev.kevalkanpariya.educo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.kevalkanpariya.educo.screens.LoginScreen
import dev.kevalkanpariya.educo.screens.WelcomeScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {

        composable(route = Screen.Welcome.route) {
            WelcomeScreen()
        }
        composable(route = Screen.Login.route) {
            LoginScreen()
        }
    }
}

