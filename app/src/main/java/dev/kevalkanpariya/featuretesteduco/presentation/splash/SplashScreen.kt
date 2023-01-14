package dev.kevalkanpariya.featuretesteduco.presentation.splash


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.navigation.Screen


@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {

    val onBoardingCompleted by splashViewModel.onBoardingCompleted.collectAsState()
    LaunchedEffect(key1 = true) {
        navController.popBackStack()
        if (onBoardingCompleted) navController.navigate(Screen.SignInScreen.route)
        else navController.navigate(Screen.WelcomeScreen.route)
    }
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(painter = painterResource(id = R.drawable.educo_logo), contentDescription = "educo logo")
    }

}