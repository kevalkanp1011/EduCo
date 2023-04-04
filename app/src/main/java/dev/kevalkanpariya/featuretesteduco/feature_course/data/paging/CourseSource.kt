package dev.kevalkanpariya.featuretesteduco.feature_course.data.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.domain.models.FilterResult
import dev.kevalkanpariya.featuretesteduco.core.util.Constants
import dev.kevalkanpariya.featuretesteduco.core.util.Constants.STARTING_PAGE
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.CourseApi
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.util.CourseRequestOptionsMapper
import retrofit2.HttpException
import java.io.IOException

class CourseSource(
    private val api: CourseApi,
    private val source: Source,
    filterResult: FilterResult? = null,
    courseRequestOptionsMapper: CourseRequestOptionsMapper
) : PagingSource<Int, CourseOverview>() {

    private val options = courseRequestOptionsMapper.map(filterResult)

    override fun getRefreshKey(state: PagingState<Int, CourseOverview>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CourseOverview> {
        return try {
            val page = params.key ?: STARTING_PAGE
            val response = when(source) {
                is Source.Profile -> api.getCoursesForProfile(
                    userId = source.userId,
                    page = page,
                    pageSize = Constants.DEFAULT_PAGE_SIZE
                )

                is Source.DiscoverCourses -> api.getDiscoverCourses(
                    page = page,
                    options = options
                )
            }

            LoadResult.Page(
                data = response.results,
                prevKey = if (page == STARTING_PAGE) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )

        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }


    sealed class Source {
        //object Follows: Source()
        data class Profile(val userId: String): Source()
        object DiscoverCourses: Source()
    }
}