package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.util

import dev.kevalkanpariya.featuretesteduco.core.domain.models.FilterResult
import dev.kevalkanpariya.featuretesteduco.core.util.Constants.Filter.DURATION
import dev.kevalkanpariya.featuretesteduco.core.util.Constants.Filter.LEVEL
import dev.kevalkanpariya.featuretesteduco.core.util.Constants.Filter.SORT_BY
import javax.inject.Inject

interface Mapper<Input, Output> {
    fun map(input: Input): Output
}

class CourseRequestOptionsMapper @Inject constructor() : Mapper<FilterResult?, Map<String, String>> {
    override fun map(input: FilterResult?): Map<String, String> = buildMap {
        val filterState = input ?: FilterResult()
        val sortBy = "${filterState.sortBy}.desc"
        put(SORT_BY, sortBy)
        if (filterState.selectedDurationList.isNotEmpty()) {
            val selectedDurations = filterState.selectedDurationList.map { it.name }.joinToString("|")
            put(DURATION, selectedDurations)
        }
        if (filterState.selectedLevelList.isNotEmpty()) {
            val selectedLevels = filterState.selectedLevelList.map { it.name }.joinToString("|")
            put(LEVEL, selectedLevels)
        }
    }

}