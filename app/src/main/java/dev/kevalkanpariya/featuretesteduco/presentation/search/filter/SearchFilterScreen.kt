package dev.kevalkanpariya.featuretesteduco.presentation.search.filter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.Error500
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey200
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary500
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary600


@Preview
@Composable
fun SearchFilterScreen() {
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Sort by")
            val freeClassesCheckedState = remember { mutableStateOf(false) }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Free Classes")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Premium Classes")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "All")
            }
            Text(text = "Level")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Beginner")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Intermidiate")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Advance")
            }
            Text(text = "Duration")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "0-1 Hour")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "1-3 Hour")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "3+ Hour")
            }
            Spacer(modifier = Modifier.height(61.dp))

        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = buttonColors(backgroundColor = Color.White),
                elevation = elevation(defaultElevation = 0.dp)
            ) {
                Text(text = "Reset", color = Error500)
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = buttonColors(backgroundColor = Primary600),
                elevation = elevation(defaultElevation = 0.dp)
            ) {
                Text(text = "Apply", color = Color.White)
            }
        }
    }

}