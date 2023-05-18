package dev.kevalkanpariya.featuretesteduco.feature_settings.presentation

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.presentation.components.StandardTextField
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.asString
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.showKeyboard
import dev.kevalkanpariya.featuretesteduco.feature_profile.presentation.profile.ProfileViewModel
import dev.kevalkanpariya.featuretesteduco.ui.theme.Error500
import dev.kevalkanpariya.featuretesteduco.ui.theme.Primary600
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.File

@Composable
fun EditProfileScreen(
    onNavigateUp: () -> Unit = {},
    onNavigate: (String) -> Unit = {},
    imageLoader: ImageLoader,
    scaffoldState: ScaffoldState,
    viewModel: SettingsViewModel = hiltViewModel()
) {

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
        viewModel.selectedImageUri.value = uri
    }

    val focusRequester = remember {
        FocusRequester()
    }

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
                else -> {}
            }
        }
    }


    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onNavigateUp() },
                modifier = Modifier.padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_hearder),
                    contentDescription = "back_icon"
                )
            }
            Text(
                text = "Profile Settings",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = viewModel.selectedImageUri.value,
                    imageLoader = imageLoader
                ),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Change profile picture",
                color = Primary600,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
                    .clickable {
                        launcher.launch("image/*")
                    }
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "person logo")
                StandardTextField(
                    text = viewModel.bioState.value.text,
                    hint = "bio",
                    maxLength = 10,
                    onValueChange = {
                        viewModel.onEvent(SettingsEvent.EnteredBio(it))
                    },
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_profile), contentDescription = "person logo")
                StandardTextField(
                    text = viewModel.usernameState.value.text,
                    hint = "username",
                    maxLength = 10,
                    onValueChange = {
                        viewModel.onEvent(SettingsEvent.EnteredUsername(it))
                    },
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                    focusRequester = focusRequester
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_facebook), contentDescription = "person logo")
                StandardTextField(
                    text = viewModel.facebookUrlState.value.text,
                    hint = "facebook url",
                    maxLength = 10,
                    onValueChange = {
                        viewModel.onEvent(SettingsEvent.EnteredFacebookUrl(it))
                    },
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_twitter), contentDescription = "person logo")
                StandardTextField(
                    text = viewModel.twitterUrlState.value.text,
                    hint = "twitter url",
                    maxLength = 10,
                    onValueChange = {
                        viewModel.onEvent(SettingsEvent.EnteredTwitterUrl(it))
                    },
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.ic_instagram), contentDescription = "person logo")
                StandardTextField(
                    text = viewModel.instagramUrlState.value.text,
                    hint = "instagram url",
                    maxLength = 10,
                    onValueChange = {
                        viewModel.onEvent(SettingsEvent.EnteredInstagramUrl(it))
                    },
                    backgroundColor = Color.White,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { viewModel.onEvent(SettingsEvent.Cancel) },
                colors = buttonColors(backgroundColor = Color.White),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(
                    text = "Cancel",
                    color = Error500,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(
                onClick = {
                    viewModel.onEvent(SettingsEvent.Save(context))
                },
                colors = buttonColors(backgroundColor = Primary600),
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
            ) {
                Text(
                    text = "Save",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
        
    }
}