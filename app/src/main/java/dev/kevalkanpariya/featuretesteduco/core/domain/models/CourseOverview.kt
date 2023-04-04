package dev.kevalkanpariya.featuretesteduco.core.domain.models


@kotlinx.serialization.Serializable
data class CourseOverview(
    val courseId: String,
    val courseName: String,
    val courseTeacherName: String,
    val courseThumbnailUrl: String,
    val rating: Double,
    val noOfStudentRated: Int? = null,
    val noOfStudentEnrolled: Int? = null,
    val tag: String? = null
)
