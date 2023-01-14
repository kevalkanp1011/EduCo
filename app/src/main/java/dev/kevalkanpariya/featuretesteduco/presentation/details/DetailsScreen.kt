package dev.kevalkanpariya.featuretesteduco.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.presentation.components.TabsLayout
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey400
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey700
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey800
import dev.kevalkanpariya.featuretesteduco.ui.theme.TagBG

@Preview
@Composable
fun DetailsScreen(
    //viewModel: DetailsViewModel = hiltViewModel()
) {

    //val course by viewModel.course
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
            }
            Text(
                text = "Details",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.ic_bookmark), contentDescription = null)
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.details_img),
                    contentDescription = "",
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = null
                    )

                }
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
        ) {
            Text(
                text = "HOT",
                color = Color.White,
                modifier = Modifier
                    .background(TagBG)
                    .padding(horizontal = 15.dp, vertical = 4.dp)
                    .clip(RoundedCornerShape(2.dp))
            )
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.inst1),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Anny Morriarty",
                    fontSize = 16.sp,
                    color = Grey700
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Comic drawing essential for everyone!",
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                color = Grey800
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_clock),
                            contentDescription = "clock",
                            tint = Grey400
                        )
                        Text(
                            text = "1.hour 30 min",
                            color = Grey400,
                            fontSize = 14.sp
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_video_lesson),
                            contentDescription = "video_lesson",
                            tint = Grey400
                        )
                        Text(
                            text = "5",
                            color = Grey400,
                            fontSize = 14.sp
                        )
                    }

                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star_liniar),
                            contentDescription = "rating",
                            tint = Grey400
                        )
                        Text(
                            text = "4.7  (457)      ",
                            color = Grey400,
                            fontSize = 14.sp
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_user),
                            contentDescription = "person",
                            tint = Grey400
                        )
                        Text(
                            text = "500  students",
                            color = Grey400,
                            fontSize = 14.sp
                        )
                    }

                }

            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "course!!.description",
                color = Grey700,
                fontSize = 16.sp
            )

            TabsLayout()
            
        }
    }
}