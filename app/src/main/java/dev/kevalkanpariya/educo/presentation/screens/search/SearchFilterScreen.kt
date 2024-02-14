package dev.kevalkanpariya.educo.presentation.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.ButtonDefaults.elevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import dev.kevalkanpariya.educo.ui.theme.Error500
import dev.kevalkanpariya.educo.ui.theme.Grey200
import dev.kevalkanpariya.educo.ui.theme.Primary500
import dev.kevalkanpariya.educo.ui.theme.Primary600

@Preview
@Composable
fun SearchFilterScreen(

) {

    val scrollState = rememberScrollState()

    val freeClassesCheckedState = remember { mutableStateOf(false) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 20.dp)
                .verticalScroll(scrollState)
            ,
            constraintSet = constraints
        ) {

            Column(
                modifier = Modifier
                    .layoutId(filterColumnRef)
            ) {
                Text(text = "Sort by")

                Row(
                    modifier = Modifier
                        .layoutId(FreeClassesFilterRef),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "Free Classes")
                }
                Row(
                    modifier = Modifier
                        .layoutId(PremiumClassesFilterRef),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "Premium Classes")
                }
                Row(
                    modifier = Modifier
                    .layoutId(AllClassesFilterRef),
                    verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "All")
                }
                Text(text = "Level")
                Row(
                    modifier = Modifier
                        .layoutId(BeginnerLevelFilterRef),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "Beginner")
                }
                Row(
                    modifier = Modifier
                        .layoutId(IntermediateLevelFilterRef),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "Intermidiate")
                }
                Row(
                    modifier = Modifier
                        .layoutId(AdvanceLevelFilterRef),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "Advance")
                }
                Text(text = "Duration")
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "0-1 Hour")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "1-3 Hour")
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = freeClassesCheckedState.value,
                        onCheckedChange = { freeClassesCheckedState.value = it },
                        colors = CheckboxDefaults.colors(checkedColor = Primary500, uncheckedColor = Grey200)
                    )
                    Text(text = "3+ Hour")
                }
                Spacer(modifier = Modifier.height(61.dp))

            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .layoutId(btnRowRef),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier.layoutId(resetBtnRef),
                    onClick = { /*TODO*/ },
                    colors = buttonColors(backgroundColor = Color.White),
                    elevation = elevation(defaultElevation = 0.dp)
                ) {
                    Text(text = "Reset", color = Error500)
                }
                //Spacer(modifier = Modifier.width(30.dp))
                Button(
                    modifier = Modifier.layoutId(applyBtnRef),
                    onClick = { /*TODO*/ },
                    colors = buttonColors(backgroundColor = Primary600),
                    elevation = elevation(defaultElevation = 0.dp)
                ) {
                    Text(text = "Apply", color = Color.White)
                }
            }

        }
    }

//    Column(modifier = Modifier
//        .background(color = Color.White)
//        .fillMaxSize()
//    ) {
//        Spacer(modifier = Modifier.height(30.dp))
//        IconButton(onClick = { /*TODO*/ }) {
//            Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
//        }
//        Spacer(modifier = Modifier.height(20.dp))
//
//
//    }

}


private fun decoupledConstraints(
    margin: Dp
): ConstraintSet {
    return ConstraintSet {

        val btnRow = createRefFor(btnRowRef)
        val filterColumn = createRefFor(filterColumnRef)


        constrain(filterColumn) {
            top.linkTo(parent.top, 20.dp)
            start.linkTo(parent.start)
            //end.linkTo(parent.end,  20.dp)
        }

        constrain(btnRow) {

            bottom.linkTo(parent.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        }
    }
}

private const val searchBarRef = "searchbar"
private const val resetBtnRef = "resetBtn"
private const val applyBtnRef = "applyBtn"
private const val btnRowRef = "btnRow"
private const val filterColumnRef = "filter_clm"

private const val FreeClassesFilterRef = "free_classes_check_bx"
private const val PremiumClassesFilterRef = "premium_classes_filter"
private const val AllClassesFilterRef = "all_classes_filter"

private const val BeginnerLevelFilterRef = "beginner_filter"
private const val IntermediateLevelFilterRef = "premium_classes_filter"
private const val AdvanceLevelFilterRef = "premium_classes_filter"
