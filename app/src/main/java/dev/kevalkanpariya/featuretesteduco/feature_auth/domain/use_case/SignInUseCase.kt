package dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case


import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.models.SignInResult
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.repository.AuthRepository
import dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.util.AuthError

class SignInUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email: String, password: String): SignInResult {
        val emailError = if(email.isBlank()) AuthError.FieldEmpty else null
        val passwordError = if(password.isBlank()) AuthError.FieldEmpty else null

        if(emailError != null || passwordError != null) {
            return SignInResult(emailError, passwordError)
        }

        return SignInResult(
            result = repository.signIn(email, password)
        )
    }
}