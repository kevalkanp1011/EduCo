package dev.kevalkanpariya.educo.presentation.screens.signup

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.Primary600
import dev.kevalkanpariya.educo.ui.theme.Shapes
import dev.kevalkanpariya.educo.ui.theme.searchBarbg


@Preview
@Composable
fun SignUpWithEmailScreen() {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pwd by remember { mutableStateOf("") }
    var confirmpwd by remember { mutableStateOf("") }

    SignUpForm(
        username = username,
        onUsernameChanged = {},
        password = pwd,
        onPasswordChanged = {},
        confirmPassword = confirmpwd,
        onConfirmPasswordChanged = {},
        email = email,
        onEmailChanged = {}
    )



}


@Composable
fun SignUpForm(
    username: String,
    onUsernameChanged: (String) -> Unit,
    email: String,
    onEmailChanged: (String) -> Unit,
    password: String,
    onPasswordChanged: (String) -> Unit,
    confirmPassword: String,
    onConfirmPasswordChanged: (String) -> Unit,
) {

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {

        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {

            Text(
                modifier = Modifier.layoutId("title_txt"),
                text = "Enter your Details",
                color = Color(0xff101828),
                fontSize = 18.sp
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
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = searchBarbg,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )

            TextField(
                value = email,
                onValueChange = onEmailChanged,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.medium)
                    .layoutId(emailRef),
                label = null,
                placeholder = { Text(text = "Email Address") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = searchBarbg,
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
                        contentDescription = "",
                        modifier = Modifier.size(28.dp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = searchBarbg,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )

            TextField(
                value = confirmPassword,
                onValueChange = onConfirmPasswordChanged,
                label = null,
                placeholder = { Text(text = "Confirm Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.medium)
                    .layoutId(confirmPasswordRef),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = searchBarbg,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(Shapes.medium)
                    .layoutId(signUpButtonRef),
                colors = ButtonDefaults.buttonColors(backgroundColor = Primary600),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(text = "Continue", fontSize = 16.sp, color = Color.White)
            }

        }
    }

}

private fun decoupledConstraints(
    margin: Dp
): ConstraintSet {
    return ConstraintSet {
        val signUpButton = createRefFor(signUpButtonRef)
        val usernameText = createRefFor(usernameRef)
        val passwordText = createRefFor(passwordRef)
        val confirmPasswordText = createRefFor(confirmPasswordRef)
        val titleText = createRefFor(titleTextRef)
        val emailText = createRefFor(emailRef)




        constrain(titleText) {
            top.linkTo(parent.top, margin)
        }

        constrain(usernameText) {
            top.linkTo(titleText.bottom, margin)

        }

        constrain(emailText) {
            top.linkTo(usernameText.bottom, margin)
        }

        constrain(passwordText) {
            top.linkTo(emailText.bottom, margin)
        }

        constrain(confirmPasswordText) {
            top.linkTo(passwordText.bottom, margin)
        }

        constrain(signUpButton) {
            top.linkTo(confirmPasswordText.bottom, margin)
            bottom.linkTo(parent.bottom)
        }
    }
}


const val signUpButtonRef = "sign_up_button"
const val usernameRef = "username_txt"
const val emailRef = "email_txt"
const val passwordRef = "pwd"
const val confirmPasswordRef = "confirm_pwd"
const val titleTextRef = "title_txt"
