package dev.kevalkanpariya.featuretesteduco.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.kevalkanpariya.featuretesteduco.core.data.source.remote.RemoteDataSourceImpl
import dev.kevalkanpariya.featuretesteduco.core.domain.source.DataSource

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): DataSource.Remote

}