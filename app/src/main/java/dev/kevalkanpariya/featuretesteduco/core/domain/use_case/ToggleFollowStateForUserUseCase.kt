package dev.kevalkanpariya.featuretesteduco.core.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.repository.ProfileRepository
import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource

class ToggleFollowStateForUserUseCase(
    private val repository: ProfileRepository
) {

    suspend operator fun invoke(followedUserId: String, isFollowing: Boolean): SimpleResource {
        return if(isFollowing == true) {
            repository.unfollowUser(followedUserId)
        } else {
            repository.followUser(followedUserId)
        }
    }
}