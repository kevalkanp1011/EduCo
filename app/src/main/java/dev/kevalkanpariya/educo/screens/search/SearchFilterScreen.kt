package dev.kevalkanpariya.educo.screens.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.Error500
import dev.kevalkanpariya.educo.ui.theme.Primary600


@Preview
@Composable
fun SearchFilterScreen() {
    LazyColumn() {
        item {
            Spacer(modifier = Modifier.height(30.dp))
            Row() {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(Modifier.padding(horizontal = 20.dp)) {
                Text(text = "Sort by")
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Free Classes")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Premium Classes")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "All")
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Level")
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Beginner")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Intermidiate")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Advance")
                Spacer(modifier = Modifier.height(30.dp))
                Text(text = "Duration")
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "0-1 Hour")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "1-3 Hour")
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "3+ Hour")
                Spacer(modifier = Modifier.height(61.dp))
                Row(horizontalArrangement = Arrangement.Center) {
                    Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Color.White)) {
                        Text(text = "Reset", color = Error500)
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Primary600)) {
                        Text(text = "Apply", color = Color.White)
                    }
                }
            }
        }

    }
}