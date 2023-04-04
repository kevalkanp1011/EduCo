package dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case

import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.repository.AuthRepository
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.util.AuthError
import dev.kevalkanpariya.featuretesteduco.feature_settings.domain.models.ResetResult

class ResetPasswordUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        oldPassword: String,
        newPassword: String,
        confirmPassword: String
    ): ResetResult {
        val oldPasswordError = if(oldPassword.isBlank()) AuthError.FieldEmpty else null
        val newPasswordError = if(newPassword.isBlank()) AuthError.FieldEmpty else null
        val confirmPasswordError = if(confirmPassword.isBlank()) {
            AuthError.FieldEmpty
        } else if (confirmPassword != newPassword) {
            AuthError.MustMatchBothPassword
        } else {
            null
        }

        if(oldPasswordError != null || newPasswordError != null || confirmPasswordError != null) {
            return ResetResult(oldPasswordError, newPasswordError, confirmPasswordError)
        }

        return ResetResult(
            result = repository.resetPassword(oldPassword, newPassword)
        )

    }
}