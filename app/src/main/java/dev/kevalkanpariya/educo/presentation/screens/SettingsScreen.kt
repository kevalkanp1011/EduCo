package dev.kevalkanpariya.educo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.*

@Preview
@Composable
fun SettingsScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(horizontal = 20.dp)

    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(100.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
            }
            Text(text = "Settings", color = Grey900, fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(20.dp))
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Membership", color = Grey500)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Memberships Users", color = Grey700)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Grey50)) {
                    Text(text = "upgrade", color = Grey800)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Account", color = Grey500)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Profile settings", color = Grey700)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Grey50)) {
                    Text(text = "manage", color = Grey800)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Notifications", color = Grey500)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Personalized Notifications", color = Grey700)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Security", color = Grey500)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Password Change", color = Grey700)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Grey50)) {
                    Text(text = "manage", color = Grey800)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Help & Support", color = Grey500)
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "About Us", color = Grey700)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Terms & Condition", color = Grey700)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Privacy Policy", color = Grey700)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }



                }
            }

        }
    }
}