package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class Category(
    val categoryId: String,
    val categoryImageUrl: String,
    val categoryName: String
)
