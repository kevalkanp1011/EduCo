package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.ui.theme.SearchBarBG
import dev.kevalkanpariya.featuretesteduco.ui.theme.Shapes


@Composable
fun SearchBar(
    text: String,
    onSearch: (String) -> Unit
) {

    TextField(value = text,
        onValueChange = {
            onSearch(it)
        },
        label = null,
        placeholder = { Text(text = "Search") },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = SearchBarBG,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        maxLines = 1,
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shapes.medium),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "",
                modifier = Modifier.size(28.dp)
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        )
    )

}
