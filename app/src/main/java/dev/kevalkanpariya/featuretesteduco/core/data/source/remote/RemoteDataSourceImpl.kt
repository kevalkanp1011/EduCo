package dev.kevalkanpariya.featuretesteduco.core.data.source.remote

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.domain.models.FilterResult
import dev.kevalkanpariya.featuretesteduco.core.domain.source.DataSource
import dev.kevalkanpariya.featuretesteduco.core.util.Constants
import dev.kevalkanpariya.featuretesteduco.feature_course.data.paging.CourseSource
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.CourseApi
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.util.CourseRequestOptionsMapper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val courseApi: CourseApi,
    private val courseRequestOptionsMapper: CourseRequestOptionsMapper
): DataSource.Remote {
    override suspend fun getDiscoverCourses(filterResult: FilterResult?): Flow<PagingData<CourseOverview>> =
        Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE,
                prefetchDistance = 2,
                maxSize = PagingConfig.MAX_SIZE_UNBOUNDED,
                jumpThreshold = Int.MIN_VALUE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = {
                CourseSource(
                    api = courseApi,
                    source = CourseSource.Source.DiscoverCourses,
                    courseRequestOptionsMapper = courseRequestOptionsMapper,
                    filterResult = filterResult
                )
            }
        ).flow

}