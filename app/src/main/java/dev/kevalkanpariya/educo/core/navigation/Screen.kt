package dev.kevalkanpariya.educo.core.navigation

import dev.kevalkanpariya.educo.R

sealed class Screen(
    val title: String,
    val route: String
    ) {

    object Home: Screen(route = "home_screen", title = "Home")
    object Search: Screen(route = "search_screen", title =  "Search")
    object Saved: Screen(route = "saved_screen", title =  "Saved")
    object Profile: Screen(route = "profile_screen", title = "Profile")
    object Details: Screen(route = "details_screen", title =  "Details")
    object Splash: Screen(route = "splash_screen", title =  "Splash")
    object Auth: Screen(route = "auth_screen", title =  "Auth")
    object Register: Screen(route = "register_screen", title =  "Register")
    object Welcome: Screen(route = "welcome_screen", title =  "Welcome")




    object Items{
        val list = listOf(
            Home,
            Search,
            Saved,
            Profile
        )
    }

}


sealed class BottomNavItem(val route: String, val title: String, val icon: Int) {

    object Home: BottomNavItem(Routes.HomeScreen.route, "Home", R.drawable.ic_home)
    object Search: BottomNavItem(Routes.SearchScreen.route, "Search", R.drawable.ic_search)
    object Saved: BottomNavItem(Routes.SavedScreen.route, "Saved", R.drawable.ic_saved)
    object Profile: BottomNavItem(Routes.ProfileScreen.route, "Profile", R.drawable.ic_profile)

    object Items {
        val list = listOf(
            Home,
            Search,
            Saved,
            Profile
        )
    }
}
