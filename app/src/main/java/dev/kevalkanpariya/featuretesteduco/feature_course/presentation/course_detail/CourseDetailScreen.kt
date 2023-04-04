package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_detail

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Comment
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseResource
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Lesson
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Project
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.*
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.asString
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.showKeyboard
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey400
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey700
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey800
import dev.kevalkanpariya.featuretesteduco.ui.theme.TagBG
import kotlinx.coroutines.flow.collectLatest

@Composable
fun CourseDetailScreen(
    scaffoldState: ScaffoldState,
    imageLoader: ImageLoader,
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    viewModel: CourseDetailViewModel = hiltViewModel(),
    shouldShowKeyboard: Boolean = false
) {

    val state = viewModel.state.collectAsState().value
    val courseOverviewState = viewModel.courseOverviewState.collectAsState().value
    val userState = viewModel.userState.value
    val commentTextFieldState = viewModel.commentTextFieldState.value

    val focusRequester = remember {
        FocusRequester()
    }

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        if (shouldShowKeyboard) {
            context.showKeyboard()
            focusRequester.requestFocus()
        }
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
                else -> {}
            }
        }

    }

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onNavigateUp() }
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
            }
            Text(
                text = "Details",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            IconButton(
                onClick = { viewModel.addCourseToBookmark() }
            ) {
                if (viewModel.isBookmarked.value) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bookmark),
                        contentDescription = "bookmark icon",
                        tint = Color(0XFF0B121F)
                    )
                } else {
                    Icon(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = "bookmark icon")
                }

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
            ) {
                /*Image(
                    painter = painterResource(id = R.drawable.details_img),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )*/
                VideoView(videoUri = state.course?.courseIntroVideoUrl?: "https://www.learningcontainer.com/wp-content/uploads/2020/05/sample-mp4-file.mp4")
                /*Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = null
                    )

                }*/
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            state.course?.tag?.let {
                Text(
                    text = it,
                    color = Color.White,
                    modifier = Modifier
                        .background(TagBG)
                        .padding(horizontal = 15.dp, vertical = 4.dp)
                        .clip(RoundedCornerShape(2.dp))
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = state.course?.courseTeacher?.profileImageUrl,
                        imageLoader = imageLoader
                    ),
                    contentDescription = "profile Picture of Teacher",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(10.dp))
                state.course?.courseTeacher?.name?.let {
                    Text(
                        text = it,
                        fontSize = 16.sp,
                        color = Grey700
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            state.course?.courseTitle?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Grey800
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = "clock",
                            tint = Grey400
                        )
                        Text(
                            text = "1 hour 30 min",
                            color = Grey400,
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star_liniar),
                            contentDescription = "rating",
                            tint = Grey400
                        )
                        Text(
                            text = "${state.course?.avgRating}  (${state.course?.noOfStudentRated})      ",
                            color = Grey400,
                            fontSize = 14.sp
                        )
                    }
                }
                Spacer(modifier = Modifier.width(20.dp))
                Column() {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_video_lesson),
                            contentDescription = "video_lesson",
                            tint = Grey400
                        )
                        Text(
                            text = "${state.course?.noOfLessons}",
                            color = Grey400,
                            fontSize = 14.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "person",
                            tint = Grey400
                        )
                        Text(
                            text = "${state.course?.noOfStudentEnrolled}  students",
                            color = Grey400,
                            fontSize = 14.sp
                        )
                    }
                }


            }
            Spacer(modifier = Modifier.height(10.dp))

            Spacer(modifier = Modifier.height(10.dp))

            TabsLayout(
                courseOverviewState = courseOverviewState,
                comments = state.comments,
                lessons = state.lessons,
                resources = state.resources,
                imageLoader = imageLoader,
                onLikeClick = { commentId ->
                    viewModel.onEvent(CourseDetailEvent.LikeComment(commentId = commentId))
                },
                onLikedByClick = { commentId ->
                    onNavigate(Screen.PersonListScreen.route + "/${commentId}")
                },
                commentState = commentTextFieldState,
                onCommentValueChange = {
                    viewModel.onEvent(CourseDetailEvent.EnteredComment(it))
                },
                onSendClick = {
                    viewModel.onEvent(CourseDetailEvent.Comment)
                },
            )

        }
    }

}

private val tabContainerModifier = Modifier
    .fillMaxWidth()
    .wrapContentWidth(Alignment.CenterHorizontally)