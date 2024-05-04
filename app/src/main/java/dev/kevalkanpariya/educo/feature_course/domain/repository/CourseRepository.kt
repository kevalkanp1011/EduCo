package dev.kevalkanpariya.educo.feature_course.domain.repository

import dev.kevalkanpariya.educo.feature_course.data.dto.CourseInfo
import dev.kevalkanpariya.educo.feature_course.domain.models.Comment
import dev.kevalkanpariya.educo.feature_course.domain.models.CourseOverview
import dev.kevalkanpariya.educo.core.data.dto.Resource
import dev.kevalkanpariya.educo.feature_course.domain.models.SearchCourseFilter

interface CourseRepository {

    suspend fun fetchCourses(
        query: String,
        filter: SearchCourseFilter = SearchCourseFilter()
    ): Resource<List<CourseOverview>>

    suspend fun fetchCourseInfo(
        id: String
    ): Resource<CourseInfo>

    suspend fun fetchSavedCourses(
        userId: String
    ): Resource<List<CourseOverview>>

    suspend fun fetchCourseComments(
        courseId: String
    ): Resource<List<Comment>>





    //return a flow who step by step giving a data
    /**

     LAUNCHING MULTIPLE COROUTINE THAT SIMULTANEOUSLY DOING FOLLOWING TASKS

     1. Course OverviewData( courseTitle, desc, teacher, time, noOfLessons, rating, noOfStudentsEnrolled)
     2. Video Downloading
     3. comments and feedbacks
     4. projects
     6. lessons
     */
    //add paging in comment, feedback, projects, lessons


}