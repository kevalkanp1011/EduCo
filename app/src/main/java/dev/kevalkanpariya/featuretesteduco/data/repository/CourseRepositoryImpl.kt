package dev.kevalkanpariya.featuretesteduco.data.repository

import dev.kevalkanpariya.featuretesteduco.data.remote.KtorApi
import dev.kevalkanpariya.featuretesteduco.domain.model.ApiResponse
import dev.kevalkanpariya.featuretesteduco.domain.model.Course
import dev.kevalkanpariya.featuretesteduco.domain.model.CourseRequest
import dev.kevalkanpariya.featuretesteduco.domain.repository.CourseRepository
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val ktorApi: KtorApi
): CourseRepository {
    override suspend fun getCourseById(id: CourseRequest): ApiResponse {
        return try {
            ktorApi.getCourseById(id)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun createCourse(course: Course): ApiResponse {
        return try {
            ktorApi.createCourse(course)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun updateCourseById(course: Course): ApiResponse {
        return try {
            ktorApi.updateCourseById(course)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun deleteCourseById(id: CourseRequest): ApiResponse {
        return try {
            ktorApi.deleteCourseById(id)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

}