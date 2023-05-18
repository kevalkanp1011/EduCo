package dev.kevalkanpariya.featuretesteduco.core.data.repository

import android.content.Context
import android.content.SharedPreferences
import android.net.Uri
import androidx.compose.ui.platform.LocalContext
import androidx.core.net.toFile
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.domain.models.UserItem
import dev.kevalkanpariya.featuretesteduco.core.domain.repository.ProfileRepository
import dev.kevalkanpariya.featuretesteduco.core.domain.util.getFileName
import dev.kevalkanpariya.featuretesteduco.core.util.Constants
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.CourseApi
import dev.kevalkanpariya.featuretesteduco.feature_profile.data.remote.ProfileApi
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.Profile
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.ProfileHeader
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.UpdateProfileData
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.File
import java.io.IOException

class ProfileRepositoryImpl(
    private val profileApi: ProfileApi,
    private val sharedPreferences: SharedPreferences,
): ProfileRepository {
    override suspend fun getCoursesPaged(
        page: Int,
        pageSize: Int,
        userId: String
    ): Resource<List<CourseOverview>> {
        return try {
            val courses = profileApi.getCoursesPaged(
                userId = userId,
                page = page,
                pageSize = pageSize
            ).data
            Resource.Success(data = courses)
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getUserInfos(page: Int, pageSize: Int): Resource<List<UserItem>> {
        return try {
            val response = profileApi.getUserInfos(page = page, pageSize = pageSize)
            Resource.Success(
                data = response.data
            )
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getProfile(userId: String): Resource<Profile> {
        return try {
            val response = profileApi.getProfile(userId)
            if(response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getProfileHeader(userId: String): Resource<ProfileHeader> {
        return try {
            val response = profileApi.getProfileHeader(userId)
            if(response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun updateProfile(
        updateProfileData: UpdateProfileData,
        bannerImageUri: Uri?,
        profilePictureUri: Uri?,
        context: Context
    ): SimpleResource {

        val profilePictureFile = Uri.fromFile(
            File(
                context.cacheDir,
                profilePictureUri?.let { context.contentResolver.getFileName(it) }
            )
        ).toFile()
        val bannerFile = Uri.fromFile(
            File(
                context.cacheDir,
                bannerImageUri?.let { context.contentResolver.getFileName(it) }
            )
        ).toFile()

        return try {
            val response = profileApi.updateProfile(
                bannerImageUri = bannerFile?.let {
                    MultipartBody.Part
                        .createFormData(
                            "banner_image",
                            bannerFile.name,
                            bannerFile.asRequestBody()
                        )
                },
                profilePictureUri = profilePictureFile?.let {
                    MultipartBody.Part
                        .createFormData(
                            "profile_picture",
                            profilePictureFile.name,
                            profilePictureFile.asRequestBody()
                        )
                },
                updateProfileData = MultipartBody.Part
                    .createFormData(
                        "update_profile_data",
                        Json.encodeToString(updateProfileData)
                    )
            )
            if(response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun searchUser(query: String): Resource<List<UserItem>> {
        return try {
            val response = profileApi.searchUser(query)
            Resource.Success(
                data = response.data
            )
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun followUser(followedUserId: String): SimpleResource {
        return try {
            val response = profileApi.followUser(
                followedUserId = followedUserId
            )
            if(response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun unfollowUser(followedUserId: String): SimpleResource {
        return try {
            val response = profileApi.unfollowUser(
                followedUserId = followedUserId
            )
            if(response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override fun logout() {
        sharedPreferences.edit()
            .putString(Constants.KEY_JWT_TOKEN, "")
            .putString(Constants.KEY_USER_ID, "")
            .apply()
    }
}