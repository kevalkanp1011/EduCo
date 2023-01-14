package dev.kevalkanpariya.featuretesteduco.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import dev.kevalkanpariya.featuretesteduco.presentation.details.DetailsScreen
import dev.kevalkanpariya.featuretesteduco.presentation.home.HomeScreen
import dev.kevalkanpariya.featuretesteduco.presentation.profile.ProfileScreen
import dev.kevalkanpariya.featuretesteduco.presentation.signin.LoginScreen
import dev.kevalkanpariya.featuretesteduco.presentation.splash.SplashScreen
import dev.kevalkanpariya.featuretesteduco.presentation.welcome.WelcomeScreen

@OptIn(ExperimentalCoilApi::class)
@Composable
fun SetUpNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ) {
        composable("splash"){
            SplashScreen(navController)
        }
        composable("home") {
            HomeScreen()
        }
        composable("welcome") {
            WelcomeScreen(navController = navController)
        }
        composable("signin") {
            LoginScreen(navController = navController)
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("details") {
            DetailsScreen()
        }
    }
}