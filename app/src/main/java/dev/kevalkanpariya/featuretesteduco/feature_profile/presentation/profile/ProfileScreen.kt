package dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.google.accompanist.pager.*
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.models.*
import dev.kevalkanpariya.featuretesteduco.core.domain.states.StandardTextFieldState
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.*
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.asString
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_detail.CourseOverviewState
import dev.kevalkanpariya.featuretesteduco.feature_profile.domain.model.Profile
import dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.following_list.FollowingItem
import dev.kevalkanpariya.featuretesteduco.ui.theme.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@Composable
fun ProfileScreen(
    scaffoldState: ScaffoldState,
    userId: String? = null,
    onNavigate: (String) -> Unit = {},
    imageLoader: ImageLoader,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val userProfile = viewModel.userProfile.collectAsState().value

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.getProfile(userId)
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
            }
        }

    }

    BoxWithConstraints {
        val constraints = decoupledConstraints()
        ConstraintLayout(constraints) {
            userProfile?.let {
                Banner(userProfile.profile?.bannerUrl?: "")
                SettingsButton(onNavigate)
                Avatar(userProfile.profile?.profilePictureUrl?: "", imageLoader)
                userProfile.profile?.let { profile ->
                    ProfileContent(
                        userProfile = profile,
                        courses = userProfile.courses,
                        userItems = userProfile.userItems,
                        imageLoader = imageLoader,
                        onNavigate = onNavigate,
                        onFollowingClick = {
                            viewModel.onEvent(ProfileEvent.ToggleFollowStateForUser(it))
                        }
                    )
                }
            }

        }
    }

}

@Composable
private fun ProfileContent(
    userProfile: Profile,
    imageLoader: ImageLoader,
    courses: List<CourseOverview>,
    userItems: List<UserItem>,
    onNavigate: (String) -> Unit,
    onFollowingClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.layoutId("content"),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text("@${userProfile.username}")
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = userProfile.bio,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(15.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "Instagram",
                    modifier = Modifier.clickable {

                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier.clickable {

                    }
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_twitter),
                    contentDescription = "Twitter",

                )

            }
        }

        Spacer(Modifier.height(32.dp))
        val titles = listOf("${userProfile.enrolledCourseCount}\nCourses", "${userProfile.followingCount}\nFollowing")
        ProfileTabsLayout(
            imageLoader = imageLoader,
            courses = courses,
            userItems = userItems,
            titles = titles,
            onNavigate = onNavigate,
            onFollowingClick = onFollowingClick
        )

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProfileTabsLayout(
    imageLoader: ImageLoader,
    courses: List<CourseOverview>,
    userItems: List<UserItem>,
    onFollowingClick: (String) -> Unit,
    onNavigate: (String) -> Unit,
    titles: List<String>
) {

    val pagerState = rememberPagerState()
    ProfileTabs(pagerState = pagerState, titles = titles)
    ProfileTabsContent(
        pagerState = pagerState,
        imageLoader = imageLoader,
        courses = courses,
        userItems = userItems,
        onFollowingClick = onFollowingClick,
        onNavigate = onNavigate
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProfileTabs(pagerState: PagerState, titles: List<String>) {
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
        titles.forEachIndexed{ index, _ ->
            Tab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(
                        text = titles[index],
                        color = if (pagerState.currentPage == index) Grey800 else Grey400
                    )
                },

                )

        }

    }

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ProfileTabsContent(
    pagerState: PagerState,
    imageLoader: ImageLoader,
    courses: List<CourseOverview>,
    userItems: List<UserItem>,
    onFollowingClick: (String) -> Unit,
    onNavigate: (String) -> Unit,
) {

    HorizontalPager(state = pagerState, count = 2) {
            page ->
        when (page) {
            0 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            horizontal = 20.dp
                        )) {
                    Spacer(modifier = Modifier.height(30.dp))
                    courses.forEach { course ->
                        CourseItem(
                            course = course,
                            imageLoader = imageLoader,
                            onNavigate = onNavigate
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }

                
            }
            1 -> {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp)) {
                    Spacer(modifier = Modifier.height(30.dp))
                    userItems.forEach {
                        FollowingItem(
                            userItem = it,
                            isFollowing = it.isFollowing,
                            onFollowingClick = onFollowingClick,
                            onNavigate = onNavigate,
                            imageLoader = imageLoader
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }

            }

        }
    }
}






@Composable
private fun Avatar(
    profileImageUrl: String,
    imageLoader: ImageLoader
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = profileImageUrl)
            .crossfade(durationMillis = 1000)
            .placeholder(drawableResId = R.drawable.ic_placeholder)
            .transformations(CircleCropTransformation())
            .build(),
        modifier = Modifier
            .size(80.dp)
            .layoutId("avatar"),
        contentDescription = "Profile Photo",
        contentScale = ContentScale.Crop
    )
}



@Composable
private fun Banner(bannerUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(
            model = bannerUrl,

        ),
        contentDescription = null,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .layoutId("banner"),
        contentScale = ContentScale.Crop
    )
}
@Composable
private fun SettingsButton(onNavigate: (String) -> Unit = {}) {
    Icon(
        painter = painterResource(id = R.drawable.ic_settings),
        modifier = Modifier
            .layoutId("ic_settings")
            .clickable {
                onNavigate(
                    Screen.SettingsScreen.route
                )
            },
        contentDescription = "setting",
        tint = Color.Black
    )
}


private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val banner = createRefFor("banner")
        val settings = createRefFor("ic_settings")
        val avatar = createRefFor("avatar")
        val content = createRefFor("content")

        constrain(banner) {
            top.linkTo(parent.top)
            absoluteRight.linkTo(parent.absoluteRight)
            absoluteLeft.linkTo(parent.absoluteLeft)
            height = Dimension.value(120.dp)
        }
        constrain(settings) {
            top.linkTo(banner.top)
            bottom.linkTo(banner.bottom)
            absoluteRight.linkTo(parent.absoluteRight, margin = 20.dp)
        }
        constrain(avatar) {
            top.linkTo(banner.bottom)
            bottom.linkTo(banner.bottom)
            absoluteLeft.linkTo(parent.absoluteLeft)
            absoluteRight.linkTo(parent.absoluteRight)
        }
        constrain(content) {
            top.linkTo(avatar.bottom)
            absoluteLeft.linkTo(parent.absoluteLeft)
            absoluteRight.linkTo(parent.absoluteRight)
        }

    }
}