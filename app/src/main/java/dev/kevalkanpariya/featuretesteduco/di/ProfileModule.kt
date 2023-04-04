package dev.kevalkanpariya.featuretesteduco.di

import android.content.SharedPreferences
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kevalkanpariya.featuretesteduco.core.data.repository.ProfileRepositoryImpl
import dev.kevalkanpariya.featuretesteduco.core.domain.repository.ProfileRepository
import dev.kevalkanpariya.featuretesteduco.core.domain.use_case.ToggleFollowStateForUserUseCase
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.CourseApi
import dev.kevalkanpariya.featuretesteduco.feature_profile.data.remote.ProfileApi
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProfileModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideProfileApi(client: OkHttpClient): ProfileApi {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(ProfileApi.BASE_URL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(client)
            .build()
            .create(ProfileApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProfileRepository(profileApi: ProfileApi,  sharedPreferences: SharedPreferences): ProfileRepository {
        return ProfileRepositoryImpl(profileApi, sharedPreferences, )
    }

    @Provides
    @Singleton
    fun provideProfileUseCases(profileRepository: ProfileRepository): ProfileUseCases {
        return ProfileUseCases(
            getCoursesForProfile = GetCoursesForProfileUseCase(profileRepository),
            getProfile = GetProfileUseCase(profileRepository),
            getProfileHeaderUseCase = GetProfileHeaderUseCase(profileRepository),
            logout = LogoutUseCase(profileRepository),
            getUserInfosUseCase = GetUserInfosUseCase(profileRepository),
            updateProfile = UpdateProfileDataUseCase(profileRepository)
        )
    }

    @Provides
    @Singleton
    fun provideToggleFollowForUserUseCase(repository: ProfileRepository): ToggleFollowStateForUserUseCase {
        return ToggleFollowStateForUserUseCase(repository)
    }



}