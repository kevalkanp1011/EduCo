package dev.kevalkanpariya.featuretesteduco.domain.use_cases.read_onboarding

import dev.kevalkanpariya.featuretesteduco.data.repository.Repository
import kotlinx.coroutines.flow.Flow

class ReadOnBoardingUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<Boolean> =
        repository.readOnBoardingState()

}