package dev.kevalkanpariya.featuretesteduco.feature_settings.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AboutUs(
    onNavigateUp: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "About As")
        Text(text = "Developed By Keval Kanpariya")

    }
}

@Composable
fun TermsAndConditions(
    onNavigateUp: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(text = "Terms and Conditions")

    }
}

@Composable
fun PrivacyPolicy(
    onNavigateUp: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(text = "Privacy Policy")

    }
}