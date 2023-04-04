package dev.kevalkanpariya.featuretesteduco.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.domain.states.StandardTextFieldState
import dev.kevalkanpariya.featuretesteduco.ui.theme.Grey50
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary600
import dev.kevalkanpariya.featuretesteduco.ui.theme.SpaceLarge

@Composable
fun SendTextField(
    state: StandardTextFieldState,
    onValueChange: (String) -> Unit,
    onSend: () -> Unit,
    hint: String = "",
    canSendMessage: Boolean = true,
    isLoading: Boolean = false,
    focusRequester: FocusRequester = FocusRequester()
) {
    Row(
        modifier = Modifier
            .background(Grey50)
            .fillMaxWidth(),
            //.padding(SpaceLarge),
        verticalAlignment = Alignment.CenterVertically
    ) {
        StandardTextField(
            text = state.text,
            onValueChange = onValueChange,
            backgroundColor = Grey50,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            hint = hint,
            focusRequester = focusRequester,
        )
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .size(24.dp),
                strokeWidth = 2.dp
            )
        } else {
            IconButton(
                onClick = onSend,
                enabled = state.error == null || !canSendMessage
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    tint = Primary600,
                    contentDescription = stringResource(id = R.string.send_comment)
                )
            }
        }
    }
}