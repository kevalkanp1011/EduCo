package dev.kevalkanpariya.educo.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.feature_course.domain.models.Student
import dev.kevalkanpariya.educo.feature_course.domain.models.keval
import dev.kevalkanpariya.educo.presentation.screens.student_profile.personal.Courses
import dev.kevalkanpariya.educo.ui.theme.Grey700
import dev.kevalkanpariya.educo.ui.theme.Grey800


//StudentProfile
@Composable
fun StudentProfile(student: Student) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {
            Banner(student)
            SettingsButton()
            Avatar(student)
            ProfileContent(student)
        }

    }
}


@Composable
private fun ProfileContent(student: Student) {
    Column(modifier = Modifier.layoutId("content")) {
        Column(
            modifier = Modifier
                .padding(start = 90.dp, end = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text("@${student.username}")
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = student.bio, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(15.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_instagram),
                    contentDescription = "Instagram"
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_facebook),
                    contentDescription = "Facebook"
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_twitter),
                    contentDescription = "Twitter"
                )

            }
        }

        Spacer(Modifier.height(32.dp))
        var state by remember { mutableStateOf(0) }
        val titles = listOf("03\nProjects", "04\nCourses", "08\nFollowing")
        TabRow(
            selectedTabIndex = state,
            backgroundColor = Color.Transparent,
            contentColor = Grey800
        ) {
            titles.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Column {
                            Text(title, color = Grey700)
                        }
                    },
                    selected = state == index,
                    onClick = { state = index }
                )
            }
        }
        Spacer(Modifier.height(30.dp))
        Courses()

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


private fun decoupledConstraints(
    margin: Dp
): ConstraintSet {
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
fun PreviewProfile() {
    StudentProfile(student = keval)
}
