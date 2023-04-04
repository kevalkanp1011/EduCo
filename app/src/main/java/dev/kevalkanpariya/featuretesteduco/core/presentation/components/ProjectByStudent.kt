package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Project
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey50
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary600

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProjectByStudent(
    imageLoader: ImageLoader,
    projects: List<Project>,
    onAddProjectClick: () -> Unit = {}
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "project by students")
        TextButton(
            onClick = onAddProjectClick,
            colors = buttonColors(backgroundColor = Grey50)
        ) {
            Text(text = "Add Project")
        }
    }

    val state = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        state = state,
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        content = {

            items(projects) { project ->
                Image(
                    painter = rememberAsyncImagePainter(
                        model = project.imageUrls[0],
                        imageLoader = imageLoader
                    ),
                    contentDescription = "Project Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(160.dp)
                )
            }
        }
    )
    
    TextButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = {

        },
        colors = buttonColors(backgroundColor = Color.White)
    ) {
        Text(
            text = "Load more",
            color = Primary600,
            fontSize = 16.sp
        )
    }

}