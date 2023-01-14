package dev.kevalkanpariya.featuretesteduco.presentation.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.domain.model.ApiResponse
import dev.kevalkanpariya.featuretesteduco.domain.model.MessageBarState
import dev.kevalkanpariya.featuretesteduco.domain.model.User
import dev.kevalkanpariya.featuretesteduco.domain.repository.AuthRepository
import dev.kevalkanpariya.featuretesteduco.util.RequestState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repository: AuthRepository
): ViewModel() {

    private val _user: MutableState<User?> = mutableStateOf(null)
    val user: State<User?> = _user

    private val _firstName: MutableState<String> = mutableStateOf("")
    val firstName: State<String> = _firstName

    private val _lastName: MutableState<String> = mutableStateOf("")
    val lastName: State<String> = _lastName

    private val _apiResponse: MutableState<RequestState<ApiResponse>> =
        mutableStateOf(RequestState.Idle)
    val apiResponse: State<RequestState<ApiResponse>> = _apiResponse

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        _apiResponse.value = RequestState.Loading
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    repository.getUserInfo()
                }
                _apiResponse.value = RequestState.Success(response)

                if (response.user != null) {
                    _user.value = response.user
                    _firstName.value = response.user.name.split(" ").first()
                    _lastName.value = response.user.name.split(" ").last()
                }
            } catch (e: Exception) {
                _apiResponse.value = RequestState.Error(e)
                _messageBarState.value = MessageBarState(error = e)
            }
        }
    }
}