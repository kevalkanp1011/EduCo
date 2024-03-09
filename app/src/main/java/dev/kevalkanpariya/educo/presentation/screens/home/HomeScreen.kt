package dev.kevalkanpariya.educo.presentation.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import dev.kevalkanpariya.educo.domain.model.keval
import dev.kevalkanpariya.educo.navigation.Screen
import dev.kevalkanpariya.educo.presentation.components.BottomNavigationBar
import dev.kevalkanpariya.educo.presentation.components.FreeTrial
import dev.kevalkanpariya.educo.presentation.components.Header
import dev.kevalkanpariya.educo.presentation.components.PopularCategory3
import dev.kevalkanpariya.educo.presentation.components.ScaffoldWithBottomBar
import dev.kevalkanpariya.educo.presentation.components.SearchBar
import dev.kevalkanpariya.educo.presentation.viewmodel.SharedViewModel


@Composable
fun HomeScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    val user = sharedViewModel.user

    LaunchedEffect(key1 = user) {
        if (user != null) {
            Log.d("HomeScreen", user.name)
            Log.d("HomeScreen", user.username)
            Log.d("HomeScreen", user.bio)
        }
    }

    ScaffoldWithBottomBar(
        bottomBar = {
            BottomNavigationBar(
                route = Screen.Home.route,
                onItemSelected = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Column(
            Modifier
                .background(Color.White)
                .padding(top = 30.dp, start = 20.dp, end = 20.dp)
        ) {
            if (user != null) {
                Header(user.name, user.avatar)
            }
            Spacer(modifier = Modifier.height(30.dp))
            SearchBar()
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(35.dp)
            ){
                item {
                    PopularCategory3()
                }
                item {
                    FreeTrial()
                }
            }
        }
    }

}


private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val searchBar = createRefFor("search_bar")
        val header = createRefFor("header")
        val avatar = createRefFor("avatar")
        val freeTrial = createRefFor("freeTrial")





    }
}