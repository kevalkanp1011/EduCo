package dev.kevalkanpariya.educo.presentation.screens.saved

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.educo.presentation.screens.search.SearchReItempw
import dev.kevalkanpariya.educo.ui.theme.Grey50

@Preview
@Composable
fun MySaveList() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text("My Save List", fontSize = 22.sp)
        Spacer(modifier = Modifier.height(50.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            item {
                SearchReItempw()
            }
            item {
                SearchReItempw()
            }
            item {
                SearchReItempw()
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Grey50)) {
            Text(text = "Add More", color = Color.Black, fontSize = 14.sp)
        }
    }


}