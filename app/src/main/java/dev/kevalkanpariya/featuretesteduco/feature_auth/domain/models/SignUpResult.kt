package dev.kevalkanpariya.featuretesteduco.feature_auth.domain.models

import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.util.AuthError

data class SignUpResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError: AuthError? = null,
    val result: SimpleResource? = null
)