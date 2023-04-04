package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class CourseResource(
    val resourceId: String,
    val courseId: String,
    val resourceUrl: String,
    val resourceName: String,
    val fileType: String,
    val resourceSize: Double
)
