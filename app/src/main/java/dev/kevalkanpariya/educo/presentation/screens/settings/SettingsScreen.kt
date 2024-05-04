package dev.kevalkanpariya.educo.presentation.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.Grey50
import dev.kevalkanpariya.educo.ui.theme.Grey500
import dev.kevalkanpariya.educo.ui.theme.Grey700
import dev.kevalkanpariya.educo.ui.theme.Grey800
import dev.kevalkanpariya.educo.ui.theme.Grey900
import dev.kevalkanpariya.educo.ui.theme.subheadline_medium
import dev.kevalkanpariya.educo.ui.theme.title2
import dev.kevalkanpariya.educo.ui.theme.title3_normal

@Preview
@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)

    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
            }
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Settings", color = Grey900, style = title2)
            }

        }

        Spacer(modifier = Modifier.height(20.dp))
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Membership", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Memberships Users", color = Grey700, style = title3_normal)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(containerColor = Grey50)) {
                    Text(text = "upgrade", color = Grey800, style = subheadline_medium)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Account", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Profile settings", color = Grey700, style = title3_normal)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(containerColor = Grey50)) {
                    Text(text = "manage", color = Grey800, style = subheadline_medium)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Notifications", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Personalized Notifications", color = Grey700, style = title3_normal)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Security", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Password Change", color = Grey700, style = title3_normal)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(containerColor = Grey50)) {
                    Text(text = "manage", color = Grey800, style = subheadline_medium)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Help & Support", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "About Us", color = Grey700, style = title3_normal)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Terms & Condition", color = Grey700, style = title3_normal)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Privacy Policy", color = Grey700, style = title3_normal)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }



                }
            }

        }
    }
}
