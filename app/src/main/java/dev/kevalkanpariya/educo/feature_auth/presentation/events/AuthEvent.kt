package dev.kevalkanpariya.educo.feature_auth.presentation.events

import android.content.Context

sealed class AuthEvent {

    data class OnSignInWithGoogleClicked(val activityContext: Context): AuthEvent()
}