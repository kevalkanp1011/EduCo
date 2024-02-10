package dev.kevalkanpariya.educo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.kevalkanpariya.educo.navigation.SetUpNavGraph
import dev.kevalkanpariya.educo.presentation.viewmodel.SplashViewModel
import dev.kevalkanpariya.educo.ui.theme.EduCoTheme
import javax.inject.Inject


@AndroidEntryPoint
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
                SetUpNavGraph(navController = navController, startDestination = screen)
            }
        }





    }

}