package com.example.trivious.navigation

import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.trivious.presentation.SignInScreen
import com.example.trivious.presentation.SignUpScreen
import com.example.trivious.presentation.TriviousConditions
import com.example.trivious.stater.pages.ContestScreen
import com.google.accompanist.navigation.animation.composable
import com.example.trivious.stater.pages.PlayScreen
import com.example.trivious.stater.pages.SplashScreen
import com.example.trivious.stater.pages.WinScreen
import com.example.trivious.ui.theme.trivious_black
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
     navHostController: NavHostController
) {


    AnimatedNavHost(navHostController, startDestination = Screen.SplashScreen.route) {

        composable(
            route = Screen.SplashScreen.route,

        ) {
SplashScreen(navController = navHostController)
        }

        composable(
            route = Screen.ContestScreen.route
        ) {

            ContestScreen(navController = navHostController)
        }

        composable(
            route = Screen.PlayScreen.route
        ) {
            PlayScreen(navController = navHostController)
        }

        composable(
            route = Screen.WinScreen.route
        ) {
            WinScreen(navController = navHostController)
        }

        composable(
            route = Screen.LogInScreen.route

        ){
           SignInScreen(navController = navHostController)
        }

        composable(
            route = Screen.SignUpScreen.route

        ){
           SignUpScreen(navController = navHostController)
        }

        composable(
            route = Screen.TermsScreen.route

        ){
            TriviousConditions()
        }






    }

}