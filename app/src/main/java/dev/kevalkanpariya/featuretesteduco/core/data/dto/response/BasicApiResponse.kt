package dev.kevalkanpariya.featuretesteduco.core.data.dto.response

import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview

@kotlinx.serialization.Serializable
data class BasicApiResponse<T>(
    val successful: Boolean,
    val message: String? = null,
    val data: T? = null
)

@kotlinx.serialization.Serializable
data class CoursesResponse(
    val page: Int,
    val results: List<CourseOverview>,
    val totalPages: Int,
    val totalResults: Int
)