package dev.kevalkanpariya.educo.feature_auth.data.repoImpl

import android.util.Log
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialResponse
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.feature_auth.data.dto.User
import dev.kevalkanpariya.educo.feature_auth.data.dto.requests.SignUpWithFormRequest
import dev.kevalkanpariya.educo.feature_auth.data.dto.responses.SignInWithFormResponse
import dev.kevalkanpariya.educo.core.data.dto.Resource
import dev.kevalkanpariya.educo.feature_auth.data.dto.responses.SignInWithGoogleResponse
import dev.kevalkanpariya.educo.feature_auth.domain.repository.AuthRepository
import dev.kevalkanpariya.educo.feature_auth.domain.repository.AuthResource
import kotlinx.coroutines.tasks.await

private const val TAG = "AuthRepoImpl"
class AuthRepoImpl(
    private val firebaseAuth: FirebaseAuth,
    private val db: FirebaseFirestore
): AuthRepository {
    override suspend fun signInWithForm(email: String, password: String): Resource<SignInWithFormResponse> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password)
                .await()
            val userId = result.user?.uid

            if (userId != null) {
                Resource.Success(data = SignInWithFormResponse(userId))
            } else {
                Resource.Error("database error")
            }

        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "something went wrong")
        }
    }

    override suspend fun signUpWithForm(request: SignUpWithFormRequest): Resource<AuthResource> {
        return try {

            val task = firebaseAuth.createUserWithEmailAndPassword(request.email, request.pwd)

            val userId = task.await().user?.uid

            if (userId != null) {
                db.collection("users")
                    .document(userId)
                    .set(
                        User(
                            id = userId,
                            name = request.name,
                            email = request.email,
                            username = request.username
                        )
                    )

                Resource.Success(data = null)
            } else {
                Resource.Error("database error")
            }


        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "something went wrong")
        }
    }

    override suspend fun signInWithGoogle(result: GetCredentialResponse): Resource<SignInWithGoogleResponse> {
        return try {

            val credential = result.credential

            when (credential) {

                is CustomCredential -> {
                    if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                        try {
                            // Use googleIdTokenCredential and extract id to validate and
                            // authenticate on your server.
                            val googleIdTokenCredential = GoogleIdTokenCredential
                                .createFrom(credential.data)



                            val authCredential = GoogleAuthProvider.getCredential(googleIdTokenCredential.idToken, null)

                            val user = firebaseAuth.signInWithCredential(authCredential).await().user
                            val isUserExist = db.collection("users").document(user?.uid!!).get().isSuccessful
                            if (!isUserExist) {
                                db.collection("users")
                                    .document(user.uid)
                                    .set(
                                        User(
                                            id = user.uid,
                                            name = user.displayName!!,
                                            email = user.email!!,
                                            username = user.email!!
                                        )
                                    )
                            }

                            return Resource.Success(data = user?.uid?.let {
                                SignInWithGoogleResponse(
                                    userId = it,
                                )
                            })

                        } catch (e: GoogleIdTokenParsingException) {
                            Log.e(TAG, "Received an invalid google id token response", e)
                            return Resource.Error(e.message?: "something went wrong")
                        }
                    } else {
                        // Catch any unrecognized custom credential type here.
                        Log.e(TAG, "Unexpected type of credential")
                        return Resource.Error("Unexpected type of credential")
                    }
                }

                else -> {
                    // Catch any unrecognized credential type here.
                    Log.e(TAG, "Unexpected type of credential")
                    return Resource.Error("Unexpected type of credential")
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "something went wrong")
        }
    }

    override suspend fun signOut(userId: String): Resource<AuthResource> {
        return try {

            Resource.Success(data = null)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message?: "something went wrong")
        }
    }
}