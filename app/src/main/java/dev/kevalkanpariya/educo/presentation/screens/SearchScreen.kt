package dev.kevalkanpariya.educo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.google.accompanist.flowlayout.SizeMode
import dev.kevalkanpariya.educo.presentation.components.SearchBar
import dev.kevalkanpariya.educo.ui.theme.Grey600

@Preview
@Composable
fun SearchScreen() {
    Column(
        Modifier
            .background(Color.White)
            .padding(20.dp)) {
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Top searches", color = Grey600)
        HashTagPreview()
        Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Categories", color = Grey600)
        /*Spacer(modifier = Modifier.height(28.dp))
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                CourseCard(
                    title = "Interior Design",
                    imagePainter = painterResource(id = R.drawable.interiordesign)
                )
            }
            item {
                CourseCard(
                    title = "Traditional Art",
                    imagePainter = painterResource(id = R.drawable.traditional_art)
                )
            }

        }*/
    }

}

@Composable
fun HashTagPreview() {
    val systemUsers: MutableList<String> = mutableListOf(
        "photography",
        "craft",
        "art",
        "procreate",
        "marketing",
        "UX design"
    )
    Spacer(modifier = Modifier.height(28.dp))
    HashTagList(hashTags = systemUsers)
}

@Composable
fun HashTagList(hashTags: List<String>) {
    FlowRow(
        //modifier = Modifier.fillMaxWidth(),
        mainAxisAlignment = MainAxisAlignment.Start,
        mainAxisSize = SizeMode.Expand,
        crossAxisSpacing = 10.dp,
        mainAxisSpacing = 10.dp
    ) {
        hashTags.forEach { hashTag ->
            Text(
                text = hashTag,
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
}
