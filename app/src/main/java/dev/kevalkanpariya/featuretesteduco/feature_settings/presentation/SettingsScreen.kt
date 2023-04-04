package dev.kevalkanpariya.featuretesteduco.feature_settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.kevalkanpariya.featuretesteduco.R
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.UiEvent
import dev.kevalkanpariya.featuretesteduco.core.presentation.util.asString
import dev.kevalkanpariya.featuretesteduco.core.util.Screen
import dev.kevalkanpariya.featuretesteduco.ui.theme.*
import kotlinx.coroutines.flow.collectLatest


@Composable
fun SettingsScreen(
    onNavigate: (String) -> Unit = {},
    onNavigateUp: () -> Unit = {},
    onSignOut: () -> Unit = {},
    scaffoldState: ScaffoldState,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val checkedState = viewModel.checkedState.value

    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.uiText.asString(context)
                    )
                }
                is UiEvent.OnSignOut -> {
                    onSignOut()
                }
                else -> {}
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            IconButton(
                onClick = { onNavigateUp() },
            ) {
                Icon(painter = painterResource(id = R.drawable.ic_hearder), contentDescription = null)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                //horizontalArrangement = Arrangement.Center,
            ) {
                Text(text = "Settings", color = Grey900, style = title2new)

            }

        }

        Spacer(modifier = Modifier.height(20.dp))
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(text = "Membership", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Memberships Users", color = Grey700, style = title3_normal)
                }
                Button(
                    onClick = { /*TODO*/ },
                    colors = buttonColors(backgroundColor = Grey50),
                    elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                ) {
                    Text(text = "upgrade", color = Grey800, style = subheadline_medium)
                }
            }
            Divider(color = Grey100, thickness = 1.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(text = "Account", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Profile settings", color = Grey700, style = title3_normal)
                }
                Button(
                    onClick = { onNavigate(Screen.EditProfileScreen.route) },
                    colors = buttonColors(backgroundColor = Grey50),
                    elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
                ) {
                    Text(text = "manage", color = Grey800, style = subheadline_medium)
                }
            }
            Divider(color = Grey100, thickness = 1.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(text = "Notifications", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Personalized Notifications", color = Grey700, style = title3_normal)
                }
                CustomToggleButton(
                    selected = checkedState,
                    onCheckedChange = {
                        viewModel.onEvent(SettingsEvent.OnChecked(it))
                    }
                )

            }
            Divider(color = Grey100, thickness = 1.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column() {
                    Text(text = "Security", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Password Change", color = Grey700, style = title3_normal)
                }
                Button(
                    onClick = { onNavigate(Screen.PasswordChangeScreen.route) },
                    colors = buttonColors(backgroundColor = Grey50),
                    elevation = ButtonDefaults.elevation(defaultElevation = 0.dp)
                ) {
                    Text(text = "manage", color = Grey800, style = subheadline_medium)
                }

            }
            Divider(color = Grey100, thickness = 1.dp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column() {
                    Text(text = "Help & Support", color = Grey500, style = subheadline_medium)
                    Spacer(modifier = Modifier.width(16.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "About Us", color = Grey700, style = title3_normal)
                        IconButton(onClick = { onNavigate(Screen.AboutUs.route) }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Terms & Condition", color = Grey700, style = title3_normal)
                        IconButton(onClick = { onNavigate(Screen.TermsAndConditionsScreen.route) }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Privacy Policy", color = Grey700, style = title3_normal)
                        IconButton(onClick = { onNavigate(Screen.PrivacyPolicyScreen.route) }) {
                            Icon(painter = painterResource(id = R.drawable.ic_arrow_right), contentDescription = null)
                        }
                    }
                }
            }

        }
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { viewModel.onEvent(SettingsEvent.SignOut) },
            colors = buttonColors(
                backgroundColor = Color.White
            ),
            elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(
                text = "sign out",
                color = Primary600,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun CustomToggleButton(
    selected: Boolean,
    modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
) {

    Card(
        modifier = modifier
            .width(50.dp)
            .clickable {
                onCheckedChange(!selected)
            },
        shape = RoundedCornerShape(16.dp),
        elevation = 0.dp
    ) {
        Box(
            modifier = Modifier.background(
                if (selected) Color(0XFF7DB86E) else Color(0XFF001C3D).copy(0.08f)
            ), contentAlignment = if (selected) Alignment.TopEnd else Alignment.TopStart
        ) {
            CheckCircle(modifier = Modifier.padding(5.dp))
        }
    }

}

@Composable
fun CheckCircle(
    modifier: Modifier = Modifier
) {

    Card(
        shape = CircleShape, modifier = modifier.size(20.dp), elevation = 0.dp
    ) {
        Box(modifier = Modifier.background(Color.White))
    }

}