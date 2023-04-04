package dev.kevalkanpariya.featuretesteduco.feature_settings.domain.models

import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.util.AuthError

data class ResetResult(
    val oldPasswordError: AuthError? = null,
    val newPasswordError: AuthError? = null,
    val confirmPasswordError: AuthError? = null,
    val result: SimpleResource? = null
)

