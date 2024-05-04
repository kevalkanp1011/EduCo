package dev.kevalkanpariya.educo.feature_course.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.educo.feature_course.domain.models.keval
import dev.kevalkanpariya.educo.ui.theme.Grey500
import dev.kevalkanpariya.educo.ui.theme.Grey900


// Photo and name from  Student database
@Composable
fun Header(name: String?, resId: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column() {
            Text(text = "Hola, $name!", fontSize = 20.sp, color = Grey900)
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "What do you wanna learn today?",fontSize = 14.sp, color = Grey500)
        }
        Image(
            painter = painterResource(id = resId),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
    }
}
@Preview
@Composable
fun HeaderPW() {
    Header(keval.name, keval.avatar)
}