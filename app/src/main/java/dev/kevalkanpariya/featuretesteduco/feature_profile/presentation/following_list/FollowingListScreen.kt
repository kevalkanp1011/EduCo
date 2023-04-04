package dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.following_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import dev.kevalkanpariya.featuretesteduco.core.domain.models.UserItem
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.ui.theme.*


@Composable
fun FollowingItem(
    imageLoader: ImageLoader,
    userItem: UserItem,
    onNavigate: (String) -> Unit = {},
    isFollowing: Boolean,
    onFollowingClick: (String) -> Unit = {}
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = userItem.profilePictureUrl,
                    imageLoader = imageLoader
                ),
                contentDescription = "profile photo",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(44.dp)
            )
            Column() {
                Text(
                    text = userItem.name,
                    color = Grey800,
                    fontSize = 18.sp
                )
                Text(
                    text = "@${userItem.username}",
                    color = Grey400,
                    fontSize = 12.sp,
                    modifier = Modifier.clickable {
                        onNavigate(Screen.ProfileScreen.route + "?userId=${userItem.userId}")
                    }
                )
            }
        }
        Button(
            onClick = { onFollowingClick(userItem.userId) },
            colors = buttonColors(backgroundColor = Grey50),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
        ) {
            if (isFollowing == false) {
                Text(text = "Follow", color = Color.Black, fontSize = 14.sp)
            } else {
                Text(text = "Unfollow", color = Color.Black, fontSize = 14.sp)
            }

        }

    }
}