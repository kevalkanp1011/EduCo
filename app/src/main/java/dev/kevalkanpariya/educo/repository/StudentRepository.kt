package dev.kevalkanpariya.educo.repository

import dev.kevalkanpariya.educo.domain.model.Student
import retrofit2.http.GET

interface StudentRepository {
    @GET("student")
    suspend fun student(): Student
}