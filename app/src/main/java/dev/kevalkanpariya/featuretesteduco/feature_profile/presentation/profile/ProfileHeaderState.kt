package dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.profile

import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.ProfileHeader

data class ProfileHeaderState(
    val profileHeader: ProfileHeader,
    val isLoading: Boolean = false,
    val isLogoutDialogVisible: Boolean = false
)