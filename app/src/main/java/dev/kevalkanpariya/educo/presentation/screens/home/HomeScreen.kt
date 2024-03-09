package dev.kevalkanpariya.educo.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.navigation.Screen
import dev.kevalkanpariya.educo.presentation.components.BottomNavigationBar
import dev.kevalkanpariya.educo.presentation.components.CourseCard
import dev.kevalkanpariya.educo.presentation.components.FreeTrial
import dev.kevalkanpariya.educo.presentation.components.PopularCategory
import dev.kevalkanpariya.educo.presentation.components.PopularCategory3
import dev.kevalkanpariya.educo.presentation.components.ScaffoldWithBottomBar
import dev.kevalkanpariya.educo.presentation.components.SearchBar


@Preview
@Composable
fun HomeScreen(
    navController: NavHostController? = null,
//    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val user = null

//    LaunchedEffect(key1 = user) {
//        if (user != null) {
//            Log.d("HomeScreen", user.name)
//            Log.d("HomeScreen", user.username)
//            Log.d("HomeScreen", user.bio)
//        }
//    }



    ScaffoldWithBottomBar(
        bottomBar = {
            BottomNavigationBar(
                route = Screen.Home.route,
                onItemSelected = {
                    navController?.navigate(it.route)
                }
            )
        }
    ) {

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()

        ) {

            val constraints = if (minWidth < 600.dp) {
                decoupledConstraints(margin = 16.dp) // Portrait constraints
            } else {
                decoupledConstraints(margin = 32.dp) // Landscape constraints
            }

            ConstraintLayout(
                modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
                constraintSet = constraints
            ) {

                SearchBar(
                    modifier = Modifier
                        .layoutId(SearchBarRef)
                )

                PopularCategory(modifier = Modifier.layoutId(PopularCatTitleRef))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .layoutId(PopularCat3Ref),
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    item {
                        CourseCard(
                            title = "Interior Design",
                            imagePainter = painterResource(id = R.drawable.interiordesign)
                        )
                    }
                    item {
                        CourseCard(
                            title = "Traditional Art",
                            imagePainter = painterResource(id = R.drawable.traditional_art)
                        )
                    }

                }

                FreeTrial(
                    modifier = Modifier.layoutId(FreeTrialRef)
                )


            }

        }

    }

}


private fun decoupledConstraints(margin: Dp): ConstraintSet {
    return ConstraintSet {
        val searchBar = createRefFor(SearchBarRef)
        val header = createRefFor(HeaderRef)
        val avatar = createRefFor("avatar")
        val freeTrial = createRefFor(FreeTrialRef)
        val popCatTitle = createRefFor(PopularCatTitleRef)
        val popCatRef = createRefFor(PopularCat3Ref)

        constrain(searchBar) {
            top.linkTo(parent.top, 30.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(popCatTitle) {
            top.linkTo(searchBar.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(popCatRef) {
            top.linkTo(popCatTitle.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        }

        constrain(freeTrial) {
            top.linkTo(popCatRef.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        }




    }
}

private const val SearchBarRef = "search_bar"
private const val HeaderRef = "header"
private const val PopularCatTitleRef = "popular_cat_title"
private const val PopularCat3Ref = "PopCat3Ref"
private const val FreeTrialRef = "free_trial"