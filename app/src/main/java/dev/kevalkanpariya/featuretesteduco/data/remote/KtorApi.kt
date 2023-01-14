package dev.kevalkanpariya.featuretesteduco.data.remote

import dev.kevalkanpariya.featuretesteduco.domain.model.*
import retrofit2.http.*

interface KtorApi {

    /*Authentication*/
    @POST("/token_verification")
    suspend fun verifyTokenOnBackend(
        @Body request: ApiRequest
    ): ApiResponse

    @GET("/get_user")
    suspend fun getUserInfo(): ApiResponse

    @PUT("/update_user")
    suspend fun updateUser(
        @Body userUpdate: UserUpdate
    ): ApiResponse

    @DELETE("/delete_user")
    suspend fun deleteUser(): ApiResponse

    @GET("/sign_out")
    suspend fun clearSession(): ApiResponse

    /*Course*/
    @GET("/get_course")
    suspend fun getCourseById(
        @Body courseId: CourseRequest
    ): ApiResponse

    @POST("/create_course")
    suspend fun createCourse(
        @Body course: Course
    ): ApiResponse

    @POST("/update_course")
    suspend fun updateCourseById(
        @Body course: Course
    ): ApiResponse

    @DELETE("/delete_course")
    suspend fun deleteCourseById(
        @Body courseId: CourseRequest
    ): ApiResponse

}