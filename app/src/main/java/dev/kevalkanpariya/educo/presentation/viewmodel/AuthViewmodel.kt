package dev.kevalkanpariya.educo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dev.kevalkanpariya.educo.google.GoogleUserModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AuthViewModel: ViewModel() {
    private var _user: MutableStateFlow<GoogleUserModel?> = MutableStateFlow(null)
    val user : StateFlow<GoogleUserModel?> = _user

    suspend fun fetchSignIn(email:String, displayName: String) {
        delay(2000) // Simulating network call
        _user.value = GoogleUserModel(email, displayName)
    }
}