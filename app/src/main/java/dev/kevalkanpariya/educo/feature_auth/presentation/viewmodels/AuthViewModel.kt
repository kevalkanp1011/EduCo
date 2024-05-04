package dev.kevalkanpariya.educo.feature_auth.presentation.viewmodels

import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.core.data.dto.Resource
import dev.kevalkanpariya.educo.feature_auth.domain.repository.AuthRepository
import dev.kevalkanpariya.educo.feature_auth.presentation.events.AuthEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch



class AuthViewModel(
    private val authRepo: AuthRepository,
    private val credentialManager: CredentialManager
) : ViewModel() {


    fun onEvent(event: AuthEvent) {

        when (event) {


            is AuthEvent.OnSignInWithGoogleClicked -> {

                val googleIdOption: GetSignInWithGoogleOption = GetSignInWithGoogleOption.Builder(
                    event.activityContext.getString(
                        R.string.default_web_client_id
                    )
                ).build()

                val request: GetCredentialRequest = GetCredentialRequest.Builder()
                    .addCredentialOption(googleIdOption)
                    .build()

                viewModelScope.launch(Dispatchers.IO) {
                    val result = credentialManager.getCredential(
                        request = request,
                        context = event.activityContext,
                    )
                    authRepo.signInWithGoogle(result).handleResponse(
                        onSuccess = {
                            Log.d("authviewmodel", "signinwithgoogle sucessful:: ${it?.userId}")
                        },
                        onError = {
                            Log.d("authviewmodel", "signinwithgoogle error:: ${it}")
                        }
                    )
                }


            }

            else -> Unit
        }

    }


}


fun <T> Resource<T>.handleResponse(
    onSuccess: (T?) -> Unit,
    onError: (String?) -> Unit = {}
) {

    when (this) {
        is Resource.Success -> onSuccess(
            this.data
        )

        is Resource.Error -> onError(this.error)
    }
}