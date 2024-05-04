package dev.kevalkanpariya.educo.feature_course.domain.models

data class CourseOverview(
    val id: String,
    val title: String,
    val price: Int,
    val tutor_name: String,
    val count_enrolled: Int,
    val rating: Float,
    val thumbnail_img_url: String,
)
