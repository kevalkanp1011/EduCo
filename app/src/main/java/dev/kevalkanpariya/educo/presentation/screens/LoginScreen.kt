package dev.kevalkanpariya.educo.presentation.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.android.gms.common.api.ApiException
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.google.GoogleApiContract
import dev.kevalkanpariya.educo.presentation.viewmodel.AuthViewModel
import dev.kevalkanpariya.educo.ui.theme.Grey50
import dev.kevalkanpariya.educo.ui.theme.Grey900
import dev.kevalkanpariya.educo.ui.theme.Shapes
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel,
    navController: NavHostController
) {
    val signInRequestCode = 1
    val coroutineScope = rememberCoroutineScope()
    val user by remember(authViewModel) { authViewModel.user }.collectAsState()
    var text by remember { mutableStateOf<String?>(null) }

    val authResultLauncher =
        rememberLauncherForActivityResult(contract = GoogleApiContract()) { task ->
            try {
                val account = task?.getResult(ApiException::class.java)
                if (account != null) {
                    coroutineScope.launch {
                        authViewModel.fetchSignIn(
                            email = account.email.toString(),
                            displayName = account.displayName.toString(),
                        )
                    }
                } else {
                    text = "Google sign in failed"
                }
            } catch (e: ApiException) {
                text = "Google sign in failed"
            }
        }

    AuthView(
        onClick = {  text = null
            authResultLauncher.launch(signInRequestCode) },
        errorText = text
    )
    user?.let {
        HomeScreen(userModel = it)
    }
    // Strange issue after upgrading to latest version
    /*if (mSignInViewModel.googleUser.value != null) {
        LaunchedEffect(key1 = Unit) {
            mSignInViewModel.hideLoading()
            navigator.navigate(
                HomeScreenDestination(
                    GoogleUserModel(
                        email = user?.email,
                        name = user?.name,
                    )
                )
            ) {
                popUpTo(route = LoginScreenDestination.route) {
                    inclusive = true
                }
            }
        }
    }*/
}

@Composable
fun AuthView(
    onClick: () -> Unit,
    errorText: String?,
) {
    //val isLoading = state.value
    var isLoading by remember { mutableStateOf(false) }
    
    Scaffold {
            Column(
                Modifier.padding(35.dp),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(45.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Welcome!",
                        color = Grey900,
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                    Text(
                        text = "Sign up to continue!",
                        color = Grey900,
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                }
                Spacer(modifier = Modifier.height(60.dp))
                GoogleButton(backgroundColor = Grey50){
                    isLoading = true
                    onClick()
                }
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "By signing up you are agreed with our",
                        fontSize = 14.sp
                    )
                    Text(
                        text = "friendly terms and condition.",
                        fontSize = 14.sp
                    )
                }
                errorText?.let {
                    isLoading = false
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(text = it)
                }

            }
    }

}

@Composable
fun GoogleButton(
    modifier: Modifier = Modifier,
    text: String = "Sign Up with Google",
    isLoading: Boolean = false,
    loadingText: String = "Creating Account...",
    icon: Int = R.drawable.ic_google_logo,
    shape: Shape = Shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    onClicked: () -> Unit
) {

    Surface(
        modifier = modifier
            .clickable(
                enabled = isLoading,
                onClick = onClicked
            )
            .fillMaxWidth(),
        shape = shape,
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "Google Button",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = if (isLoading) loadingText else text,
                color = Grey900,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            if (isLoading) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
            }
        }
    }
}

/*Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignInButton(
                text = "Sign in with Google",
                loadingText = "Signing in...",
                isLoading = isLoading,
                icon = painterResource(id = R.drawable.ic_google_logo),
                onClick = {
                    isLoading = true
                    onClick()
                }
            )

            errorText?.let {
                isLoading = false
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = it)
            }
        }
    }*/
