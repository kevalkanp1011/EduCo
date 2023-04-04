package dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.profile

import dev.kevalkanpariya.featuretesteduco.core.domain.models.Course

sealed class ProfileEvent {
    /*Access is restricted to teacher only*/
    data class DeleteCourse(val course: Course): ProfileEvent()
    object DismissLogoutDialog: ProfileEvent()
    object ShowLogoutDialog: ProfileEvent()
    object Logout: ProfileEvent()
    data class ToggleFollowStateForUser(val userId: String? = null): ProfileEvent()
}