package dev.kevalkanpariya.featuretesteduco.domain.repository

import dev.kevalkanpariya.featuretesteduco.domain.model.ApiResponse
import dev.kevalkanpariya.featuretesteduco.domain.model.Course
import dev.kevalkanpariya.featuretesteduco.domain.model.CourseRequest

interface CourseRepository{
    suspend fun getCourseById(id: CourseRequest): ApiResponse
    suspend fun createCourse(course: Course): ApiResponse
    suspend fun updateCourseById(course: Course): ApiResponse
    suspend fun deleteCourseById(id: CourseRequest): ApiResponse
}