package dev.kevalkanpariya.featuretesteduco.domain.model

import androidx.annotation.DrawableRes
import dev.kevalkanpariya.featuretesteduco.R

sealed class BottomNavBar(
    @DrawableRes val icon: Int,
    val title: String,
    val route: String
) {
    object Home : BottomNavBar(
        icon = R.drawable.ic_home,
        title = "Home",
        route = "home"
    )
    object Search : BottomNavBar(
        icon = R.drawable.ic_search,
        title = "Search",
        route = "search"
    )
    object Saved : BottomNavBar(
        icon = R.drawable.ic_saved,
        title = "Saved",
        route = "saved"
    )
    object Profile : BottomNavBar(
        icon = R.drawable.ic_profile,
        title = "Profile",
        route = "profile"
    )

}
