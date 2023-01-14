package dev.kevalkanpariya.featuretesteduco.presentation.fogott_pass

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey100
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey200
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey50
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary600

@Preview
@Composable
fun CheckYourEmail() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Check your Email",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Text(
            text = "We’ve sent a password recover instruction to your email",
            fontSize = 14.sp,
            color = Grey200,
            modifier = Modifier.padding(10.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.emailcheck),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(210.dp)
        )
        Spacer(modifier = Modifier.height(60.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Primary600),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Text(
                text = "Open email app",
                color = Color.White,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            Text(
                text = "will do it later",
                color = Primary600,
                fontSize = 16.sp,
            )
        }
        Spacer(modifier = Modifier.height(52.dp))
        Text(
            text = "Didn’t get any email? Check your spam folder or try again with a valid email.",
            color = Grey200,
        )
    }
}