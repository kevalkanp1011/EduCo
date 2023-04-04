package dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.request

@kotlinx.serialization.Serializable
data class LikeUpdateRequest(
    val parentId: String,
    val parentType: Int
)