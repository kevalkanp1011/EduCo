package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.search

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import coil.ImageLoader
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Category
import dev.kevalkanpariya.featuretesteduco.core.domain.models.CourseOverview
import dev.kevalkanpariya.featuretesteduco.core.domain.models.FilterResult
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.CategoryCard
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.CourseItem
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.SearchBar
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home.HomeEvent
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home.HomeViewModel
import dev.kevalkanpariya.featuretesteduco.feature_settings.presentation.SettingsEvent
import dev.kevalkanpariya.featuretesteduco.ui.theme.*
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SearchScreen(
    imageLoader: ImageLoader,
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {

    val categories = viewModel.categoryPagingState.value.items

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        SearchBar(
            text = viewModel.searchQuery.value.text,
            onSearch = {
                viewModel.onEvent(HomeEvent.EnteredSearchQuery(it))
                onNavigate(Screen.SearchResultScreen.route)
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Top searches", color = Grey600)
        Spacer(modifier = Modifier.height(28.dp))
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            mainAxisAlignment = MainAxisAlignment.Start,
            mainAxisSize = SizeMode.Expand,
            crossAxisSpacing = 10.dp,
            mainAxisSpacing = 10.dp
        ) {
            categories?.forEach { category ->
                Text(
                    text = category.categoryName,
                    modifier = Modifier
                        .background(
                            color = Color(0xFFEDEEF0),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(10.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color(0xFF282F3E),
                    fontSize = 16.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Categories", color = Grey600)
        Spacer(modifier = Modifier.height(28.dp))
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(categories) { category ->
                CategoryCard(category = category, imageLoader = imageLoader)
            }

        }
    }


}

@Composable
fun FilterScreen(
    onNavigate: (String) -> Unit,
    onNavigateUp: () -> Unit
) {
    val freeClassesCheckedState = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "Sort by",
                fontWeight = FontWeight.Bold
            )

            Row(
                modifier = Modifier.padding(0.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(
                    text = "Free Classes"
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Premium Classes")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "All")
            }
            Text(text = "Level")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Beginner")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Intermidiate")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "Advance")
            }
            Text(text = "Duration")
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "0-1 Hour")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "1-3 Hour")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = freeClassesCheckedState.value,
                    onCheckedChange = { freeClassesCheckedState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Primary500,
                        uncheckedColor = Grey200
                    )
                )
                Text(text = "3+ Hour")
            }
            Spacer(modifier = Modifier.height(61.dp))

        }

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(text = "Reset", color = Error500)
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(backgroundColor = Primary600),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(text = "Apply", color = Color.White)
            }
        }

    }

}


@Composable
fun SearchResultScreen(
    imageLoader: ImageLoader,
    onNavigate: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val courses = viewModel.searchCoursesPagingState.value.items
    Column(
        Modifier
            .background(Color.White)
            .padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
        Spacer(modifier = Modifier.height(22.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Your search result", fontSize = 15.sp)
            Icon(
                painter = painterResource(id = R.drawable.ic_filtersearch),
                contentDescription = "filter_icon",
                modifier = Modifier.clickable {
                    onNavigate(Screen.FilterScreen.route)
                }
            )
        }
        Spacer(modifier = Modifier.height(37.dp))
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            items(courses) {
                CourseItem(course = it, imageLoader = imageLoader, onNavigate = onNavigate)
            }
        }
        if(viewModel.searchCoursesPagingState.value.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
        }
    }

}
