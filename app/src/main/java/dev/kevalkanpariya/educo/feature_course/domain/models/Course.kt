package dev.kevalkanpariya.educo.feature_course.domain.models

import dev.kevalkanpariya.educo.R
import kotlinx.serialization.Serializable

@Serializable
//@Entity(tableName = HERO_DATABASE_TABLE)
data class Course(
    //@PrimaryKey(autoGenerate = false)
    val id: Int,
    val courseTitle: String,
    val image: Int,
    val description: String,
    val noOfStudentEnrolled: Int,
    val course_teacher: Teacher,
    val noOfLessons: Int,
    val noOfStudentRated: Int,
    val rating: Double,
    val tag: String? = null,
    val lessons: List<Lesson>? = null,
    val time: String,

    )

val adobeIllustratorCourse = Course(
    id = 1,
    courseTitle = "Adobe illustrator for all beginner artist",
    course_teacher = kevalkanpariya,
    description = "sfsteterettrrtr",
    noOfStudentEnrolled = 4,
    noOfStudentRated = 50,
    noOfLessons = 2,
    rating = 4.7,
    image = R.drawable.interiordesign,
    time = "5.20.30",
    lessons = adobeLessons
)

val androidDevlopmentCourse = Course(
    id = 2,
    courseTitle = "Jetpack Compose for all beginner Developer",
    course_teacher = kevalkanpariya,
    description = "sfsteterettrrtr",
    noOfStudentEnrolled = 4,
    noOfStudentRated = 50,
    noOfLessons = 2,
    rating = 4.7,
    image = R.drawable.interiordesign,
    time = "5.20.30",
    lessons = adobeLessons
)

val canvaDesignCourse = Course(
    id = 3,
    courseTitle = "Canva for all beginner Designer",
    course_teacher = kevalkanpariya,
    description = "sfsteterettrrtr",
    noOfStudentEnrolled = 4,
    noOfStudentRated = 50,
    noOfLessons = 2,
    rating = 4.7,
    image = R.drawable.interiordesign,
    time = "5.20.30",
    lessons = adobeLessons
)


val courses = listOf(adobeIllustratorCourse, androidDevlopmentCourse, canvaDesignCourse)