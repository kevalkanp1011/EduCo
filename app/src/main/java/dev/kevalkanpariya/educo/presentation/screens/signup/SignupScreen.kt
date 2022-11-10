package dev.kevalkanpariya.educo.presentation.screens.signup

import android.app.Activity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
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
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import dev.kevalkanpariya.educo.navigation.Screen
import dev.kevalkanpariya.educo.presentation.components.buttons.FaceBookButton
import dev.kevalkanpariya.educo.presentation.components.buttons.GoogleButton
import dev.kevalkanpariya.educo.ui.theme.Grey50
import dev.kevalkanpariya.educo.ui.theme.Grey900
import dev.kevalkanpariya.educo.ui.theme.Primary600
import dev.kevalkanpariya.educo.ui.theme.Shapes


@Composable
fun SignupScreen(
    errorText: String?,
    navController: NavHostController
) {

    //val isLoading = state.value
    var isLoading by remember { mutableStateOf(false) }

    Scaffold {
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
                    text = "Sign up to continue!",
                    color = Grey900,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                )
            }
            Spacer(modifier = Modifier.height(60.dp))
            GoogleButton(backgroundColor = Grey50){
                isLoading = true
                //startForResult.launch(googleSignInClient?.signInIntent)
            }
            Spacer(modifier = Modifier.height(20.dp))
            FaceBookButton(backgroundColor = Grey50) {
            }
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "or", fontSize = 18.sp, color = Color(0xff585D69))
            Spacer(modifier = Modifier.height(20.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = Shapes.medium,
                color = Grey50
            ) {
                Row(modifier = Modifier
                    .padding(
                        start = 12.dp,
                        end = 16.dp,
                        top = 12.dp,
                        bottom = 12.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        onClick = {
                            navController.navigate("signup_form")
                        }
                    ) {
                        Text(
                            text = "Sign up with email",
                            color = Grey900,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "By signing up you are agreed with our",
                    fontSize = 14.sp
                )
                Text(
                    text = "friendly terms and condition.",
                    fontSize = 14.sp
                )
            }
            Spacer(modifier = Modifier.height(77.dp))
            Text(
                text = "Already have an account?",
                fontSize = 16.sp,
                color = Color(0xff383838)
            )
            Spacer(modifier = Modifier.height(10.dp))
            TextButton(onClick = {
                navController.navigate(Screen.Login.route)
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

}


