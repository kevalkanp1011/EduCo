package dev.kevalkanpariya.educo.presentation.screens

import androidx.annotation.FloatRange
import androidx.annotation.IntRange
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.*
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.*
import kotlinx.coroutines.launch

@Preview
@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 20.dp)

    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
            }
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Settings", color = Grey900, style = title2)
            }

        }

        Spacer(modifier = Modifier.height(20.dp))
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Membership", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Memberships Users", color = Grey700, style = title3_normal)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Grey50)) {
                    Text(text = "upgrade", color = Grey800, style = subheadline_medium)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Account", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Profile settings", color = Grey700, style = title3_normal)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Grey50)) {
                    Text(text = "manage", color = Grey800, style = subheadline_medium)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Notifications", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Personalized Notifications", color = Grey700, style = title3_normal)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Security", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Password Change", color = Grey700, style = title3_normal)
                }
                Button(onClick = { /*TODO*/ }, colors = buttonColors(backgroundColor = Grey50)) {
                    Text(text = "manage", color = Grey800, style = subheadline_medium)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(text = "Help & Support", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "About Us", color = Grey700, style = title3_normal)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Terms & Condition", color = Grey700, style = title3_normal)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Privacy Policy", color = Grey700, style = title3_normal)
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }



                }
            }

        }
    }
}

/*@OptIn(ExperimentalPagerApi::class)
@Composable
fun rememberPagerState(
    @IntRange(from = 0) pageCount: Int,
    @IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(saver = PagerState.Saver) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HorizontalPager(
    state: PagerState,
    modifier: Modifier = Modifier,
    reverseLayout: Boolean = false,
    itemSpacing: Dp = 0.dp,
    dragEnabled: Boolean = true,
    flingBehavior: FlingBehavior = PagerDefaults.defaultPagerFlingConfig(state),
    verticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable PagerScope.(page: Int) -> Unit,
)
*/
/*
@OptIn(ExperimentalPagerApi::class)
@Composable
fun CombinedTab() {
    val tabData = listOf(
        "MUSIC" to Icons.Filled.Home,
        "MARKET" to Icons.Filled.ShoppingCart,
        "FILMS" to Icons.Filled.AccountBox,
        "BOOKS" to Icons.Filled.Settings,
    )
    val pagerState = rememberPagerState(
        pageCount = tabData.size,
        initialOffscreenLimit = 2,
        infiniteLoop = true,
        initialPage = 1,
    )
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()
    Column {
        TabRow(
            selectedTabIndex = tabIndex,
            indicator = { tabPositions ->
                TabRowDefaults.Indicator(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                )
            }
        ) {
            tabData.forEachIndexed { index, pair ->
                Tab(selected = tabIndex == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    Text(text = pair.first)
                }, icon = {
                    Icon(imageVector = pair.second, contentDescription = null)
                })
            }
        }*/

       /* HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = tabData[index].first,
                )
            }
        }*/
