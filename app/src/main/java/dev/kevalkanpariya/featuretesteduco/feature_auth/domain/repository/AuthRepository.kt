package dev.kevalkanpariya.featuretesteduco.feature_auth.domain.repository

import dev.kevalkanpariya.featuretesteduco.core.util.SimpleResource

interface AuthRepository {

    suspend fun signUp(
        email: String,
        username: String,
        password: String
    ): SimpleResource

    suspend fun signIn(
        email: String,
        password: String
    ): SimpleResource

    suspend fun resetPassword(
        oldPassword: String,
        newPassword: String
    ): SimpleResource

    suspend fun authenticate(): SimpleResource
}