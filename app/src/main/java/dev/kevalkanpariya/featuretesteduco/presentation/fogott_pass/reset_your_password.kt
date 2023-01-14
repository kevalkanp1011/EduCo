package dev.kevalkanpariya.featuretesteduco.presentation.fogott_pass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.ErrorRed
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey100
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey500
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary600

@Preview
@Composable
fun ResetYourPassword() {
    var pwd by remember {
        mutableStateOf("")
    }
    var confirmpwd by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_hearder),
                contentDescription = null
            )
        }
        Column(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Reset your password", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = pwd,
                onValueChange = {
                    pwd = it
                },
                placeholder = {
                    Text(text = "password", color = Grey500)
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Grey100,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )
            Text(text = "Must contain 8 characters", color = ErrorRed)
            Spacer(modifier = Modifier.height(20.dp))
            TextField(
                value = confirmpwd,
                onValueChange = {
                    confirmpwd = it
                },
                placeholder = {
                    Text(text = "confirm your password", color = Grey500)
                },
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_eye),
                        contentDescription = "eye",
                        tint = Grey500
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor = Grey100,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )
            Text(text = "Must match both password", color = ErrorRed)
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Primary600),
                modifier = Modifier.fillMaxWidth().height(60.dp)
            ) {
                Text(
                    text = "Reset",
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }

        }
    }
}