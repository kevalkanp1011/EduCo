package dev.kevalkanpariya.educo.navigation

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
