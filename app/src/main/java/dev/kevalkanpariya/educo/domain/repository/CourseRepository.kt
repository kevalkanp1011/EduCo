package dev.kevalkanpariya.educo.domain.repository

interface CourseRepository {

    suspend fun searchCourses(
        keyword: String
    )

    suspend fun fetchCategories(

    )

    suspend fun fetchSavedCourses(

    )

    suspend fun addToSavedCourses(

    )

    suspend fun fetchCourse(

    )

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