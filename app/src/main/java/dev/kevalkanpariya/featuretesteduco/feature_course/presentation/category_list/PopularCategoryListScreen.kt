package dev.kevalkanpariya.featuretesteduco.feature_course.presentation.category_list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
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
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.CategoryCard
import dev.kevalkanpariya.featuretesteduco.feature_course.presentation.home.HomeViewModel
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey900
import dev.kevalkanpariya.featuretesteduco.ui.theme.title2new

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PopularCategoryListScreen(
    onNavigateUp: () -> Unit,
    onNavigate: (String) -> Unit,
    imageLoader: ImageLoader,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val categories = viewModel.categoryPagingState.value.items

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
            Text(text = "All Popular Categories", color = Grey900, style = title2new)

        }
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(horizontal = 20.dp),
            columns = StaggeredGridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            categories.let {
                items(categories) { category ->
                    CategoryCard(category = category, imageLoader = imageLoader)
                }
            }

        }
    }

}