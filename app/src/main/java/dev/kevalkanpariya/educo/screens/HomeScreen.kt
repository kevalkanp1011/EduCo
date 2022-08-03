package dev.kevalkanpariya.educo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.educo.components.FreeTrial
import dev.kevalkanpariya.educo.components.Header
import dev.kevalkanpariya.educo.components.PopularCategory3
import dev.kevalkanpariya.educo.components.SearchBar
import dev.kevalkanpariya.educo.domain.model.keval

@Composable
fun HomeScreen() {
    Column(
        Modifier
            .background(Color.White)
            .padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
        Header(keval.name, keval.avatar)
        Spacer(modifier = Modifier.height(30.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn(verticalArrangement = Arrangement.spacedBy(35.dp)){
            item {
                PopularCategory3()
            }
            item {
                FreeTrial()
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPw() {
    HomeScreen()
}