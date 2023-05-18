package dev.kevalkanpariya.featuretesteduco.core.domain.models

@kotlinx.serialization.Serializable
data class NewUser(
    val userId: String,
    val username: String,
    val name: String,
    val profilePictureUrl: String? = null,
    val bio: String? = null,
    val followerCount: Int = 0,
    val followingCount: Int = 0 ,
    val projectCount: Int = 0,
    val twitterUrl: String? = null,
    val instagramUrl: String? = null,
    val facebookUrl: String? = null
)