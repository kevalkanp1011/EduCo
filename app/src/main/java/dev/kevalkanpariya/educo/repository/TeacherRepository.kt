package dev.kevalkanpariya.educo.repository

import dev.kevalkanpariya.educo.domain.model.Teacher
import retrofit2.http.GET

interface TeacherRepository {
    @GET("teacher")
    suspend fun student(): Teacher
}