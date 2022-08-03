package dev.kevalkanpariya.educo.utils

import androidx.annotation.DrawableRes
import dev.kevalkanpariya.educo.R

sealed class OnBoardingPage(
    @DrawableRes
    val image: Int,
    val title: String,
    val description: String) {

    object First : OnBoardingPage(
        title = "Better way to learning\n" +
                "is calling you!",
        image = R.drawable.first,
        description = "Impeet viverra vivamus porttior ules ac vulte lectus velit sen lectus ue "
    )

    object Second : OnBoardingPage(
        title = "Find yourself  by doing whatever you do !",
        image = R.drawable.second,
        description = "Impeet viverra vivamus porttior ules ac vulte lectus velit sen lectus ue "
    )

    object Third : OnBoardingPage(
        title = "It’s not just learning,\n" +
                "It’s a promise!",
        image = R.drawable.third,
        description = "Impeet viverra vivamus porttior ules ac vulte lectus velit sen lectus ue "
    )
}