package dev.kevalkanpariya.educo.data.repoImpl

import dev.kevalkanpariya.educo.domain.model.Resource
import dev.kevalkanpariya.educo.domain.repository.AuthRepository
import dev.kevalkanpariya.educo.domain.repository.AuthResource

class AuthRepoImpl(

): AuthRepository {
    override suspend fun signIn(): Resource<AuthResource> {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(): Resource<AuthResource> {
        TODO("Not yet implemented")
    }

    override suspend fun signUpWithGoogle(): Resource<AuthResource> {
        TODO("Not yet implemented")
    }

    override suspend fun signOut(userId: String): Resource<AuthResource> {
        TODO("Not yet implemented")
    }
}