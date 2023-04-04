package dev.kevalkanpariya.featuretesteduco.feature_profile.data.remote

import dev.kevalkanpariya.featuretesteduco.core.data.dto.response.BasicApiResponse
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.domain.models.UserItem
import dev.kevalkanpariya.featuretesteduco.core.util.Constants
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.Profile
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.ProfileHeader
import okhttp3.MultipartBody
import retrofit2.http.*

interface ProfileApi {

    @GET("/api/user/profile/courses")
    suspend fun getCoursesPaged(
        @Query("page") page: Int = 0,
        @Query("pageSize") pageSize: Int = Constants.DEFAULT_PAGE_SIZE,
        @Query("userId") userId: String
    ): BasicApiResponse<List<CourseOverview>>

    @GET("/api/user/profile")
    suspend fun getProfile(@Query("userId") userId: String): BasicApiResponse<Profile>

    @GET("/api/user/profile_header")
    suspend fun getProfileHeader(@Query("userId") userId: String): BasicApiResponse<ProfileHeader>

    @Multipart
    @PUT("/api/user/profile/update")
    suspend fun updateProfile(
        @Part updateProfileData: MultipartBody.Part,
        @Part bannerImageUri: MultipartBody.Part?,
        @Part profilePictureUri: MultipartBody.Part?
    ): BasicApiResponse<Unit>


    @GET("/api/user/search")
    suspend fun searchUser(@Query("query") query: String): BasicApiResponse<List<UserItem>>


    @GET("/api/get/users")
    suspend fun getUserInfos(
        @Query("page") page: Int = 0,
        @Query("pageSize") pageSize: Int = Constants.DEFAULT_PAGE_SIZE,
    ): BasicApiResponse<List<UserItem>>

    @POST("/api/user/follow")
    suspend fun followUser(@Query("userId") followedUserId: String): BasicApiResponse<Unit>

    @DELETE("/api/user/unfollow")
    suspend fun unfollowUser(@Query("userId") followedUserId: String): BasicApiResponse<Unit>


    companion object {
        const val BASE_URL = "http://192.168.138.154:8080/"
    }
}