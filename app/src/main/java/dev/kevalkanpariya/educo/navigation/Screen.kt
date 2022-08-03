package dev.kevalkanpariya.educo.navigation

import dev.kevalkanpariya.educo.R

sealed class Screen(
    val title: String,
    val route: String
    ) {

    sealed class BottomNavScreens(
        title: String,
        val icon: Int,
        route: String
    ): Screen(title, route) {
        object Home: BottomNavScreens(route = "home_screen", title = "Home", icon = R.drawable.ic_home)
        object Search: BottomNavScreens(route = "search_screen", title =  "Search", icon = R.drawable.ic_search)
        object Saved: BottomNavScreens(route = "saved_screen", title =  "Saved", icon = R.drawable.ic_saved)
        object Profile: BottomNavScreens(route = "profile_screen", title = "Profile", icon = R.drawable.ic_profile)
    }

    //object Details: Screen(route = "details_screen", title =  "Details")
    //object Splash: Screen(route = "splash_screen", title =  "Splash")
    object Login: Screen(route = "login_screen", title =  "Login")
    object Welcome: Screen(route = "welcome_screen", title =  "Welcome")

    object Items{
        val list = listOf(
            BottomNavScreens.Home,
            BottomNavScreens.Search,
            BottomNavScreens.Saved,
            BottomNavScreens.Profile
        )
    }

}
