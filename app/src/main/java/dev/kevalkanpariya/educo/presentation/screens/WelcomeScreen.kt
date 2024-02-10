package dev.kevalkanpariya.educo.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.pager.*
import dev.kevalkanpariya.educo.domain.model.keval
import dev.kevalkanpariya.educo.presentation.viewmodel.SharedViewModel
import dev.kevalkanpariya.educo.presentation.viewmodel.WelcomeViewModel
import dev.kevalkanpariya.educo.ui.theme.*
import dev.kevalkanpariya.educo.utils.OnBoardingPage

@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = { /*TODO*/ },
                colors = buttonColors(
                    backgroundColor = MaterialTheme.colors.background),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(text = "Skip", color = Primary600)
            }
        }
        HorizontalPager(
            count = pages.size,
            state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier.weight(10f)
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .weight(1f),
            pagerState = pagerState,

        )
        NavigationButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState,
            text = "Register"
            ) {
            sharedViewModel.addUser(keval)
            welcomeViewModel.saveOnBoardingState(completed = true)
            navController.popBackStack()

            //navController.navigate(route = Screen.Home.route)
        }

    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top

    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = "Pager Image"
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            color = Grey900,
            style = text_normal,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .padding(top = 20.dp),
            text = onBoardingPage.description,
            color = Grey300,
            style = headline_normal,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun NavigationButton(
    modifier: Modifier,
    pagerState: PagerState,
    text: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .padding(horizontal = 40.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == 2
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White
                )
            ) {
                Text(text = text)
            }
        }
    }
}
