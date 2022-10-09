package dev.kevalkanpariya.educo.presentation.screens.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.presentation.components.SearchBar

@Composable
fun SearchResultScreen() {
    Column(
        Modifier
            .background(Color.White)
            .padding(top = 30.dp, start = 20.dp, end = 20.dp)) {
        SearchBar()
        Spacer(modifier = Modifier.height(22.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Your search result", fontSize = 15.sp)
            Icon(painter = painterResource(id = R.drawable.ic_filtersearch_filter), contentDescription = null)
        }
        Spacer(modifier = Modifier.height(37.dp))
        SearchResult()
    }

}
@Composable
fun SearchResult() {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        item {
            SearchReItempw()
        }
        item {
            SearchReItempw()
        }
        item {
            SearchReItempw()
        }
        item {
            SearchReItempw()
        }
    }
}

@Composable
fun SearchResultItem(
    course_title: String,
    teacher_name: String,
    noOfStudentEnrolled: Int,
    rating: Double,
    image: Int
) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Image(
                modifier = Modifier.size(width = 80.dp, height = 92.dp),
                painter = painterResource(id = image),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column() {
                Text(text = course_title, fontSize = 18.sp)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = teacher_name, fontSize = 13.sp)
                Spacer(modifier = Modifier.height(6.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(painter = painterResource(id = R.drawable.ic_user_1), contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "$noOfStudentEnrolled student", fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = null, tint = Color(0XffFFA927))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "$rating", fontSize = 12.sp)
                }
            }
        }
}

@Preview
@Composable
fun SearchReItempw() {
    SearchResultItem(
        course_title = "Adobe illustrator for all beginner artist",
        teacher_name = "Samule Doe",
        noOfStudentEnrolled = 4,
        rating = 4.7,
        image = R.drawable.interiordesign
    )
}


@Preview
@Composable
fun SearchResultPW() {
    SearchResultScreen()
}

/*@Preview
@Composable
fun TestIcon() {
    Icon(painter = painterResource(id = R.drawable.ic_star), contentDescription = "mod1", tint = Color(0XffFFA927))
}*/