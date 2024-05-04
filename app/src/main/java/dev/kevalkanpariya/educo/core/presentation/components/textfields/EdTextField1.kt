package dev.kevalkanpariya.educo.core.presentation.components.textfields

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EdTextField1(
    modifier: Modifier = Modifier,
    placeholderText: String,
    value: String,
    onValueChange: (String) -> Unit,
    singleLine: Boolean = true,
    colors: TextFieldColors =TextFieldDefaults.colors(),
    trailingIcon: @Composable () -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        singleLine = singleLine,
        interactionSource = interactionSource,
        decorationBox = { innerTextField ->
            TextFieldDefaults.DecorationBox(
                value = value,
                visualTransformation = VisualTransformation.None,
                innerTextField = innerTextField,
                singleLine = singleLine,
                enabled = true,
                interactionSource = interactionSource,
                contentPadding = PaddingValues(start = 0.dp, bottom = 25.dp), // this is how you can remove the padding,
                placeholder = {
                    Text(text = "$placeholderText")
                },
                trailingIcon = trailingIcon,
                colors = colors
            )
        }
    )
}