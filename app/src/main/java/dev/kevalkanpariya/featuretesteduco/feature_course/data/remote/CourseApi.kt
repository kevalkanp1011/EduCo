package dev.kevalkanpariya.featuretesteduco.feature_course.data.remote

import dev.kevalkanpariya.featuretesteduco.core.data.dto.response.BasicApiResponse
import dev.kevalkanpariya.featuretesteduco.core.data.dto.response.CoursesResponse
import dev.kevalkanpariya.featuretesteduco.core.data.dto.response.UserItemDto
import dev.kevalkanpariya.featuretesteduco.core.domain.models.*
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.dto.CommentDto
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.request.CreateCommentRequest
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.request.LikeUpdateRequest
import retrofit2.http.*

interface CourseApi {

    //Search for Courses
    @GET("/api/user/search/courses")
    suspend fun searchCourses(
        @Query("query") query: String,
        @Query("page") page: Int,
    ): BasicApiResponse<List<CourseOverview>>

    //Bookmark
    @GET("/api/user/bookmark/courses")
    suspend fun getBookmarkedCourses(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("userId") userId: String,
    ): BasicApiResponse<List<CourseOverview>>

    @GET("/api/user/profile/courses")
    suspend fun getCoursesForProfile(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int,
        @Query("userId") userId: String,
    ): CoursesResponse

    @POST("/api/user/bookmark/create")
    suspend fun createBookmark(
        @Query("userId") userId: String,
        @Query("courseId") courseId: String
    ): BasicApiResponse<Unit>


    @GET("/api/get_discover_course")
    suspend fun getDiscoverCourses(
        @Query("page") page: Int,
        @QueryMap options: Map<String, String>
    ): CoursesResponse

    //Feed
    @GET("/api/course/popular_categories")
    suspend fun getPopularCategories(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<Category>

    @GET("/api/course/most_watched_courses")
    suspend fun getMostWatchedCourses(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<CourseOverview>

    @GET("/api/course/previous_watched_courses")
    suspend fun getPreviousWatchedCourses(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<CourseOverview>

    @GET("/api/course/others_watched_courses")
    suspend fun getOthersWatchedCourses(
        @Query("page") page: Int,
        @Query("pageSize") pageSize: Int
    ): List<CourseOverview>


    //Course
    @GET("/api/course/details")
    suspend fun getCourseDetails(
        @Query("courseId") courseId: String
    ): BasicApiResponse<Course>

    @GET("/api/user/course/comments")
    suspend fun getCommentsForCourse(
        @Query("courseId") courseId: String
    ): BasicApiResponse<List<CommentDto>>

    @GET("/api/user/course/projects")
    suspend fun getProjectsForCourse(
        @Query("courseId") courseId: String
    ): BasicApiResponse<List<Project>>

    @GET("/api/user/course/resources")
    suspend fun getResourcesForCourse(
        @Query("courseId") courseId: String
    ): BasicApiResponse<List<CourseResource>>

    @GET("/api/user/course/lessons")
    suspend fun getLessonsForCourse(
        @Query("courseId") courseId: String
    ): BasicApiResponse<List<Lesson>>

    @POST("/api/comment/create")
    suspend fun createComment(
        @Body request: CreateCommentRequest
    ): BasicApiResponse<Unit>

    @POST("/api/like")
    suspend fun likeParent(
        @Body request: LikeUpdateRequest
    ): BasicApiResponse<Unit>

    @DELETE("/api/unlike")
    suspend fun unlikeParent(
        @Query("parentId") parentId: String,
        @Query("parentType") parentType: Int
    ): BasicApiResponse<Unit>

    @GET("/api/like/parent")
    suspend fun getLikesForParent(
        @Query("courseId") parentId: String
    ): List<UserItemDto>


    companion object {
        const val BASE_URL = "http://192.168.138.154:8080/"
    }
}