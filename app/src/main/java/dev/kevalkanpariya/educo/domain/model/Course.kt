package dev.kevalkanpariya.educo.domain.model

import dev.kevalkanpariya.educo.R
import kotlinx.serialization.Serializable

@Serializable
//@Entity(tableName = HERO_DATABASE_TABLE)
data class Course(
    //@PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: Int,
    val noOfStudentEnrolled: Int,
    val course_teacher : Teacher,
    //val about: String,
    val rating: Double,
    //val month: String,
    //val day: String,
    //val family: List<String>,
    //val abilities: List<String>,
    //val natureTypes: List<String>
)
