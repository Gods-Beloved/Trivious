package com.example.trivious.navigation

sealed class Screen(val route:String) {
    object SplashScreen : Screen("splash_screen")
    object ContestScreen : Screen("contest_screen")
    object PlayScreen : Screen("play_screen")
    object WinScreen : Screen("win_screen")
   object SignUpScreen : Screen("signup_screen")
   object TermsScreen : Screen("terms_screen")
   object LogInScreen : Screen( "login_screen")
}
