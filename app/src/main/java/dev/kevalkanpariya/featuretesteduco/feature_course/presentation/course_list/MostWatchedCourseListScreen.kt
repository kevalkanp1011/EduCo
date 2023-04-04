package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.course_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.CourseItem
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.CourseOverviewCard
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home.HomeViewModel
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey900
import dev.kevalkanpariya.featuretesteduco.ui.theme.title2new

@Composable
fun MostWatchedCourseListScreen(
    onNavigateUp: () -> Unit,
    onNavigate: (String) -> Unit,
    imageLoader: ImageLoader,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val courses = viewModel.mostWatchedCoursePagingState.value.items

    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { onNavigateUp() },
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
            }
            Text(text = "All Most Watched Courses", color = Grey900, style = title2new)

        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)

        ) {
            items(courses) {courseOverview ->
                CourseItem(
                    course = courseOverview,
                    imageLoader = imageLoader,
                    onNavigate = onNavigate
                )
            }

        }
    }
    

}