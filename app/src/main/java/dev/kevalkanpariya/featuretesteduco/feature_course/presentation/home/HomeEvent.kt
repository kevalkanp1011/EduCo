package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home

sealed class HomeEvent {
    data class EnteredSearchQuery(val query: String): HomeEvent()
}