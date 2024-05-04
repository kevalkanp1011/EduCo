package dev.kevalkanpariya.educo.core.navigation


sealed class Routes(val route: String) {

    //AuthNavGraph Routes
    object OnboardingScreen: Routes("onboarding")
    object SignInScreen: Routes("sign_in")
    object SignUpScreen: Routes("sign_up")
    object SignUpWithEmailScreen: Routes("sign_up_with_email")
    object EnterEmailToGetPasswordScreen: Routes("enter_email_to_get_pwd_screen")
    object ResetPasswordScreen: Routes("reset_pwd")

    object ForgotPasswordScreen: Routes("forgot_pwd")
    object MainNavGraph: Routes("main")


    //MainNavGraph Routes
    object HomeScreen: Routes("home_screen")
    object SearchScreen: Routes("search_screen")

    object SavedScreen: Routes("saved_screen")
    object ProfileScreen: Routes("profile_screen")
}