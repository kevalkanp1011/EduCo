package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import com.google.accompanist.pager.*
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Comment
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseResource
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Lesson
import dev.kevalkanpariya.featuretesteduco.core.domain.states.StandardTextFieldState
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_detail.CourseOverviewState
import dev.kevalkanpariya.featuretesteduco.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterialApi::class)
@Composable
fun TabsLayout(
    courseOverviewState: CourseOverviewState,
    comments: List<Comment>,
    lessons: List<Lesson>,
    resources: List<CourseResource>,
    imageLoader: ImageLoader,
    onLikeClick: (commentId: String) -> Unit = {},
    onLikedByClick: (commentId: String) -> Unit = {},
    commentState: StandardTextFieldState,
    onCommentValueChange: (String) -> Unit = {},
    onSendClick: () -> Unit = {},
    scaffoldState: BottomSheetScaffoldState
) {
    val pagerState = rememberPagerState()
    Tabs(pagerState = pagerState)
    TabsContent(
        pagerState = pagerState,
        comments = comments,
        lessons = lessons,
        resources =resources,
        imageLoader = imageLoader,
        onLikeClick = onLikeClick,
        onLikedByClick =onLikedByClick,
        commentState = commentState,
        onCommentValueChange = onCommentValueChange,
        onSendClick =onSendClick,
        courseOverviewState = courseOverviewState,
        scaffoldState = scaffoldState
    )
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

@OptIn(ExperimentalMaterialApi::class)
@ExperimentalPagerApi
@Composable
fun TabsContent(
    courseOverviewState: CourseOverviewState,
    pagerState: PagerState,
    comments: List<Comment>,
    lessons: List<Lesson>,
    resources: List<CourseResource>,
    imageLoader: ImageLoader,
    onLikeClick: (commentId: String) -> Unit = {},
    onLikedByClick: (commentId: String) -> Unit = {},
    commentState: StandardTextFieldState,
    onCommentValueChange: (String) -> Unit = {},
    onSendClick: () -> Unit = {},
    scaffoldState: BottomSheetScaffoldState
) {
    HorizontalPager(state = pagerState, count = 2) {page ->
        when (page) {
            0 -> CourseOverViewScreen(
                courseOverviewState = courseOverviewState,
                imageLoader = imageLoader,
                comments = comments,
                onLikeClick = onLikeClick,
                onLikedByClick = onLikedByClick,
                commentState = commentState,
                onCommentValueChange = onCommentValueChange,
                onSendClick = onSendClick,
                scaffoldState = scaffoldState
            )
            1 -> LessonsScreen(
                lessons = lessons,
                resources = resources,
                imageLoader = imageLoader
            )

        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CourseOverViewScreen(
    courseOverviewState: CourseOverviewState,
    imageLoader: ImageLoader,
    comments: List<Comment>,
    onLikeClick: (commentId: String) -> Unit = {},
    onLikedByClick: (commentId: String) -> Unit = {},
    commentState: StandardTextFieldState,
    onCommentValueChange: (String) -> Unit = {},
    onSendClick: () -> Unit = {},
    scaffoldState: BottomSheetScaffoldState
) {

    val scope = rememberCoroutineScope()


    //val oll = if (sheetState.isCollapsed) Color.White else Color.Black.copy(alpha = 0.5f)


    BottomSheetScaffold(
        backgroundColor = Color.White,
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                ,
                contentAlignment = Alignment.TopStart
            ) {
                SendTextField(
                    state = commentState,
                    onValueChange = onCommentValueChange,
                    onSend = onSendClick
                )

            }
        },
        sheetPeekHeight = 0.dp
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            item {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Description",
                        fontSize = 16.sp,
                        color = Grey800,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = courseOverviewState.description?: "Not Found Description",
                        color = Grey600,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.height(40.dp))
                }

            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "${courseOverviewState.commentCount} Comments",
                        color = Grey800,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    TextButton(
                        onClick = {
                            scope.launch {
                                if(scaffoldState.bottomSheetState.isCollapsed) {
                                    scaffoldState.bottomSheetState.expand()
                                }
                                else if(scaffoldState.bottomSheetState.isExpanded) {
                                    scaffoldState.bottomSheetState.collapse()
                                }


                            }
                                  },
                        colors = buttonColors(backgroundColor = Grey50)
                    ) {
                        Text(
                            text = "Add Comment",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))

            }
            items(comments) { comment ->
                Comment(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = SpaceLarge,
                            vertical = SpaceSmall
                        ),
                    imageLoader = imageLoader,
                    comment = comment,
                    onLikeClick = { onLikeClick(comment.id) },
                )
                Spacer(modifier = Modifier.height(30.dp))
            }

        }

        
    }



}

@Composable
fun LessonsScreen(
    lessons: List<Lesson>,
    resources: List<CourseResource>,
    imageLoader: ImageLoader
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item {
            Spacer(modifier = Modifier.height(30.dp))
        }
        items(lessons) {
            Lesson(lesson = it, imageLoader = imageLoader)
            Spacer(modifier = Modifier.height(30.dp))
        }

        item {
            Spacer(modifier = Modifier.height(10.dp))
            Column(Modifier.fillMaxWidth()) {
                Text(
                    text = "Resources for Download",
                    fontWeight = FontWeight.Bold,
                    color = Grey900,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(35.dp))

            }
        }

        items(resources) {
            ResourcesForDownload(resource = it)
            Spacer(modifier = Modifier.height(30.dp))
        }

    }

}
