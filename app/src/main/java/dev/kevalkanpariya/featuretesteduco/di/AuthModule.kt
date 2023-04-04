package dev.kevalkanpariya.featuretesteduco.di

import android.content.SharedPreferences
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kevalkanpariya.featuretesteduco.feature_auth.data.remote.AuthApi
import dev.kevalkanpariya.featuretesteduco.feature_auth.data.repository.AuthRepositoryImpl
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.repository.AuthRepository
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.AuthenticateUseCase
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.ResetPasswordUseCase
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.SignInUseCase
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.SignUpUseCase
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideAuthApi(client: OkHttpClient): AuthApi {
        val contentType = "application/json".toMediaType()

        return Retrofit.Builder()
            .baseUrl(AuthApi.BASE_URL)
            .client(client)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
            .create(AuthApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthApi, sharedPreferences: SharedPreferences): AuthRepository {
        return AuthRepositoryImpl(api, sharedPreferences)
    }


    @Provides
    @Singleton
    fun provideSignInUseCase(repository: AuthRepository): SignInUseCase {
        return SignInUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideResetPasswordUseCase(repository: AuthRepository): ResetPasswordUseCase {
        return ResetPasswordUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSignUpUseCase(repository: AuthRepository): SignUpUseCase {
        return SignUpUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAuthenticationUseCase(repository: AuthRepository): AuthenticateUseCase {
        return AuthenticateUseCase(repository)
    }
}