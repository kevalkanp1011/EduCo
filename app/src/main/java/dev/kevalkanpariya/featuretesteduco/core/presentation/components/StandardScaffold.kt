package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import dev.kevalkanpariya.featuretesteduco.core.domain.models.BottomNavBar

@Composable
fun StandardScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    showBottomBar: Boolean = true,
    state: ScaffoldState,

    content: @Composable () -> Unit
) {
    Scaffold(
        bottomBar = {
            if (showBottomBar) {

                val items = BottomNavBar.Items.list

                Row(
                    modifier = Modifier
                        .background(MaterialTheme.colors.background)
                        .padding(vertical = 8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items.forEach{ item ->
                        CustomBottomNavigationItem(
                            item = item,
                            isSelected = navController.currentDestination?.route?.startsWith(item.route) == true
                        ) {
                            if (navController.currentDestination?.route != item.route) {
                                navController.navigate(item.route)
                            }
                        }
                    }
                }
            }
        },
        scaffoldState = state,
        modifier = modifier
    ) {
        content()
    }
}