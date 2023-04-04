package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey50

@Preview
@Composable
fun OurTopPopularTeacherSection() {
    Column(
        Modifier
            .padding(20.dp)) {
        Spacer(modifier = Modifier.height(30.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))
        OurTopPopularTeacher()
    }


}

@Composable
fun OurTopPopularTeacher() {
    Column(Modifier.padding(20.dp)) {
        Text(text = "Top teacher this month")
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_google_logo), contentDescription = null)
            Column() {
                Text(text = "Sammuel Jonass")
                Text("@jdoe")
            }
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Grey50)) {
                Text(text = "Follow", color = Color.Black, fontSize = 14.sp)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_google_logo), contentDescription = null)
            Column() {
                Text(text = "Sammuel Jonass")
                Text("@jdoe")
            }
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Grey50)) {
                Text(text = "Follow", color = Color.Black, fontSize = 14.sp)
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.ic_google_logo), contentDescription = null)
            Column() {
                Text(text = "Sammuel Jonass")
                Text("@jdoe")
            }
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Grey50)) {
                Text(text = "Follow", color = Color.Black, fontSize = 14.sp)
            }
        }
    }
}