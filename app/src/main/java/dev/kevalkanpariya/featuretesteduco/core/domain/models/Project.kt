package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class Project(
    val projectId: String,
    val courseId: String,
    val projectName: String,
    val desc: String,
    val imageUrls: List<String>
)
