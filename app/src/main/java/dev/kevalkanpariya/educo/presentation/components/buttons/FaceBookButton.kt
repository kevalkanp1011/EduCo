package dev.kevalkanpariya.educo.presentation.components.buttons

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.Grey900
import dev.kevalkanpariya.educo.ui.theme.Shapes

@Composable
fun FaceBookButton(
    modifier: Modifier = Modifier,
    text: String = "Sign Up with FaceBook",
    isLoading: Boolean = false,
    loadingText: String = "Creating Account...",
    icon: Int = R.drawable.ic_facebook,
    shape: Shape = Shapes.medium,
    backgroundColor: Color = MaterialTheme.colors.surface,
    progressIndicatorColor: Color = MaterialTheme.colors.primary,
    onClicked: () -> Unit
) {

    Surface(
        modifier = modifier
            .clickable(
                enabled = isLoading,
                onClick = onClicked
            )
            .fillMaxWidth(),
        shape = shape,
        color = backgroundColor
    ) {
        Row(
            modifier = Modifier
                .padding(
                    start = 12.dp,
                    end = 16.dp,
                    top = 12.dp,
                    bottom = 12.dp
                )
                .animateContentSize(
                    animationSpec = tween(
                        durationMillis = 300,
                        easing = LinearOutSlowInEasing
                    )
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = "FaceBook Button",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = if (isLoading) loadingText else text,
                color = Grey900,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
            if (isLoading) {
                Spacer(modifier = Modifier.width(16.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp,
                    color = progressIndicatorColor
                )
            }
        }
    }
}