package dev.kevalkanpariya.educo.google

import android.app.Application
import android.content.Context
import androidx.lifecycle.*
import com.google.android.gms.auth.api.signin.GoogleSignIn
import kotlinx.coroutines.launch

class SignInGoogleViewModel(application: Application) : AndroidViewModel(application) {
    private var _userState = MutableLiveData<GoogleUserModel>()
    val googleUser: LiveData<GoogleUserModel> = _userState

    private var _loadingState = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loadingState

    init {
        checkSignedInUser(application.applicationContext)
    }

    fun fetchSignInUser(email: String, name: String) {
        _loadingState.value = true

        viewModelScope.launch {
            _userState.value = GoogleUserModel(
                email = email,
                name = name,
            )
        }

        _loadingState.value = false
    }

    private fun checkSignedInUser(applicationContext: Context) {
        _loadingState.value = true

        val gsa = GoogleSignIn.getLastSignedInAccount(applicationContext)
        if (gsa != null) {
            _userState.value = GoogleUserModel(
                email = gsa.email.toString(),
                name = gsa.displayName.toString(),
            )
        }

        _loadingState.value = false
    }

    fun hideLoading() {
        _loadingState.value = false
    }

    fun showLoading() {
        _loadingState.value = true
    }
}

class SignInGoogleViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignInGoogleViewModel::class.java)) {
            return SignInGoogleViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}