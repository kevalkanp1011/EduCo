package dev.kevalkanpariya.educo.feature_course.domain.models

data class Course2(
    val id: String,
    val name: String,
    val desc: String,
    val price: Int,
    val count_enrolled: Int,
    val count_lesson: Int,
    val rating: Float,
    val thumbnail_img_url: String,
    val thumbnail_video_url: String,
    val tutor_name: String,
    val tutor_id: String,

)