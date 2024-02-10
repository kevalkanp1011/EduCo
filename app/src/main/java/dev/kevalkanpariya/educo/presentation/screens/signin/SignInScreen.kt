package dev.kevalkanpariya.educo.presentation.screens.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.kevalkanpariya.educo.navigation.Screen
import dev.kevalkanpariya.educo.presentation.components.buttons.FaceBookButton
import dev.kevalkanpariya.educo.presentation.components.buttons.GoogleButton
import dev.kevalkanpariya.educo.ui.theme.Grey50
import dev.kevalkanpariya.educo.ui.theme.Grey900
import dev.kevalkanpariya.educo.ui.theme.Primary600


@Preview
@Composable
fun PreviewSignInScreen() {
    SignInScreen(
        navController = rememberNavController(),
        onClick = {},
        errorText = null
    )
}

@Composable
fun SignInScreen(
    onClick: () -> Unit,
    errorText: String?,
    navController: NavHostController
) {
    //val isLoading = state.value
    var isLoading by remember { mutableStateOf(false) }

    Column(
        Modifier.padding(35.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(45.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome!",
                color = Grey900,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
            Text(
                text = "Sign in to continue!",
                color = Grey900,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
        }
        Spacer(modifier = Modifier.height(60.dp))
        GoogleButton(backgroundColor = Grey50){
            isLoading = true
            onClick()
        }
        Spacer(modifier = Modifier.height(20.dp))
        FaceBookButton(backgroundColor = Grey50) {
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "or", fontSize = 18.sp, color = Color(0xff585D69))
        Spacer(modifier = Modifier.height(20.dp))



        Spacer(modifier = Modifier.height(10.dp))
        TextButton(onClick = {
            navController.navigate(Screen.Register.route)
        }) {
            Text(
                text = "Sign in",
                color = Primary600,
                fontSize = 16.sp
            )
        }
        errorText?.let {
            isLoading = false
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = it)
        }

    }

}


