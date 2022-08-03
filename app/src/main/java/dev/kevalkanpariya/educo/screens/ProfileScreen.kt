package dev.kevalkanpariya.educo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.domain.model.Student
import dev.kevalkanpariya.educo.domain.model.sudorizwan

@Composable
private fun ProfileContent(student: Student) {
    Column(modifier = Modifier.layoutId("content")) {
        Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
            Spacer(modifier = Modifier.height(44.dp))

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
fun Privewavatar() {
    StudentProfile(student = sudorizwan)
}


@Composable
fun StudentProfile(student: Student) {
    BoxWithConstraints {
        val constraints = decoupledConstraints()
        ConstraintLayout(constraints) {
            Banner(student)
            settingsButton()
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
private fun settingsButton() {
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
