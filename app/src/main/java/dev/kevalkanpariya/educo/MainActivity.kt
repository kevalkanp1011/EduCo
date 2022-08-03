package dev.kevalkanpariya.educo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import dev.kevalkanpariya.educo.navigation.SetupNavGraph
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import dev.kevalkanpariya.educo.ui.theme.EduCoTheme
import dev.kevalkanpariya.educo.viewmodel.SplashViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }

        setContent {
            EduCoTheme {
                val screen by splashViewModel.startDestination
                val navController = rememberNavController()
                SetupNavGraph(navController = navController, startDestination = screen)
            }
        }
    }
}