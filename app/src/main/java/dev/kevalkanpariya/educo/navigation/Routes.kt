package dev.kevalkanpariya.educo.navigation


sealed class Routes(val route: String) {

    object OnboardingScreen: Routes("onboarding")
    object SignInScreen: Routes("sign_in")
    object SignUpScreen: Routes("sign_up")
    object SignUpWithEmailScreen: Routes("sign_up_with_email")
    object EnterEmailToGetPasswordScreen: Routes("enter_email_to_get_pwd_screen")
    object ResetPasswordScreen: Routes("reset_pwd")

    object MainScreen: Routes("main")
}