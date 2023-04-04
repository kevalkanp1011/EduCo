package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_detail

sealed class CourseDetailEvent {
    object Comment: CourseDetailEvent()
    data class LikeComment(val commentId: String): CourseDetailEvent()
    data class EnteredComment(val comment: String): CourseDetailEvent()
}