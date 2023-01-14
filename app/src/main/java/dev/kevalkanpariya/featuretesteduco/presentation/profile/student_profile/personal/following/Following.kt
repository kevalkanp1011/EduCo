package dev.kevalkanpariya.featuretesteduco.presentation.profile.student_profile.personal.following

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import dev.kevalkanpariya.featuretesteduco.R

@Preview
@Composable
fun Following() {
    Row() {
        Image(
            painter = painterResource(id = R.drawable.inst1),
            contentDescription = null
        )
        Column() {
            Text(text = "Sammuel Jonass")
            Text(text = "@jdoe")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Follow")
        }
    }
}
