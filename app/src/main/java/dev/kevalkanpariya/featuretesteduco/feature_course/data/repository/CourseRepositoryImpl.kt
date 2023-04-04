package dev.kevalkanpariya.featuretesteduco.feature_course.data.repository


import androidx.paging.PagingData
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.models.*
import dev.kevalkanpariya.featuretesteduco.core.domain.source.DataSource
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.core.util.UiText
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.CourseApi
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.request.CreateCommentRequest
import dev.kevalkanpariya.featuretesteduco.feature_course.data.remote.request.LikeUpdateRequest
import dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository.CourseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CourseRepositoryImpl @Inject constructor(
    private val remote: DataSource.Remote,
    private val api: CourseApi,
): CourseRepository {
    override suspend fun searchCourses(query: String, page: Int): Resource<List<CourseOverview>> {
        return try {
            val courses = api.searchCourses(
                query = query,
                page = 0,
            ).data
            Resource.Success(data = courses)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getBookmarkedCourses(userId: String): Resource<List<CourseOverview>> {
        return try {
            val courses = api.getBookmarkedCourses(
                page = 0,
                pageSize = 10,
                userId = userId
            ).data
            Resource.Success(data = courses)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun AddToBookmarkedCourses(userId: String, courseId: String): SimpleResource {
        return try {
            val response = api.createBookmark(userId, courseId)
            if (response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getPopularCategories(page: Int, pageSize: Int): Resource<List<Category>> {
        return try {
            val categories = api.getPopularCategories(
                page = page,
                pageSize = pageSize
            )
            Resource.Success(data = categories)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getMostWatchedCourses(
        page: Int,
        pageSize: Int
    ): Resource<List<CourseOverview>> {
        return try {
            val courses = api.getMostWatchedCourses(
                page = page,
                pageSize = pageSize
            )
            Resource.Success(data = courses)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getPreviousWatchedCourses(
        page: Int,
        pageSize: Int
    ): Resource<List<CourseOverview>> {
        return try {
            val courses = api.getPreviousWatchedCourses(
                page = page,
                pageSize = pageSize
            )
            Resource.Success(data = courses)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getOthersWatchedCourses(
        page: Int,
        pageSize: Int
    ): Resource<List<CourseOverview>> {
        return try {
            val courses = api.getOthersWatchedCourses(
                page = page,
                pageSize = pageSize
            )
            Resource.Success(data = courses)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getDiscoverCourses(
        filterResult: FilterResult?
    ): Flow<PagingData<CourseOverview>> = flow {
        remote.getDiscoverCourses(filterResult).collect { emit(it) }
    }


    override suspend fun getCourseDetails(courseId: String): Resource<Course?> {
        return try {
            val response = api.getCourseDetails(courseId = courseId)

            if (response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getCommentsForCourse(courseId: String): Resource<List<Comment>> {
        return try {
            val comments = api.getCommentsForCourse(courseId = courseId).data?.map { commentDto ->
                commentDto.toComment()
            }
            Resource.Success(comments)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getLessonsForCourse(courseId: String): Resource<List<Lesson>> {
        return try {
            val lessons = api.getLessonsForCourse(courseId = courseId).data
            Resource.Success(lessons)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getProjectsForCourse(courseId: String): Resource<List<Project>> {
        return try {
            val projects = api.getProjectsForCourse(courseId = courseId).data
            Resource.Success(projects)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getResourcesForCourse(courseId: String): Resource<List<CourseResource>> {
        return try {
            val resources = api.getResourcesForCourse(courseId = courseId).data
            Resource.Success(resources)
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun createComment(courseId: String, comment: String): SimpleResource {
        return try {
            val response = api.createComment(
                CreateCommentRequest(
                    comment = comment,
                    courseId = courseId,
                )
            )
            if (response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun likeParent(parentId: String, parentType: Int): SimpleResource {
        return try {
            val response = api.likeParent(
                LikeUpdateRequest(
                    parentId = parentId,
                    parentType = parentType
                )
            )
            if (response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun unlikeParent(parentId: String, parentType: Int): SimpleResource {
        return try {
            val response = api.unlikeParent(
                parentId = parentId,
                parentType = parentType
            )
            if (response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }

    override suspend fun getLikesForParent(parentId: String): Resource<List<UserItem>> {
        return try {
            val response = api.getLikesForParent(
                parentId = parentId,
            )
            Resource.Success(response.map { it.toUserItem() })
        } catch (e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_couldnt_reach_server)
            )
        } catch (e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.oops_something_went_wrong)
            )
        }
    }
}