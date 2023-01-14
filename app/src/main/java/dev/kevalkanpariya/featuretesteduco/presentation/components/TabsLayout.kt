package dev.kevalkanpariya.featuretesteduco.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import dev.kevalkanpariya.featuretesteduco.presentation.course_page.lessons.LessonsScreen
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey400
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey800
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary600
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun TabsLayout() {
    val pagerState = rememberPagerState()
    Tabs(pagerState = pagerState)
    TabsContent(pagerState = pagerState)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Tabs(pagerState: PagerState) {
    val list = listOf(
        "Overview", "Lessons"
    )
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.White,
        contentColor = Grey800,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions),
                height = 2.dp,
                color = Primary600
            )
        }
    ) {
        list.forEachIndexed{ index, _ ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = list[index],
                        color = if (pagerState.currentPage == index) Grey800 else Grey400
                    )
                },

            )

        }
        
    }
}

@ExperimentalPagerApi
@Composable
fun TabsContent(pagerState: PagerState) {
    // on below line we are creating
    // horizontal pager for our tab layout.
    HorizontalPager(state = pagerState, count = 2) {
        // on below line we are specifying
        // the different pages.
            page ->
        when (page) {
            // on below line we are calling tab content screen
            // and specifying data as Home Screen.
            0 -> TabContentScreen(data = "Welcome to Home Screen")
            // on below line we are calling tab content screen
            // and specifying data as Shopping Screen.
            1 -> LessonsScreen()
            // on below line we are calling tab content screen
            // and specifying data as Settings Screen.

        }
    }
}

@Composable
fun TabContentScreen(data: String) {
    // on below line we are creating a column
    Column(
        // in this column we are specifying modifier
        // and aligning it center of the screen on below lines.
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // in this column we are specifying the text
        Text(
            // on below line we are specifying the text message
            text = data,

            // on below line we are specifying the text style.
            style = MaterialTheme.typography.h5,

            // on below line we are specifying the text color
            color = Color.Green,

            // on below line we are specifying the font weight
            fontWeight = FontWeight.Bold,

            //on below line we are specifying the text alignment.
            textAlign = TextAlign.Center
        )
    }
}