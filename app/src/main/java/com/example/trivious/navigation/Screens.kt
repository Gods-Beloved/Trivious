package com.example.trivious.navigation

import androidx.annotation.DrawableRes
import com.example.trivious.R

sealed class Screen(val route: String) {
    object SplashScreen : Screen("splash_screen")

    object ContestScreen : Screen("contest_screen")

    object MainScreen : Screen("main_screen")

    object PlayScreen : Screen("play_screen")

    object WinScreen : Screen("win_screen")

    object SignUpScreen : Screen("signup_screen")

    object ProfileScreen : Screen("profile")

    object AboutUsScreen : Screen("about_us")

    object HowToPlayScreen : Screen("how_to_play")

    object SupportScreen : Screen("support")

    // object TermsScreen : Screen("terms_screen")

    object LogInScreen : Screen("login_screen")

    object LiveQuizScreen : Screen("live_screen")

    object AcademicQuizScreen : Screen("academic_screen")

    object SportQuizScreen : Screen("sport_screen")

    object EntertainmentQuizScreen : Screen("entertainment_screen")

    object LivePaymentScreen : Screen("payment_screen")

    object LiveCorrectScreen : Screen("correct_screen")

    object LiveWrongScreen : Screen("wrong_screen")

    object LiveTimeOutScreen : Screen("timeout_screen")




}





sealed class BottomNavScreen(

   val id: String,
    val title: String,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavScreen(id = "home", title = "Home",R.drawable.ic_home)

    object Board : BottomNavScreen(id = "board", title = "Board",R.drawable.ic_gamepad)

    object Wallet : BottomNavScreen(id = "wallet", title = "Wallet",R.drawable.ic_wallet)

    object Settings : BottomNavScreen(id = "setting", title = "Settings",R.drawable.ic_settings)


    object Items{
        val list= listOf(
            Home,Board,Wallet,Settings
        )
    }

}
