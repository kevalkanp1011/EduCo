package dev.kevalkanpariya.educo.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.domain.model.Student
import dev.kevalkanpariya.educo.domain.model.sudorizwan
import dev.kevalkanpariya.educo.presentation.screens.search.SearchReItempw
import dev.kevalkanpariya.educo.ui.theme.Grey800

//student: Student
@Composable
private fun ProfileContent(student: Student) {
    Column(modifier = Modifier.layoutId("content")) {
        Column(
            modifier = Modifier
                .padding(start = 90.dp, end = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text("@KK1012")
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Just a simple guy who loves do something new and fun!", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(15.dp))
            
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_instagram), contentDescription = "Instagram")
                Icon(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = "Facebook")
                Icon(painter = painterResource(id = R.drawable.ic_twitter), contentDescription = "Twitter")
                
            }


        }
        Spacer(Modifier.height(32.dp))
        var state by remember { mutableStateOf(0) }
        val titles = listOf("Projects", "Courses", "Following")
        TabRow(
            selectedTabIndex = state,
            backgroundColor = Color.Transparent,
            contentColor = Grey800
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }
        Spacer(Modifier.height(30.dp))
        /*Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Text tab ${state + 1} selected",
            style = MaterialTheme.typography.body1
        )*/
        LazyColumn(
            Modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
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
        /*CustomDivider()
        tweets.filter { it.student == student }.forEach { tweet ->
            TweetLayout(tweet)
            CustomDivider()
        }*/
    }
}

@Composable
private fun Avatar(student: Student) {
    Image(
        painter = painterResource(student.avatar),
        contentDescription = null,
        modifier = Modifier
            .size(80.dp)
            .clip(shape = RoundedCornerShape(40.dp))
            .layoutId("avatar"),
        contentScale = ContentScale.Crop
    )
}
@Preview
@Composable
fun PreviewProfile() {
    StudentProfile(student = sudorizwan)
}


@Composable
fun StudentProfile(student: Student) {
    BoxWithConstraints {
        val constraints = decoupledConstraints()
        ConstraintLayout(constraints) {
            Banner(student)
            SettingsButton()
            Avatar(student)
            ProfileContent(student)

        }
    }
}


@Composable
private fun Banner(student: Student) {
    Image(
        painter = painterResource(student.banner),
        contentDescription = null,
        modifier = Modifier
            .height(180.dp)
            .fillMaxWidth()
            .layoutId("banner"),
        contentScale = ContentScale.Crop
    )
}
@Composable
private fun SettingsButton() {
    Icon(
        painter = painterResource(id = R.drawable.ic_settings),
        modifier = Modifier.layoutId("ic_settings"),
        contentDescription = null,
        tint = Color.White
    )
}


private fun decoupledConstraints(): ConstraintSet {
    return ConstraintSet {
        val banner = createRefFor("banner")
        val settings = createRefFor("ic_settings")
        val avatar = createRefFor("avatar")
        val bio = createRefFor("content")

        constrain(banner) {
            top.linkTo(parent.top)
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
        constrain(bio) {
            top.linkTo(avatar.bottom)
            absoluteLeft.linkTo(parent.absoluteLeft)
            absoluteRight.linkTo(parent.absoluteRight)
        }

    }
}

@Preview
@Composable
fun IconAvatar() {
    Icon(painter = painterResource(id = R.drawable.ic_instagram), contentDescription = "Instagram")
    Icon(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = "Facebook")
    Icon(painter = painterResource(id = R.drawable.ic_twitter), contentDescription = "Twitter")

}
