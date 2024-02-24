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


}