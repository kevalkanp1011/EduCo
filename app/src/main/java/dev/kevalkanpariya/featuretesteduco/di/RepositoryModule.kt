package dev.kevalkanpariya.featuretesteduco.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kevalkanpariya.featuretesteduco.feature_course.data.repository.CourseRepositoryImpl
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideCourseRepository(courseRepositoryImpl: CourseRepositoryImpl): CourseRepository
}