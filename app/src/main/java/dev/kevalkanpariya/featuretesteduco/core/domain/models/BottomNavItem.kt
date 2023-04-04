package dev.kevalkanpariya.featuretesteduco.core.domain.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.util.Screen

data class BottomNavItem(
    val route: String,
    val icon: ImageVector? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null
)

sealed class BottomNavBar(
    @DrawableRes val icon: Int,
    val title: String,
    val route: String
) {
    object Home : BottomNavBar(
        icon = R.drawable.ic_home,
        title = "Home",
        route = Screen.HomeScreen.route
    )
    object Search : BottomNavBar(
        icon = R.drawable.ic_search,
        title = "Search",
        route = Screen.SearchScreen.route
    )
    object Saved : BottomNavBar(
        icon = R.drawable.ic_saved,
        title = "Saved",
        route = Screen.SavedScreen.route
    )
    object Profile : BottomNavBar(
        icon = R.drawable.ic_profile,
        title = "Profile",
        route = Screen.ProfileScreen.route
    )
    object Items {
        val list = listOf(
            Home,
            Search,
            Saved,
            Profile
        )
    }


}
