package dev.kevalkanpariya.featuretesteduco.core.domain.models

import android.os.Parcelable
import dev.kevalkanpariya.featuretesteduco.core.util.Constants
import kotlinx.parcelize.Parcelize

@Parcelize
data class FilterResult(
    var sortBy: String = Constants.SortBy.FREE_CLASSES,
    var selectedLevelList: MutableList<Level> = mutableListOf(),
    var selectedDurationList: MutableList<Duration> = mutableListOf(),
    var level: List<Level> = emptyList(),
    var duration: List<Duration> = emptyList()
) : Parcelable


enum class Level {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED
}
enum class Duration {
    HOUR_0_1,
    HOUR_1_3,
    HOUR_3_PLUS
}