package dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.util

import dev.kevalkanpariya.featuretesteduco.core.util.Error

sealed class AuthError : Error() {
    object FieldEmpty : AuthError()
    object InputTooShort : AuthError()
    object InvalidEmail: AuthError()
    object InvalidPassword : AuthError()
    object MustMatchBothPassword: AuthError()
}