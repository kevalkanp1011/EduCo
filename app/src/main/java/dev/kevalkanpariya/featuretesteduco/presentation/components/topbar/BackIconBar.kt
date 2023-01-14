package dev.kevalkanpariya.featuretesteduco.presentation.components.topbar

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import dev.kevalkanpariya.featuretesteduco.R

@Composable
fun BackIconBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_hearder),
                contentDescription = "back_icon"
            )
        }
    }
}