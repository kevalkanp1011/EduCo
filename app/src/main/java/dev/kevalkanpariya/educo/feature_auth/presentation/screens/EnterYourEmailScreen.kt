package dev.kevalkanpariya.educo.feature_auth.presentation.screens

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
import dev.kevalkanpariya.educo.core.presentation.components.textfields.EdTextField1
import dev.kevalkanpariya.educo.ui.theme.Primary600
import dev.kevalkanpariya.educo.ui.theme.Shapes

@Preview
@Composable
fun EnterYourEmailScreen(
    email: String = "",
    onEmailChanged: () -> Unit = {}
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
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize(), constraintSet = constraints
        ) {
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
                text = "Enter your email",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                //textAlign = TextAlign.Start
            )

            EdTextField1(
                value = email,
                onValueChange = { onEmailChanged() },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .clip(Shapes.medium)
                    .layoutId(EmailAddressText),
                placeholderText = "Email",
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,

                    ),
                trailingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_eye),
                        contentDescription = "passwd"
                    )
                }
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .height(60.dp)
                    .layoutId(SendEmailButton),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary600,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(6.dp),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Send Email",
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
        val emailTxt = createRefFor(EmailAddressText)
        val sendEmailButton = createRefFor(SendEmailButton)

        constrain(backBtn) {
            top.linkTo(parent.top, 30.dp)
            start.linkTo(parent.start, 5.dp)

        }

        constrain(titleTxt) {
            top.linkTo(backBtn.bottom, 20.dp)
            start.linkTo(parent.start, 20.dp)


        }

        constrain(emailTxt) {
            top.linkTo(titleTxt.bottom, 50.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }

        constrain(sendEmailButton) {
            top.linkTo(emailTxt.bottom, 50.dp)
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
        }


    }
}

private const val BackBtnRef = "back_btn"
private const val TitleTxt = "title_txt"
private const val EmailAddressText = "email_address_txt"
private const val SendEmailButton = "send_email_btn"