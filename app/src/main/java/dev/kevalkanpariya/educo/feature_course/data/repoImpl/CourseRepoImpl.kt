package dev.kevalkanpariya.educo.feature_course.data.repoImpl

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.toObject
import com.google.firebase.firestore.toObjects
import dev.kevalkanpariya.educo.feature_course.data.dto.CourseInfo
import dev.kevalkanpariya.educo.feature_course.domain.models.Comment
import dev.kevalkanpariya.educo.feature_course.domain.models.CourseOverview
import dev.kevalkanpariya.educo.core.data.dto.Resource
import dev.kevalkanpariya.educo.feature_course.domain.models.SearchCourseFilter
import dev.kevalkanpariya.educo.feature_course.domain.repository.CourseRepository
import kotlinx.coroutines.tasks.await


class CourseRepoImpl(
    private val db: FirebaseFirestore
): CourseRepository {
    override suspend fun fetchCourses(
        query: String,
        filter: SearchCourseFilter
    ): Resource<List<CourseOverview>> {

        return try {
            val data = db
                .collection("courses")
                .get()
                .await()
                .toObjects<CourseInfo>()
                .map { courseInfo ->

                    CourseOverview(
                        id =courseInfo.id,
                        count_enrolled = courseInfo.count_enrollment,
                        title = courseInfo.name,
                        tutor_name = courseInfo.id,
                        thumbnail_img_url = courseInfo.thumbnail_img_url,
                        rating = courseInfo.rating,
                        price = courseInfo.price
                    )

                }

            Resource.Success(data = data)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "something went wrong")
        }
    }

    override suspend fun fetchCourseInfo(id: String): Resource<CourseInfo> {
        return try {
            val data = db
                .collection("courses")
                .document(id)
                .get()
                .await()
                .toObject<CourseInfo>()
            
            if (data == null) {
                Resource.Error("no courses available in the database")
            } else {
                Resource.Success(data)
            }
            

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "something went wrong")
        }
    }

    override suspend fun fetchSavedCourses(userId: String): Resource<List<CourseOverview>> {
        return try {
            val data = db
                .collection("users")
                .document(userId)
                .collection("saved_courses")
                .get()
                .await()
                .toObjects<CourseOverview>()


                Resource.Success(null)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "something went wrong")
        }
    }

    override suspend fun fetchCourseComments(courseId: String): Resource<List<Comment>> {
        return try {

            val data = db.collection("courses")
                .document(courseId)
                .collection("comments")
                .get()
                .await()
                .toObjects<Comment>()

            Resource.Success(data = data)

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "something went wrong")
        }
    }

}