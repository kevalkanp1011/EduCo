package dev.kevalkanpariya.educo.feature_course.domain.models

data class SearchCourseFilter(
    val sortBy: SortByFilter = SortByFilter.All,
    val level: LevelFilter = LevelFilter.None,
    val duration: DurationFilter = DurationFilter.None
)


enum class SortByFilter {
    Free,
    Premium,
    All
}

enum class LevelFilter {
    Beginner,
    Intermediate,
    Advanced,
    None
}

enum class DurationFilter {
    ZeroToOneHours,
    OneToThreeHours,
    ThreePlusHours,
    None
}