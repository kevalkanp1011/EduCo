package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home

data class HomeState(
    val isLoadingFirstTime: Boolean = true,
    val isLoadingNewPosts: Boolean = false,
)