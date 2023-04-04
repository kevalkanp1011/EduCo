package dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case

import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(): SimpleResource {
        return repository.authenticate()
    }
}