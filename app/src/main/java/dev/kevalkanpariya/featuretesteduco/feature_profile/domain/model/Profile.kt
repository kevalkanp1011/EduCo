package dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model

@kotlinx.serialization.Serializable
data class Profile(
    val userId: String,
    val name: String,
    val username: String,
    val bio: String,
    val followerCount: Int,
    val followingCount: Int,
    val enrolledCourseCount: Int,
    val projectCount: Int,
    val profilePictureUrl: String,
    val bannerUrl: String?,
    val instagramUrl: String?,
    val faceBookUrl: String?,
    val twitterUrl: String?,
    val isOwnProfile: Boolean,
    val isFollowing: Boolean
) {
    fun toUpdateProfileData(): UpdateProfileData {
        return UpdateProfileData(
            username = username,
            profilePictureUrl = profilePictureUrl,
            bio = bio,
            instagramUrl = instagramUrl,
            facebookUrl = faceBookUrl,
            twitterUrl = twitterUrl
        )
    }
}
