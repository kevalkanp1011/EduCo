package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class Project(
    val projectId: String,
    val courseId: String,
    val projectName: String,
    val desc: String,
    val imageUrls: List<String>
)

@kotlinx.serialization.Serializable
data class NewProject(
    val projectId: String,
    val courseId: String,
    val ownerUserId: String,
    val projectName: String,
    val desc: String,
    val imageUrls: List<String>
)
