package dev.kevalkanpariya.educo.feature_auth.domain.repository

import androidx.credentials.GetCredentialResponse
import dev.kevalkanpariya.educo.feature_auth.data.dto.requests.SignUpWithFormRequest
import dev.kevalkanpariya.educo.feature_auth.data.dto.responses.SignInWithFormResponse
import dev.kevalkanpariya.educo.core.data.dto.Resource
import dev.kevalkanpariya.educo.feature_auth.data.dto.responses.SignInWithGoogleResponse

interface AuthRepository {

    suspend fun signInWithForm(
        email: String, password: String
    ): Resource<SignInWithFormResponse>

    suspend fun signUpWithForm(
        request: SignUpWithFormRequest
    ): Resource<AuthResource>

    suspend fun signInWithGoogle(
        result: GetCredentialResponse
    ): Resource<SignInWithGoogleResponse>

    suspend fun signOut(
        userId: String
    ): Resource<AuthResource>
}

enum class AuthResource {

    SIGNUP_WITH_GOOGLE,
    SIGN_UP,
    SIGN_IN,
    SIGN_OUT
}