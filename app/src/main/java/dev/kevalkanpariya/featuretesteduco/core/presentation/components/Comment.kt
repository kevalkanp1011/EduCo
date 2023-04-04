package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.models.Comment
import dev.kevalkanpariya.featuretesteduco.ui.theme.*

@Composable
fun Comment(
    modifier: Modifier = Modifier,
    comment: Comment,
    imageLoader: ImageLoader,
    onLikeClick: (Boolean) -> Unit = {},

) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = comment.profilePictureUrl,
                imageLoader = imageLoader
            ),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column() {
            Text(
                text = "@${comment.username}",
                color = Grey800,
                fontSize = 15.sp
            )
            Text(
                text = "${comment.formattedTime}   .   Student",
                color = Grey400,
                fontSize = 13.sp
            )
            Text(
                text = comment.comment,
                color = Grey800,
                fontSize = 15.sp
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                /*Row() {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Liked", color = Primary600, fontSize = 14.sp)
                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Reply", color = Grey600, fontSize = 14.sp)
                    }

                }*/
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (comment.isLiked) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_liked_filled),
                            contentDescription = null,
                            tint = Primary600,
                            modifier = Modifier
                                .height(16.dp)
                                .clickable { onLikeClick(comment.isLiked) },

                            )
                    }
                    else {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_like),
                            contentDescription = null,
                            tint = Primary600,
                            modifier = Modifier
                                .height(16.dp)
                                .clickable { onLikeClick(comment.isLiked) },

                            )
                    }

                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = comment.likeCount.toString(),
                        color = Primary600,
                        fontSize = 11.sp
                    )
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
