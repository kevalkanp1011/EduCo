package dev.kevalkanpariya.educo.presentation.screens.auth

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import dev.kevalkanpariya.educo.R
import dev.kevalkanpariya.educo.ui.theme.Primary600
import dev.kevalkanpariya.educo.ui.theme.Shapes
import dev.kevalkanpariya.educo.ui.theme.searchBarbg

@Preview
@Composable
fun ResetPasswordScreen(
    pwd: String = "",
    onPwdChanged: () ->Unit = {},
    confirmPwd: String = "",
    onConfirmPwdChanged: () ->Unit = {},
) {

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
    ) {

        val constraints = if (minWidth < 600.dp) {
            decoupledConstraints(margin = 16.dp) // Portrait constraints
        } else {
            decoupledConstraints(margin = 32.dp) // Landscape constraints
        }
        ConstraintLayout(modifier = Modifier
            .fillMaxSize(), constraintSet = constraints) {
            IconButton(
                modifier = Modifier.layoutId(BackBtnRef),
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_hearder),
                    contentDescription = "back_btn"
                )
            }

            Text(
                modifier = Modifier
                    .wrapContentWidth()
                    .layoutId(TitleTxt),
                text = "Reset your password",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                //textAlign = TextAlign.Start
            )

            TextField(
                value = pwd,
                onValueChange = {onPwdChanged()},
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clip(Shapes.medium)
                    .layoutId(PasswordText),
                label = null,
                placeholder = { Text(text = "Enter new password") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = searchBarbg,
                    unfocusedContainerColor = searchBarbg,
                    disabledContainerColor = searchBarbg,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )

            TextField(
                value = confirmPwd,
                onValueChange = { onConfirmPwdChanged() },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clip(Shapes.medium)
                    .layoutId(ConfirmPasswordText),
                label = null,
                placeholder = { Text(text = "Enter Confirm Password") },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = searchBarbg,
                    unfocusedContainerColor = searchBarbg,
                    disabledContainerColor = searchBarbg,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(60.dp)
                    .layoutId(ResetButton),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary600,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(6.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Reset Password",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center

                )
            }




        }



    }
}

private fun decoupledConstraints(
    margin: Dp
): ConstraintSet {
    return ConstraintSet {

        val backBtn = createRefFor(BackBtnRef)
        val titleTxt = createRefFor(TitleTxt)
        val pwdTxt = createRefFor(PasswordText)
        val confirmPwdTxt = createRefFor(ConfirmPasswordText)
        val sendEmailButton = createRefFor(ResetButton)

        constrain(backBtn) {
            top.linkTo(parent.top, 30.dp)
            start.linkTo(parent.start, 5.dp)

        }

        constrain(titleTxt) {
            top.linkTo(backBtn.bottom, 20.dp)
            start.linkTo(parent.start, 20.dp)

        }

        constrain(pwdTxt) {
            top.linkTo(titleTxt.bottom, 50.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

        constrain(confirmPwdTxt) {
            top.linkTo(pwdTxt.bottom, 50.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

        constrain(sendEmailButton) {
            top.linkTo(confirmPwdTxt.bottom, 50.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }


    }
}

private const val BackBtnRef = "back_btn"
private const val TitleTxt = "title_txt"
private const val PasswordText = "pwd_txt"
private const val ConfirmPasswordText = "confirm_pwd_txt"
private const val ResetButton = "send_email_btn"