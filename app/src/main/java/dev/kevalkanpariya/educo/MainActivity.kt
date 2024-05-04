package dev.kevalkanpariya.educo

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import dev.kevalkanpariya.educo.feature_course.domain.repository.CourseRepository
import dev.kevalkanpariya.educo.core.navigation.Routes
import dev.kevalkanpariya.educo.core.navigation.SetUpNavGraph
import dev.kevalkanpariya.educo.ui.theme.EduCoTheme
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var splashViewModel: SplashViewModel

    val userActSharedPref by inject<SharedPreferences>()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        installSplashScreen().setKeepOnScreenCondition {
//            !splashViewModel.isLoading.value
//        }




//
//        val isUserLoggedIn = userActSharedPref.getBoolean("is_user_logged_in", false)
//        val isUserDoneOnboarding = userActSharedPref.getBoolean("is_user_done_onboarding", false)
//
//        val startDestination = if (isUserLoggedIn) {
//            Routes.HomeScreen.route
//        } else {
//            if (isUserDoneOnboarding) {
//                Routes.SignInScreen.route
//            } else {
//                Routes.OnboardingScreen.route
//            }
//        }


        setContent {

            EduCoTheme {

                SetUpNavGraph(
                    startDestination = "auth",
                    appRef = application
                )
            }
        }





    }

}