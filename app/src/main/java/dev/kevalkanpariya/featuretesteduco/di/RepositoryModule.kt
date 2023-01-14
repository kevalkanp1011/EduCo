package dev.kevalkanpariya.featuretesteduco.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.kevalkanpariya.featuretesteduco.data.repository.DataStoreOperationsImpl
import dev.kevalkanpariya.featuretesteduco.data.repository.Repository
import dev.kevalkanpariya.featuretesteduco.domain.repository.DataStoreOperations
import dev.kevalkanpariya.featuretesteduco.util.Constants.PREFERENCES_NAME
import dev.kevalkanpariya.featuretesteduco.domain.use_cases.UseCases
import dev.kevalkanpariya.featuretesteduco.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import dev.kevalkanpariya.featuretesteduco.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import javax.inject.Singleton
import dev.kevalkanpariya.featuretesteduco.data.remote.KtorApi
import dev.kevalkanpariya.featuretesteduco.data.repository.AuthRepositoryImpl
import dev.kevalkanpariya.featuretesteduco.data.repository.CourseRepositoryImpl
import dev.kevalkanpariya.featuretesteduco.domain.repository.AuthRepository
import dev.kevalkanpariya.featuretesteduco.domain.repository.CourseRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations = DataStoreOperationsImpl(context = context)

    @Provides
    @Singleton
    fun provideUserCases(repository: Repository): UseCases =
        UseCases(
            saveOnBoardingUserCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository)
        )

    @Provides
    @Singleton
    fun provideDataStorePreferences(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile(PREFERENCES_NAME) }
        )
    }

    @Provides
    @Singleton
    fun provideAuthRepository(
        dataStoreOperations: DataStoreOperations,
        ktorApi: KtorApi
    ): AuthRepository {
        return AuthRepositoryImpl(
            dataStoreOperations = dataStoreOperations,
            ktorApi = ktorApi
        )
    }

    @Provides
    @Singleton
    fun provideCourseRepository(
        ktorApi: KtorApi
    ): CourseRepository {
        return CourseRepositoryImpl(
            ktorApi
        )
    }
}
