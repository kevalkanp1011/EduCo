package dev.kevalkanpariya.featuretesteduco.domain.use_cases.save_onboarding

import dev.kevalkanpariya.featuretesteduco.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository : Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed = completed)
    }
}