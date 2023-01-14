package dev.kevalkanpariya.featuretesteduco.presentation.fogott_pass

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.*

@Preview
@Composable
fun EnterYourEmail() {
    var email by remember{
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
            Text(
                text = "Enter Your Email",
                color = Color(0xFF101828),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = email,
                onValueChange = {
                    email = it
                },
                placeholder = {
                    Text(text = "email address", color = Grey500, modifier = Modifier.padding(start = 0.dp))
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
            Text(text = "The email address you provided is not associated with your account", color = Error500)
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = buttonColors(backgroundColor = Primary600),
                modifier = Modifier.fillMaxWidth().height(60.dp)
            ) {
                Text(
                    text = "sent email",
                    color = Color.White,
                    fontSize = 16.sp,
                )
            }
        }
    }
}