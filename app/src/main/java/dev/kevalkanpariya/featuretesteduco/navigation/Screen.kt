package dev.kevalkanpariya.featuretesteduco.navigation

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash")
    object HomeScreen : Screen("home")
    object WelcomeScreen: Screen("welcome")
    object SignInScreen: Screen("signin")
    object ProfileScreen: Screen("profile")
    object DetailsScreen: Screen("details")
    object SearchScreen: Screen("search")
    object SavedScreen: Screen("saved")

    object Items {
        val list = listOf(
            ProfileScreen,
            HomeScreen
        )
    }

}
