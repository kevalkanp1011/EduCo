package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.signin.SignInScreen
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.signup.SignUpScreen
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.splash.SplashScreen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.category_list.PopularCategoryListScreen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_detail.CourseDetailScreen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_list.MostWatchedCourseListScreen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home.HomeScreen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.saved.SavedScreen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.search.FilterScreen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.search.SearchResultScreen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.search.SearchScreen
import dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.profile.ProfileScreen
import dev.kevalkanpariya.featuretesteduco.feature_settings.presentation.*

@OptIn(ExperimentalCoilApi::class)
@Composable
fun Navigation(
    imageLoader: ImageLoader,
    navController: NavHostController,
    scaffoldState: ScaffoldState,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignInScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {

        composable(Screen.SplashScreen.route) {
            SplashScreen(
                onPopBackStack = navController::popBackStack,
                onNavigate = navController::navigate
            )
        }

        composable(Screen.SignInScreen.route) {
            SignInScreen(
                onNavigate = navController::navigate,
                onSignIn = {
                    navController.popBackStack(
                        route = Screen.SignInScreen.route,
                        inclusive = true
                    )
                    navController.navigate(route = Screen.HomeScreen.route)
                },
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.SignUpScreen.route) {
            SignUpScreen(
                scaffoldState = scaffoldState,
                onPopBackStack = navController::popBackStack
            )
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen(
                onNavigate = navController::navigate,
                imageLoader = imageLoader,
                scaffoldState = scaffoldState
            )
        }

        composable(Screen.PopularCategoryListScreen.route) {
            PopularCategoryListScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
                imageLoader = imageLoader
            )
        }

        composable(Screen.MostWatchedCourseListScreen.route) {
            MostWatchedCourseListScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
                imageLoader = imageLoader,

                )
        }


        composable(
            route = Screen.CourseDetailScreen.route + "/{courseId}?shouldShowKeyboard={shouldShowKeyboard}",
            arguments = listOf(
                navArgument(
                    name = "courseId"
                ) {
                    type = NavType.StringType
                },
                navArgument(
                    name = "shouldShowKeyboard"
                ) {
                    type = NavType.BoolType
                    defaultValue = false
                }
            ),
        ) {
            val shouldShowKeyboard = it.arguments?.getBoolean("shouldShowKeyboard") ?: false
            println("COURSE ID: ${it.arguments?.getString("courseId")}")
            CourseDetailScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
                scaffoldState = scaffoldState,
                imageLoader = imageLoader,
                shouldShowKeyboard = shouldShowKeyboard
            )
        }

        composable(Screen.SearchScreen.route) {
            SearchScreen(imageLoader = imageLoader, onNavigate = navController::navigate)
        }

        composable(Screen.SearchResultScreen.route) {
            SearchResultScreen(
                imageLoader = imageLoader,
                onNavigate = navController::navigate
            )
        }

        composable(Screen.FilterScreen.route) {
            FilterScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp
            )
        }

        composable(Screen.SavedScreen.route) {
            SavedScreen(
                imageLoader = imageLoader,
                onNavigate = navController::navigate
            )
        }

        composable(
            route = Screen.ProfileScreen.route + "?userId={userId}",
            arguments = listOf(
                navArgument(name = "userId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) {
            println("USER ID: ${it.arguments?.getString("userId")}")
            val userId = it.arguments?.getString("userId")
            ProfileScreen(
                onNavigate = navController::navigate,
                imageLoader = imageLoader,
                scaffoldState = scaffoldState,
                userId = userId
            )
        }

        composable(
            route = Screen.EditProfileScreen.route,
        ) {
            EditProfileScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
                imageLoader = imageLoader,
                scaffoldState = scaffoldState
            )
        }

        composable(
            route = Screen.SettingsScreen.route
        ) {
            SettingsScreen(
                onNavigate = navController::navigate,
                onNavigateUp = navController::navigateUp,
                onSignOut = {
                    navController.popBackStack()
                    navController.navigate(route = Screen.SignInScreen.route)
                },
                scaffoldState = scaffoldState
            )
        }

        composable(
            route = Screen.PasswordChangeScreen.route
        ) {
            PasswordChangeScreen(
                onNavigateUp = navController::navigateUp,
                scaffoldState = scaffoldState
            )
        }

        composable(
            route = Screen.PrivacyPolicyScreen.route
        ) {
            PrivacyPolicy(
                navController::navigateUp
            )
        }

        composable(
            route = Screen.TermsAndConditionsScreen.route
        ) {
            TermsAndConditions(
                navController::navigateUp
            )
        }

        composable(
            route = Screen.AboutUs.route
        ) {
            AboutUs(
                navController::navigateUp
            )
        }

    }
}