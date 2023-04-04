package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.*
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.asString
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.ui.theme.SpaceLarge
import kotlinx.coroutines.flow.collectLatest

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    imageLoader: ImageLoader,
    scaffoldState: ScaffoldState,
    onNavigate: (String) -> Unit = {},
    viewModel: HomeViewModel = hiltViewModel()
) {
    val categoryPagingState = viewModel.categoryPagingState.value
    val mostWatchedCoursePagingState = viewModel.mostWatchedCoursePagingState.value

    val profileHeaderState = viewModel.profileHeaderState.value

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
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

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        item {
            profileHeaderState.profileHeader?.let {profileHeader ->
                UserHeader(name = profileHeader.name, profilePictureUrl = profileHeader.profilePictureUrl)
            }
            Spacer(modifier = Modifier.height(30.dp))
        }

        item {
            Column(modifier = Modifier.fillMaxSize()) {
                PopularCategory(onNavigate)
                Spacer(modifier = Modifier.height(30.dp))
                LazyRow {
                    items(categoryPagingState.items.size) { i ->
                        val category = categoryPagingState.items[i]
                        if (i >= categoryPagingState.items.size - 1 && !categoryPagingState.endReached && !categoryPagingState.isLoading) {
                            viewModel.loadNextCategories()
                        }

                        CategoryCard(
                            category = category,
                            imageLoader = imageLoader,
                            onNavigate = {
                                onNavigate(Screen.CategoryDetailScreen.route + "/${category.categoryId}")
                            })

                        if (i < categoryPagingState.items.size - 1) {
                            Spacer(modifier = Modifier.width(SpaceLarge))
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(90.dp))
                    }
                }
                Spacer(modifier = Modifier.height(20.dp))

                MostWatchedCourses(onNavigate)
                Spacer(modifier = Modifier.height(30.dp))
                LazyRow {
                    items(mostWatchedCoursePagingState.items.size) { i ->
                        val course = mostWatchedCoursePagingState.items[i]
                        if (i >= mostWatchedCoursePagingState.items.size - 1 && !mostWatchedCoursePagingState.endReached && !mostWatchedCoursePagingState.isLoading) {
                            viewModel.loadNextMostWatchedCourses()
                        }

                        CourseOverviewCard(
                            course = course,
                            imageLoader = imageLoader,
                            onClick = {
                                onNavigate(Screen.CourseDetailScreen.route + "/${course.courseId}")
                            }
                        )

                        if (i < mostWatchedCoursePagingState.items.size - 1) {
                            Spacer(modifier = Modifier.width(SpaceLarge))
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(90.dp))
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
                FreeTrial()

                Spacer(modifier = Modifier.height(40.dp))
                PreviousWatchedCourses(onNavigate)
                Spacer(modifier = Modifier.height(30.dp))
                LazyRow {
                    items(mostWatchedCoursePagingState.items.size) { i ->
                        val course = mostWatchedCoursePagingState.items[i]
                        if (i >= mostWatchedCoursePagingState.items.size - 1 && !mostWatchedCoursePagingState.endReached && !mostWatchedCoursePagingState.isLoading) {
                            viewModel.loadNextMostWatchedCourses()
                        }

                        CourseOverviewCard(
                            course = course,
                            imageLoader = imageLoader,
                            onClick = {
                                onNavigate(Screen.CourseDetailScreen.route + "/${course.courseId}")
                            }
                        )

                        if (i < mostWatchedCoursePagingState.items.size - 1) {
                            Spacer(modifier = Modifier.width(SpaceLarge))
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(90.dp))
                    }
                }

                Spacer(modifier = Modifier.height(40.dp))
                OthersWatchedCourses(onNavigate)
                Spacer(modifier = Modifier.height(30.dp))
                LazyRow {
                    items(mostWatchedCoursePagingState.items.size) { i ->
                        val course = mostWatchedCoursePagingState.items[i]
                        if (i >= mostWatchedCoursePagingState.items.size - 1 && !mostWatchedCoursePagingState.endReached && !mostWatchedCoursePagingState.isLoading) {
                            viewModel.loadNextMostWatchedCourses()
                        }

                        CourseOverviewCard(
                            course = course,
                            imageLoader = imageLoader,
                            onClick = {
                                onNavigate(Screen.CourseDetailScreen.route + "/${course.courseId}")
                            }
                        )

                        if (i < mostWatchedCoursePagingState.items.size - 1) {
                            Spacer(modifier = Modifier.width(SpaceLarge))
                        }
                    }
                    item {
                        Spacer(modifier = Modifier.width(90.dp))
                    }
                }
                
                Spacer(modifier = Modifier.height(80.dp))


                if (categoryPagingState.isLoading || mostWatchedCoursePagingState.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(CenterHorizontally)
                    )
                }
            }


        }

    }
}
