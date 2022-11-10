package dev.kevalkanpariya.educo.presentation

import android.app.Application
import android.content.res.Configuration
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.android.gms.common.api.ApiException
import com.ramcosta.composedestinations.annotation.Destination
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.google.GoogleApiContract
import dev.kevalkanpariya.educo.google.SignInGoogleViewModel
import dev.kevalkanpariya.educo.google.SignInGoogleViewModelFactory
import dev.kevalkanpariya.educo.navigation.Screen
import dev.kevalkanpariya.educo.presentation.components.FullScreenLoaderComponent
import timber.log.Timber

@Destination
@Composable
fun AuthScreen(
    navController: NavHostController,
) {
    val signInRequestCode = 1
    val context = LocalContext.current

    val mSignInViewModel: SignInGoogleViewModel = viewModel(
        factory = SignInGoogleViewModelFactory(context.applicationContext as Application)
    )

    val state = mSignInViewModel.googleUser.observeAsState()
    val user = state.value

    val isError = rememberSaveable { mutableStateOf(false) }

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = GoogleApiContract()) { task ->
            try {
                val gsa = task?.getResult(ApiException::class.java)

                if (gsa != null) {
                    val listWithNulls: List<String?> = listOf(gsa.email, gsa.displayName)

                    gsa.email?.let { gsa.displayName?.let { it1 ->
                        mSignInViewModel.fetchSignInUser(it,
                            it1
                        )
                    } }
                } else {
                    isError.value = true
                }

            } catch (e: ApiException) {
                Timber.d("Error in AuthScreen%s", e.toString())
            }
        }

    AuthView(
        onClick = { authResultLauncher.launch(signInRequestCode) },
        isError = isError.value,
        mSignInViewModel
    )
    // Strange issue after upgrading to latest version
    if (mSignInViewModel.googleUser.value != null) {
        LaunchedEffect(key1 = Unit) {
            mSignInViewModel.hideLoading()

            navController.navigate(
                route = Screen.Home.route
            )
        }
    }
}

@Composable
private fun AuthView(
    onClick: () -> Unit,
    isError: Boolean = false,
    mSignInViewModel: SignInGoogleViewModel
) {
    val state = mSignInViewModel.loading.observeAsState()
    val isLoading = state.value

    Scaffold {
        if (isLoading == true && !isError) {
            FullScreenLoaderComponent()
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.weight(1F))
                Image(
                    painterResource(id = R.drawable.profile_image),
                    contentDescription = "app logo",
                )
                Spacer(modifier = Modifier.weight(1F))
                SignInGoogleButton(onClick = {
                    mSignInViewModel.showLoading()
                    onClick()
                })
                Spacer(modifier = Modifier.weight(1F))
                Text(
                    text = "Made By Keval kanpariya",
                    textAlign = TextAlign.Center,
                )

                when {
                    isError -> {
                        isError.let {
                            Text(
                                stringResource(R.string.auth_error_msg),
                                style = MaterialTheme.typography.h6,
                                color = MaterialTheme.colors.error
                            )
                            mSignInViewModel.hideLoading()
                        }
                    }
                }
            }
        }
    }
}


@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun PreviewAuthView() {
    Surface {
        Temp()
    }
}

@Composable
private fun Temp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1F))
        Image(
            painterResource(id = R.drawable.profile_image),
            contentDescription = "app logo",
        )
        Spacer(modifier = Modifier.weight(1F))
        SignInGoogleButton(onClick = {})

    }
}

@Composable
fun SignInGoogleButton(
    onClick: () -> Unit,
) {
    Surface(
        modifier = Modifier.clickable(
            onClick = onClick
        ),
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        color = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            ).fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google_logo),
                contentDescription = "Google Login",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign in With Google"
            )

            Spacer(modifier = Modifier.width(16.dp))
        }
    }
}