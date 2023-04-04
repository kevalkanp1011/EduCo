package dev.kevalkanpariya.featuretesteduco.feature_auth.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.util.Resource
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.feature_auth.domain.use_case.AuthenticateUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        viewModelScope.launch {
            when(authenticateUseCase()) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvent.Navigate(Screen.HomeScreen.route)
                    )
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.Navigate(Screen.SignInScreen.route)
                    )
                }
            }
        }
    }
}