package dev.kevalkanpariya.educo.presentation.screens.signin

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.navigation.Screen
import dev.kevalkanpariya.educo.presentation.components.buttons.FaceBookButton
import dev.kevalkanpariya.educo.presentation.components.buttons.GoogleButton
import dev.kevalkanpariya.educo.ui.theme.Grey50
import dev.kevalkanpariya.educo.ui.theme.Grey900
import dev.kevalkanpariya.educo.ui.theme.Primary600
import dev.kevalkanpariya.educo.ui.theme.Shapes
import dev.kevalkanpariya.educo.ui.theme.searchBarbg


@Preview
@Composable
fun PreviewSignInScreen() {
    var username by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    SignInScreen(
        navController = rememberNavController(),
        onClick = {},
        errorText = null,
        username = username,
        password = pwd,
        onUsernameChanged = {},
        onPasswordChanged = {}
    )
}

@Composable
fun SignInScreen(
    onClick: () -> Unit,
    errorText: String?,
    navController: NavHostController,
    onUsernameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    username: String,
    password: String
) {

    var isLoading by remember { mutableStateOf(false) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            //.padding(horizontal = 20.dp)
    ) {

        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
            constraintSet = constraints
        ) {


            Text(
                modifier = Modifier.layoutId(greetTextRef),
                text = "Welcome!\nSign in to continue!",
                color = Grey900,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                textAlign = TextAlign.Center
            )

            GoogleButton(
                backgroundColor = Grey50,
                modifier = Modifier
                    .layoutId(googleButtonRef)
            ) {
                isLoading = true
                onClick()
            }

            FaceBookButton(
                backgroundColor = Grey50,
                modifier = Modifier
                    .layoutId(facebookButtonRef)
            ) {
            }

            Text(
                text = "or",
                fontSize = 18.sp,
                color = Color(0xff585D69),
                modifier = Modifier.layoutId(orText)
            )

            TextField(
                value = username,
                onValueChange = onUsernameChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.medium)
                    .layoutId(usernameRef),
                label = null,
                placeholder = { Text(text = "User name") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = searchBarbg,
                    unfocusedContainerColor = searchBarbg,
                    disabledContainerColor = searchBarbg,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )

            TextField(
                value = password,
                onValueChange = onPasswordChanged,
                label = null,
                placeholder = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.medium)
                    .layoutId(passwordRef),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "search_icon",
                        modifier = Modifier.size(28.dp)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = searchBarbg,
                    unfocusedContainerColor = searchBarbg,
                    disabledContainerColor = searchBarbg,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )


            TextButton(
                modifier = Modifier.layoutId(signInButtonRef),
                onClick = {
                    navController.navigate(Screen.Register.route)
                }
            ) {
                Text(
                    text = "Sign in",
                    color = Primary600,
                    fontSize = 16.sp
                )
            }
            errorText?.let {
                isLoading = false
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = it)
            }
            TextButton(
                modifier = Modifier.layoutId(forgotPwdBtnRef),
                onClick = {
                    navController.navigate(Screen.Home.route)
                }
            ) {
                Text(
                    text = "Forgot Password", color = Primary600, fontSize = 16.sp
                )
            }
        }

    }


}

private fun decoupledConstraints(
    margin: Dp
): ConstraintSet {
    return ConstraintSet {

        val greetText = createRefFor(greetTextRef)
        val googleButton = createRefFor(googleButtonRef)
        val facebookButton = createRefFor(facebookButtonRef)
        val orText = createRefFor(orText)
        val usernameText = createRefFor(usernameRef)
        val pwdText = createRefFor(passwordRef)
        val signInButton = createRefFor(signInButtonRef)
        val forgotPwdTxt = createRefFor(forgotPwdBtnRef)

        constrain(greetText) {
            top.linkTo(parent.top, 50.dp)
            start.linkTo(parent.start, margin)
            end.linkTo(parent.end, margin)
        }


        constrain(googleButton) {
            top.linkTo(greetText.bottom, 40.dp)
            start.linkTo(parent.start, margin)
            end.linkTo(parent.end, margin)
        }

        constrain(facebookButton) {
            start.linkTo(parent.start, margin)
            end.linkTo(parent.end, margin)
            top.linkTo(googleButton.bottom, 20.dp)
        }

        constrain(orText) {
            start.linkTo(parent.start, margin)
            end.linkTo(parent.end, margin)
            top.linkTo(facebookButton.bottom, 20.dp)
        }

        constrain(usernameText) {
            start.linkTo(parent.start, margin)
            end.linkTo(parent.end, margin)
            top.linkTo(orText.bottom, 30.dp)
        }

        constrain(pwdText) {
            start.linkTo(parent.start, margin)
            end.linkTo(parent.end, margin)
            top.linkTo(usernameText.bottom, 20.dp)
        }

        constrain(signInButton) {
            start.linkTo(parent.start, margin)
            end.linkTo(parent.end, margin)
            bottom.linkTo(forgotPwdTxt.top, 10.dp)
        }

        constrain(forgotPwdTxt) {
            start.linkTo(parent.start, margin)
            end.linkTo(parent.end, margin)
            bottom.linkTo(parent.bottom, 16.dp)
        }

    }
}


private const val greetTextRef = "greet_txt"
private const val googleButtonRef = "google_btn"
private const val facebookButtonRef = "facebook_btn"
private const val orText = "or_txt"
private const val usernameRef = "username_txt"
private const val passwordRef = "pwd"
private const val signInButtonRef = "sign_in_button"
private const val forgotPwdBtnRef = "forgot_pwd_btn"

