package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class Lesson(
    val lessonId: String,
    val courseId: String,
    val lessonNo: Int,
    val name: String,
    val thumbnail: String,
    val desc: String,
    val lessonVideoUrl: String
)
