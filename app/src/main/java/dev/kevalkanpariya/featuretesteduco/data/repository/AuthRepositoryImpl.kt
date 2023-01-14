package dev.kevalkanpariya.featuretesteduco.data.repository

import dev.kevalkanpariya.featuretesteduco.data.remote.KtorApi
import dev.kevalkanpariya.featuretesteduco.domain.model.ApiRequest
import dev.kevalkanpariya.featuretesteduco.domain.model.ApiResponse
import dev.kevalkanpariya.featuretesteduco.domain.model.UserUpdate
import dev.kevalkanpariya.featuretesteduco.domain.repository.AuthRepository
import dev.kevalkanpariya.featuretesteduco.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    private val ktorApi: KtorApi
): AuthRepository {
    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStoreOperations.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()
    }

    override suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse {
        return try {
            ktorApi.verifyTokenOnBackend(request = request)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun getUserInfo(): ApiResponse {
        return try {
            ktorApi.getUserInfo()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun updateUser(userUpdate: UserUpdate): ApiResponse {
        return try {
            ktorApi.updateUser(userUpdate = userUpdate)
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun deleteUser(): ApiResponse {
        return try {
            ktorApi.deleteUser()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }

    override suspend fun clearSession(): ApiResponse {
        return try {
            ktorApi.clearSession()
        } catch (e: Exception) {
            ApiResponse(success = false, error = e)
        }
    }
}