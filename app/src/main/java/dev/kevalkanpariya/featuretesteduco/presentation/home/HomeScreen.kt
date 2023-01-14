package dev.kevalkanpariya.featuretesteduco.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.featuretesteduco.presentation.components.Header
import dev.kevalkanpariya.featuretesteduco.presentation.components.SearchBar

@Preview
@Composable
fun HomeScreen() {
    Column(
        Modifier
            .background(Color.White)
            .padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
        /*if (user != null) {
            Header(user.name, user.avatar)
        }*/
        Spacer(modifier = Modifier.height(30.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(30.dp))
        /*LazyColumn(verticalArrangement = Arrangement.spacedBy(35.dp)){
            item {
                PopularCategory3()
            }
            item {
                FreeTrial()
            }
        }*/
    }
}