package dev.kevalkanpariya.educo.presentation.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import dev.kevalkanpariya.educo.ui.theme.Grey50
import dev.kevalkanpariya.educo.ui.theme.Grey500

@Preview
@Composable
fun CheckYourEmailScreen() {

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

            Text(
                modifier = Modifier.layoutId(TitleText),
                text = "Check your email",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .layoutId(DescTxt),
                text = "We’ve sent a password recover instruction to your email",
                color = Grey500,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )

            Image(
                modifier = Modifier
                    .size(280.dp)
                    .layoutId(SvgImage),
                painter = painterResource(id = R.drawable.saved_empty_screen_img),
                contentDescription = "check_your_email_screen"
            )
            
            Button(
                modifier = Modifier.layoutId(OpenEmailBtnRef),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Open email app")
            }

            Button(
                modifier = Modifier.layoutId(DoLaterBtnRef),
                onClick = { /*TODO*/ }
            ) {
                Text(text = "Will do it later")
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .layoutId(InfoTxt),
                text = "Didn’t get any email? Check your spam folder or try again with a valid email.",
                color = Grey500,
                fontWeight = FontWeight.Light,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )


        }



    }



}


private fun decoupledConstraints(
    margin: Dp
): ConstraintSet {
    return ConstraintSet {

        val backBtn = createRefFor(BackBtnRef)
        val titleText = createRefFor(TitleText)
        val descTxt = createRefFor(DescTxt)
        val svgImage = createRefFor(SvgImage)
        val openEmailBtn = createRefFor(OpenEmailBtnRef)
        val doItLaterBtn = createRefFor(DoLaterBtnRef)
        val infoTxt = createRefFor(InfoTxt)



        constrain(titleText) {
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
            top.linkTo(parent.top, 45.dp)
        }

        constrain(descTxt) {
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
            top.linkTo(titleText.bottom, 20.dp)
        }

        constrain(svgImage) {
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
            top.linkTo(descTxt.bottom, 20.dp)
        }

        constrain(openEmailBtn) {
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
            top.linkTo(svgImage.bottom, 60.dp)
        }

        constrain(doItLaterBtn) {
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
            top.linkTo(openEmailBtn.bottom, 20.dp)
        }

        constrain(infoTxt) {
            start.linkTo(parent.start, 20.dp)
            end.linkTo(parent.end, 20.dp)
            //top.linkTo(doItLaterBtn.bottom, 50.dp)
            bottom.linkTo(parent.bottom, 30.dp)
        }



    }
}


private const val BackBtnRef = "back_btn"
private const val TitleText = "title_txt"
private const val DescTxt = "desc_txt"
private const val OpenEmailBtnRef = "open_email_btn"
private const val SvgImage = "svg_img"
private const val DoLaterBtnRef = "do_later_btn"
private const val InfoTxt = "info_txt"