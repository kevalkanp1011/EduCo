package dev.kevalkanpariya.featuretesteduco.feature_course.domain.repository

import androidx.paging.PagingData
import dev.kevalkanpariya.featuretesteduco.core.domain.models.*
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import kotlinx.coroutines.flow.Flow

interface CourseRepository {
    suspend fun searchCourses(query: String, page: Int): Resource<List<CourseOverview>>

    suspend fun getBookmarkedCourses(userId: String): Resource<List<CourseOverview>>

    suspend fun AddToBookmarkedCourses(userId: String, courseId: String): SimpleResource

    suspend fun getPopularCategories(page: Int, pageSize: Int): Resource<List<Category>>

    suspend fun getMostWatchedCourses(page: Int, pageSize: Int): Resource<List<CourseOverview>>

    suspend fun getPreviousWatchedCourses(page: Int, pageSize: Int): Resource<List<CourseOverview>>

    suspend fun getOthersWatchedCourses(page: Int, pageSize: Int): Resource<List<CourseOverview>>


    suspend fun getDiscoverCourses(filterResult: FilterResult?): Flow<PagingData<CourseOverview>>

    suspend fun getCourseDetails(courseId: String): Resource<Course?>

    suspend fun getCommentsForCourse(courseId: String): Resource<List<Comment>>
    suspend fun getLessonsForCourse(courseId: String): Resource<List<Lesson>>
    suspend fun getProjectsForCourse(courseId: String): Resource<List<Project>>
    suspend fun getResourcesForCourse(courseId: String): Resource<List<CourseResource>>

    suspend fun createComment(courseId: String, comment: String): SimpleResource

    suspend fun likeParent(parentId: String, parentType: Int): SimpleResource

    suspend fun unlikeParent(parentId: String, parentType: Int): SimpleResource

    suspend fun getLikesForParent(parentId: String): Resource<List<UserItem>>

}