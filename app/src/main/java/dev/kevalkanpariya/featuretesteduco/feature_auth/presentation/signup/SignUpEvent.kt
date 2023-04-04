package dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.signup

sealed class SignUpEvent {
    data class EnteredUsername(val value: String): SignUpEvent()
    data class EnteredEmail(val value: String): SignUpEvent()
    data class EnteredPassword(val value: String): SignUpEvent()
    object TogglePasswordVisibility : SignUpEvent()
    object SignUp : SignUpEvent()
}