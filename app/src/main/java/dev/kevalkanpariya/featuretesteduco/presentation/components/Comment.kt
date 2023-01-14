package dev.kevalkanpariya.featuretesteduco.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.*

@Preview
@Composable
fun Comment() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_img_2),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                text = "@username",
                color = Grey800,
                fontSize = 15.sp
            )
            Text(
                text = "11 mins ago   .   Student",
                color = Grey400,
                fontSize = 13.sp
            )
            Text(
                text = "How to get better at line? I am really stuck in this step!",
                color = Grey800,
                fontSize = 15.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row() {
                    Text(text = "Liked", color = Primary600, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Reply", color = Grey600, fontSize = 14.sp)

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = null,
                        modifier = Modifier.height(16.dp),
                        tint = Primary600
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "21", color = Primary600)
                }

            }

        }
    }
}

@Composable
fun CommentTeacher() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = R.drawable.user_img_2),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "@username",
                    color = Grey800,
                    fontSize = 15.sp
                )
                Text(
                    text = "teacher",
                    color = Color.White,
                    modifier = Modifier
                        .background(TagBGTeacher)
                        .padding(horizontal = 12.dp, vertical = 3.dp)
                        .clip(RoundedCornerShape(2.dp))
                )
            }

            Text(
                text = "20 mins ago",
                color = Grey400,
                fontSize = 13.sp
            )
            Text(
                text = "The step is really easy, just keep practicing line drawing with right posture and correct pencil holding as showen in the video! Good luck ❤",
                color = Grey800,
                fontSize = 15.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row() {
                    Text(text = "Liked", color = Primary600, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Reply", color = Grey600, fontSize = 14.sp)

                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like),
                        contentDescription = null,
                        modifier = Modifier.height(16.dp),
                        tint = Primary600
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "21", color = Primary600)
                }

            }

        }
    }
}
