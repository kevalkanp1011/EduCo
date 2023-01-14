package dev.kevalkanpariya.featuretesteduco.domain.repository

import kotlinx.coroutines.flow.Flow

interface DataStoreOperations {
    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>

    /*Authentication*/
    suspend fun saveSignedInState(signedIn: Boolean)
    fun readSignedInState(): Flow<Boolean>
}