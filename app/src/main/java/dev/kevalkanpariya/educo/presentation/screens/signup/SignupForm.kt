package dev.kevalkanpariya.educo.presentation.screens.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.Primary600
import dev.kevalkanpariya.educo.ui.theme.Shapes
import dev.kevalkanpariya.educo.ui.theme.searchBarbg

@Preview
@Composable
fun SignupForm() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var pwd by remember { mutableStateOf("") }
        var confirmpwd by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
            }
        }
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
            placeholder = { Text(text = "User name") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = searchBarbg,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
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
                backgroundColor = searchBarbg,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
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
                .clip(Shapes.medium),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = searchBarbg,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
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