package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_detail

import dev.kevalkanpariya.featuretesteduco.core.domain.models.*

data class CourseDetailState(
    val course: Course? = null,
    val comments: List<Comment> = emptyList(),
    val projects: List<Project> = emptyList(),
    val lessons: List<Lesson> = emptyList(),
    val resources: List<CourseResource> = emptyList(),
    val isLoadingCourse: Boolean = false,
    val isLoadingComments: Boolean = false,
    val isLoadingProjects: Boolean = false,
    val isLoadingLessons: Boolean = false,
    val isLoadingResources: Boolean = false
)

data class LessonDetailState(
    val lessons: List<Lesson> = emptyList(),
    val isLoadingLessons: Boolean = false,
)

data class ProjectDetailState(
    val projects: List<Project> = emptyList(),
    val isLoadingProjects: Boolean = false,
)

data class CommentDetailState(
    val comments: List<Comment> = emptyList(),
    val isLoadingComments: Boolean = false,
)

data class ResourceDetailState(
    val resources: List<CourseResource> = emptyList(),
    val isLoadingResources: Boolean = false,
)

data class FeedbackDetailState(
    val feedbacks: List<Feedback> = emptyList(),
    val isLoadingLessons: Boolean = false,
)

data class CourseOverviewState(
    val rating: Double? = null,
    val description: String? = null,
    val noOfStudentEnrolled: Int? = null,
    val commentCount: Int? = null,
    val isLoadingOverview: Boolean = false
)