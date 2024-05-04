package dev.kevalkanpariya.educo.presentation.screens.on_bording

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import dev.kevalkanpariya.educo.core.navigation.Routes
import dev.kevalkanpariya.educo.ui.theme.Primary600
import dev.kevalkanpariya.educo.utils.OnBoardingPage


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun OnBoardingScreen(
    onNavigate: (String) -> Unit = {},
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )
    val pagerState = rememberPagerState {
        pages.size
    }

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
            modifier = Modifier
                .fillMaxSize(),
            constraintSet = constraints
        ) {

            TextButton(
                modifier = Modifier.layoutId(SkipButtonRef),
                onClick = { onNavigate(Routes.SignInScreen.route) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 0.dp)
            ) {
                Text(text = "Skip", color = Primary600)
            }
            HorizontalPager(
                state = pagerState,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .height(450.dp)
                    .padding(top = 0.dp, bottom = 0.dp)
                    .layoutId(PagerRef)
            ) { position ->
                PagerScreen(onBoardingPage = pages[position])
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .layoutId(PagerIndicatorRef),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(2.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(8.dp)
                    )
                }
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(60.dp)
                    .layoutId(RegisterBtnRef),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary600,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(6.dp),
                onClick = { onNavigate(Routes.SignUpScreen.route) }
            ) {
                Text(text = "Register")
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(60.dp)
                    .layoutId(LoginBtnRef),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Primary600
                ),
                shape = RoundedCornerShape(6.dp),
                border = BorderStroke(width = 1.dp, color = Primary600),
                onClick = { onNavigate(Routes.SignInScreen.route) }
            ) {
                Text(text = "Login")
            }

        }
    }


}

private fun decoupledConstraints(
    margin: Dp
): ConstraintSet {
    return ConstraintSet {

        val skipBtn = createRefFor(SkipButtonRef)
        val pagerRef = createRefFor(PagerRef)
        val pagerIndicator = createRefFor(PagerIndicatorRef)
        val registerBtn = createRefFor(RegisterBtnRef)
        val loginBtn = createRefFor(LoginBtnRef)

        constrain(skipBtn) {
            top.linkTo(parent.top, 0.dp)
            end.linkTo(parent.end, 20.dp)
        }

        constrain(pagerRef) {
            top.linkTo(skipBtn.bottom, 2.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

        constrain(pagerIndicator) {
            top.linkTo(pagerRef.bottom, 5.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(registerBtn) {
            top.linkTo(pagerIndicator.bottom, 30.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

        constrain(loginBtn) {
            top.linkTo(registerBtn.bottom, 10.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

    }
}


private const val SkipButtonRef = "skip_btn"
private const val PagerRef = "pager_ref"
private const val PagerIndicatorRef = "pager_indicator_ref"
private const val RegisterBtnRef = "register_btn"
private const val LoginBtnRef = "login_btn"