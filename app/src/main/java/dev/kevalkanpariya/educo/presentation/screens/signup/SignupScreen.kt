package dev.kevalkanpariya.educo.presentation.screens.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.kevalkanpariya.educo.navigation.Screen
import dev.kevalkanpariya.educo.presentation.components.buttons.FaceBookButton
import dev.kevalkanpariya.educo.presentation.components.buttons.GoogleButton
import dev.kevalkanpariya.educo.ui.theme.Grey50
import dev.kevalkanpariya.educo.ui.theme.Grey900
import dev.kevalkanpariya.educo.ui.theme.Primary600
import dev.kevalkanpariya.educo.ui.theme.Shapes

@Preview
@Composable
fun SignupScreen(
    errorText: String? = null,
    navController: NavHostController = rememberNavController()
) {

    //val isLoading = state.value
    var isLoading by remember { mutableStateOf(false) }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
    ) {

        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }

        ConstraintLayout(constraints) {

            Column(
                modifier = Modifier.layoutId(titleTextRef),
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

            GoogleButton(modifier = Modifier.layoutId(signUpWithGoogleBtnRef), backgroundColor = Grey50) {
                isLoading = true
                //startForResult.launch(googleSignInClient?.signInIntent)
            }

            FaceBookButton(modifier = Modifier.layoutId(signUpWithFacebookBtnRef), backgroundColor = Grey50) {
            }

            Text(modifier = Modifier.layoutId(orTextRef), text = "or", fontSize = 18.sp, color = Color(0xff585D69), textAlign = TextAlign.Center)


            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .layoutId(signUpWithEmailBtnRef),
                shape = Shapes.medium,
                color = Grey50
            ) {
                Row(
                    modifier = Modifier
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

            Text(
                modifier = Modifier.layoutId(termsAndCondTextRef),
                text = "By signing up you are agreed with our \nfriendly terms and condition.",
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.layoutId(alreadyHaveAnAcctTextRef),
                text = "Already have an account?",
                fontSize = 16.sp,
                color = Color(0xff383838),
                textAlign = TextAlign.Center
            )

            TextButton(
                modifier = Modifier.layoutId(navigateToSignInBtnRef),
                onClick = {
                navController.navigate(Screen.Home.route)
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


private fun decoupledConstraints(
    margin: Dp
): ConstraintSet {
    return ConstraintSet {

        val titleText = createRefFor(titleTextRef)
        val signUpWithGoogleBtn = createRefFor(signUpWithGoogleBtnRef)
        val signUpWithFacebookBtn = createRefFor(signUpWithFacebookBtnRef)
        val orText = createRefFor(orTextRef)
        val signUpWithEmailBtn = createRefFor(signUpWithEmailBtnRef)
        val termsAndCondText = createRefFor(termsAndCondTextRef)
        val alreadyHaveAnAcctText = createRefFor(alreadyHaveAnAcctTextRef)
        val navigateToSignInBtn = createRefFor(navigateToSignInBtnRef)




        constrain(titleText) {
            top.linkTo(parent.top, 45.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(signUpWithGoogleBtn) {
            top.linkTo(titleText.bottom, 60.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)

        }

        constrain(signUpWithFacebookBtn) {
            top.linkTo(signUpWithGoogleBtn.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(orText) {
            top.linkTo(signUpWithFacebookBtn.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(signUpWithEmailBtn) {
            top.linkTo(orText.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(termsAndCondText) {
            top.linkTo(signUpWithEmailBtn.bottom, 20.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(alreadyHaveAnAcctText) {
            top.linkTo(termsAndCondText.bottom, 77.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

        constrain(navigateToSignInBtn) {
            top.linkTo(alreadyHaveAnAcctText.bottom, 10.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }

    }
}


private const val titleTextRef = "title_txt"
private const val signUpWithGoogleBtnRef = "signup_with_google"
private const val signUpWithFacebookBtnRef = "signup_with_facebook"
private const val orTextRef = "or_txt"
private const val signUpWithEmailBtnRef = "signup_with_email"
private const val termsAndCondTextRef = "termsAndCondText"
private const val alreadyHaveAnAcctTextRef = "alreadyHaveAnAcctText"
private const val navigateToSignInBtnRef = "navigate_to_sign_in_btn"
