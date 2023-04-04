package dev.kevalkanpariya.featuretesteduco.feature_profile.domain.use_case

data class ProfileUseCases(
    val getCoursesForProfile: GetCoursesForProfileUseCase,
    val getProfile: GetProfileUseCase,
    val getProfileHeaderUseCase: GetProfileHeaderUseCase,
    val getUserInfosUseCase: GetUserInfosUseCase,
    val updateProfile: UpdateProfileDataUseCase,
    val logout: LogoutUseCase,

)
