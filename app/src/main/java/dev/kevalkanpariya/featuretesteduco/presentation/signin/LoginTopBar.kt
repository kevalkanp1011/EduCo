package dev.kevalkanpariya.featuretesteduco.presentation.signin

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.kevalkanpariya.featuretesteduco.ui.theme.topAppBarBackgroundColor
import dev.kevalkanpariya.featuretesteduco.ui.theme.topAppBarContentColor


@Composable
fun LoginTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "Sign in",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
@Preview
fun LoginTopBarPreview() {
    LoginTopBar()
}