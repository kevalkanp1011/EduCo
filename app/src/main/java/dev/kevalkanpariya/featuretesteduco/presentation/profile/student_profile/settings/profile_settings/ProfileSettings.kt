package dev.kevalkanpariya.featuretesteduco.presentation.profile.student_profile.settings.profile_settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun ProfileSettings() {
    var username by remember {
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
                .fillMaxWidth(),
        ) {
            Text(text = "Profile Settings", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.inst1),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Change profile picture",
                    color = Primary600,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            TextField(
                value = username,
                onValueChange = {
                    username = it
                },
                placeholder = {
                    Text(
                        text = "username",
                        color = Grey500,
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
            Text(text = "this user name is alrady taken", color = ErrorRed)
            Spacer(modifier = Modifier.height(210.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(44.dp),
                        colors = buttonColors(backgroundColor = Color.White)
                    ) {
                        Text(
                            text = "Cancel",
                            color = Error500,
                            modifier = Modifier.padding(horizontal = 22.dp)
                        )
                    }
                    TextButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.height(44.dp),
                        colors = buttonColors(backgroundColor = Primary600)
                    ) {
                        Text(
                            text = "Save",
                            color = Color.White,
                            modifier = Modifier.padding(horizontal = 22.dp)
                        )
                    }
                }
            }
        }
    }
}