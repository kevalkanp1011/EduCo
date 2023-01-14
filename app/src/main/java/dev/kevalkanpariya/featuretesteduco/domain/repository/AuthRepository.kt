package dev.kevalkanpariya.featuretesteduco.domain.repository

import dev.kevalkanpariya.featuretesteduco.domain.model.ApiRequest
import dev.kevalkanpariya.featuretesteduco.domain.model.ApiResponse
import dev.kevalkanpariya.featuretesteduco.domain.model.UserUpdate
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun saveSignedInState(signedIn: Boolean)
     fun readSignedInState(): Flow<Boolean>
    suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse
    suspend fun getUserInfo(): ApiResponse
    suspend fun updateUser(userUpdate: UserUpdate): ApiResponse
    suspend fun deleteUser(): ApiResponse
    suspend fun clearSession(): ApiResponse

    //suspend fun
}