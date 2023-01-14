package dev.kevalkanpariya.featuretesteduco.presentation.signup

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.presentation.components.topbar.BackIconBar
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey100
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey200
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary600
import dev.kevalkanpariya.featuretesteduco.ui.theme.Shapes

@Preview
@Composable
fun SignupForm() {

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var pwd by rememberSaveable { mutableStateOf("") }
    var confirmpwd by remember { mutableStateOf("") }
    var passwordVisibility by remember {
        mutableStateOf(false)
    }
    val passwordIcon = if (passwordVisibility)
        painterResource(id = R.drawable.ic_eye)
    else
        painterResource(id = R.drawable.ic_eye)

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        BackIconBar()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
        ) {

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Enter your Details",
                color = Color(0xff101828),
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = username,
                onValueChange = {
                    username = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.medium),
                label = null,
                placeholder = { Text(text = "Username") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Grey200,
                    unfocusedIndicatorColor = Grey100
                ),
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.medium),
                label = null,
                placeholder = { Text(text = "Email Address") },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Grey200,
                    unfocusedIndicatorColor = Grey100
                )
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = pwd,
                onValueChange = {
                    pwd = it
                },
                label = null,
                placeholder = { Text(text = "Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.medium),
                trailingIcon = {
                    IconButton(onClick = {
                        passwordVisibility = !passwordVisibility
                    }) {
                        Icon(
                            painter = passwordIcon,
                            contentDescription = "",
                            modifier = Modifier.size(28.dp)
                        )
                    }

                },
                visualTransformation = if (passwordVisibility)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Grey200,
                    unfocusedIndicatorColor = Grey100
                ),
            )
            Spacer(modifier = Modifier.height(24.dp))
            TextField(
                value = confirmpwd,
                onValueChange = {
                    confirmpwd = it
                },
                label = null,
                placeholder = { Text(text = "Confirm Password") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(Shapes.medium)
                    ,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Grey200,
                    unfocusedIndicatorColor = Grey100
                ),
            )
            Spacer(modifier = Modifier.height(128.5.dp))


            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .clip(Shapes.medium),
                colors = ButtonDefaults.buttonColors(backgroundColor = Primary600),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(text = "Continue", fontSize = 16.sp, color = Color.White)
            }

        }
    }



}
