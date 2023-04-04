package dev.kevalkanpariya.featuretesteduco.core.domain.models

import com.google.gson.annotations.SerializedName

@kotlinx.serialization.Serializable
data class Lesson(
    val lessonId: String,
    val courseId: String,
    val lessonNo: Int,
    //@SerializedName("name")
    val name: String,
    val thumbnail: String,
    val desc: String,
    val lessonVideoUrl: String
)
