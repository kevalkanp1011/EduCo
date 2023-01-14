package dev.kevalkanpariya.featuretesteduco.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey400
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey800

@Preview
@Composable
fun ResourcesForDownload() {
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        Text(text = "Resources for download", color = Grey800)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                Img()
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text(text = "practice class sketches", color = Grey800, fontWeight = FontWeight.Bold)
                    Text(text = ".img      4Mb", color = Grey400)
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_download),
                    contentDescription = null,
                    tint = Grey400
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .background(Color.White),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row() {
                PDF()
                Spacer(modifier = Modifier.width(10.dp))
                Column() {
                    Text(text = "Home work sheets", color = Grey800, fontWeight = FontWeight.Bold)
                    Text(text = ".pdf      4Mb", color = Grey400)
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_download),
                    contentDescription = null,
                    tint = Grey400
                )
            }
        }
    }

}

@Composable
fun Img() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color = Color(0XFFFF6363))
            .padding(horizontal = 8.dp, vertical = 12.dp)

    ) {
        Text(text = ".img", color = Color.White)
    }
}

@Composable
fun PDF() {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(color = Color(0XFFA0D7FF))
            .padding(horizontal = 8.dp, vertical = 12.dp)
    ) {
        Text(text = ".pdf")
    }
}
