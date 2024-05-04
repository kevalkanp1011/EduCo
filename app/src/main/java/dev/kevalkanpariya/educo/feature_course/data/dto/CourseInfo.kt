package dev.kevalkanpariya.educo.feature_course.data.dto

data class CourseInfo(
    val count_enrollment: Int = 0,
    val count_lesson: Int = 0,
    val desc: String = "",
    val id: String = "",
    val name: String = "",
    val price: Int =0,
    val rating: Float = 0.0f,
    val thumbnail_img_url: String = "",
    val thumbnail_video_url: String = "",
    //val tutor_name: String = "",
    val tutor_id: String = "",
)
