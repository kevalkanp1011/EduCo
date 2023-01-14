package dev.kevalkanpariya.featuretesteduco.presentation.profile

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.presentation.components.DisplayAlertDialog
import dev.kevalkanpariya.featuretesteduco.ui.theme.topAppBarBackgroundColor
import dev.kevalkanpariya.featuretesteduco.ui.theme.topAppBarContentColor

@Composable
fun ProfileTopBar(
    onSave: () -> Unit,
    onDeleteAllConfirmed: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = "Profile",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            ProfileTopBarActions(
                onSave = onSave,
                onDeleteAllConfirmed = onDeleteAllConfirmed
            )
        }
    )
}

@Composable
fun ProfileTopBarActions(
    onSave: () -> Unit,
    onDeleteAllConfirmed: () -> Unit,
) {
    var openDialog by remember { mutableStateOf(false) }

    DisplayAlertDialog(
        openDialog = openDialog,
        onYesClicked = { onDeleteAllConfirmed() },
        onDialogClosed = { openDialog = false }
    )

    SaveAction(onSave = onSave)
    DeleteAllAction(onDelete = { openDialog = true})
}

@Composable
fun SaveAction(onSave: () -> Unit) {
    IconButton(onClick = onSave) {
        Icon(
            painter = painterResource(id = R.drawable.ic_save),
            contentDescription = "Save Icon",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun DeleteAllAction(onDelete: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_vertical_menu),
            contentDescription = "Vertical Menu",
            tint = MaterialTheme.colors.topAppBarContentColor
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    expanded = false
                    onDelete()
                }
            ) {
                Text(
                    text = "Delete Account",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }
    }
}

@Composable
@Preview
fun ProfileTopBarPreview() {
    ProfileTopBar(onSave = {}, onDeleteAllConfirmed = {})
}