package dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.domain.util.ValidationUtil
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.models.SignUpResult
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.repository.AuthRepository

class SignUpUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(
        email: String,
        username: String,
        password: String
    ): SignUpResult {
        val emailError = ValidationUtil.validateEmail(email)
        val usernameError = ValidationUtil.validateUsername(username)
        val passwordError = ValidationUtil.validatePassword(password)

        if(emailError != null || usernameError != null || passwordError != null) {
            return SignUpResult(
                emailError = emailError,
                usernameError = usernameError,
                passwordError = passwordError,
            )
        }

        val result = repository.signUp(email.trim(), username.trim(), password.trim())

        return SignUpResult(
            result = result
        )
    }
}