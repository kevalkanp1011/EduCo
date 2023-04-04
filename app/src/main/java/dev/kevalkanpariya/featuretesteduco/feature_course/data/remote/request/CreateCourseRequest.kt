package dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.request

@kotlinx.serialization.Serializable
data class CreateCourseRequest(
    val description: String
)