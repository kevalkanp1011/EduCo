package dev.kevalkanpariya.featuretesteduco.core.domain.source

import androidx.paging.PagingData
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.domain.models.FilterResult
import kotlinx.coroutines.flow.Flow

interface DataSource {

    interface Remote {
        suspend fun getDiscoverCourses(filterResult: FilterResult?): Flow<PagingData<CourseOverview>>
    }
}