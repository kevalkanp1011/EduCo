package dev.kevalkanpariya.featuretesteduco.presentation.course_page.overview.comment_reply

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.presentation.components.Comment
import dev.kevalkanpariya.featuretesteduco.presentation.components.CommentTeacher
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey50
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey800

@Preview
@Composable
fun CommentReply() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        IconButton(onClick = { /*TODO*/ }, modifier = Modifier.padding(8.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.ic_hearder),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column(
            Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "1 Replies",
                    color = Grey800,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
                TextButton(
                    onClick = { /*TODO*/ },
                    colors = buttonColors(backgroundColor = Grey50),
                    shape = RoundedCornerShape(4.dp),

                    ) {
                    Text(
                        text = "Add Reply",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Comment()
            Spacer(modifier = Modifier.height(30.dp))
            CommentTeacher()
        }


    }

}