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

   // object TermsScreen : Screen("terms_screen")

    object LogInScreen : Screen("login_screen")
}

sealed class SettingScreen(val route:String){
    object SettingsMainScreen: SettingScreen("main_screen")
    object ProfileScreen : SettingScreen("profile")
    object AboutUsScreen : SettingScreen("about_us")
    object HowToPlayScreen : SettingScreen("how_to_play")
    object SupportScreen : SettingScreen("support")

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
