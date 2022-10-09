package dev.kevalkanpariya.educo.presentation.screens.saved

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.Grey50

@Preview(showBackground = true)
@Composable
fun SavedEmptyScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.height(104.dp))
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.5f),
            painter = painterResource(id = R.drawable.saved_empty_screen_img),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Nothing is here!",
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "We found nothing in your save list! Want to have some? Try something best",
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Grey50)) {
            Text("Recommended")
        }
    }
}