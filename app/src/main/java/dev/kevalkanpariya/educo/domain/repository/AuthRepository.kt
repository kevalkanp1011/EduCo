package dev.kevalkanpariya.educo.domain.repository

import dev.kevalkanpariya.educo.domain.model.Resource

interface AuthRepository {

    suspend fun signIn(

    ): Resource<AuthResource>

    suspend fun signUp(

    ): Resource<AuthResource>

    suspend fun signUpWithGoogle(

    ): Resource<AuthResource>

    suspend fun signOut(
        userId: String
    ): Resource<AuthResource>
}

enum class AuthResource{

    SIGNUP_WITH_GOOGLE,
    SIGN_UP,
    SIGN_IN,
    SIGN_OUT
}