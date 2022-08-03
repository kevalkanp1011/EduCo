package dev.kevalkanpariya.educo.repository

import dev.kevalkanpariya.educo.domain.model.Course
import retrofit2.http.GET

interface CourseRepository {
    @GET("course")
    suspend fun course(): Course
}