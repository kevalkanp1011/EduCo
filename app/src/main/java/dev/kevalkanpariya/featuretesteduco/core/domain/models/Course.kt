package dev.kevalkanpariya.featuretesteduco.core.domain.models

import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_detail.CourseOverviewState
import dev.kevalkanpariya.featuretesteduco.util.DurationSerializer
import kotlinx.serialization.Serializable
import kotlin.time.Duration

@Serializable
data class Course(
    val courseId: String,
    val userId: String? = "",
    val courseTitle: String,
    val courseTeacher: Teacher,
    val courseThumbnail: String,
    val courseIntroVideoUrl: String,
    val description: String,
    val moreDetails: String? = null,
    val noOfStudentRated: Int,
    val noOfStudentEnrolled: Int,
    val noOfLessons: Int,
    val avgRating: Double,
    val tag: String? = null,
    val commentCount: Int = 0,
    @Serializable(with = DurationSerializer::class)
    val duration: Duration? = null
) {

    fun toCourseOverview(): CourseOverviewState {
        return CourseOverviewState(
            rating = avgRating,
            description = description
        )
    }
}

@Serializable
data class NewCourse(
    val courseId: String,
    val ownerUserId: String,
    val courseTitle: String,
    val courseThumbnailUrl: String,
    val courseIntroVideoUrl: String,
    val description: String,
    val duration: Long,
    val noOfLessons: Int,
    val noOfStudentRated: Int,
    val noOfStudentEnrolled: Int,
    val avgRating: Double,
    val tag: String? = null,
    val commentCount: Int = 0,
) {

    fun toCourseOverview(): CourseOverviewState {
        return CourseOverviewState(
            rating = avgRating,
            description = description
        )
    }
}