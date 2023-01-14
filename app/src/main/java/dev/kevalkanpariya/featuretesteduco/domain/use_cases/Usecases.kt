package dev.kevalkanpariya.featuretesteduco.domain.use_cases

import dev.kevalkanpariya.featuretesteduco.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import dev.kevalkanpariya.featuretesteduco.domain.use_cases.save_onboarding.SaveOnBoardingUseCase

data class UseCases(
    val saveOnBoardingUserCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)
