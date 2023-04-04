package dev.kevalkanpariya.featuretesteduco.feature_settings.presentation

import android.content.Context
import android.net.Uri

sealed class SettingsEvent {

    data class EnteredOldPassword(val oldPassword: String): SettingsEvent()
    data class EnteredNewPassword(val newPassword: String): SettingsEvent()
    data class EnteredConfirmPassword(val confirmPassword: String): SettingsEvent()
    data class OnChecked(val isChecked: Boolean): SettingsEvent()

    data class EnteredBio(val bio: String): SettingsEvent()
    data class EnteredUsername(val username: String): SettingsEvent()
    data class EnteredInstagramUrl(val instagramUrl: String): SettingsEvent()
    data class EnteredFacebookUrl(val facebookUrl: String): SettingsEvent()
    data class EnteredTwitterUrl(val twitterUrl: String): SettingsEvent()

    object Reset: SettingsEvent()
    object TogglePasswordVisibility: SettingsEvent()
    object Cancel: SettingsEvent()
    object SignOut: SettingsEvent()
    data class Save(val context: Context): SettingsEvent()

}