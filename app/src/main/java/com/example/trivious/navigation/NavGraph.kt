package com.example.trivious.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.trivious.presentation.login.SignInScreen
import com.example.trivious.presentation.signup.SignUpScreen
import com.example.trivious.presentation.TriviousConditions
import com.example.trivious.presentation.mainscreen.MainScreen
import com.example.trivious.stater.pages.ContestScreen
import com.google.accompanist.navigation.animation.composable
import com.example.trivious.stater.pages.PlayScreen
import com.example.trivious.stater.pages.SplashScreen
import com.example.trivious.stater.pages.WinScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation(
     navHostController: NavHostController
) {


    AnimatedNavHost(navHostController, startDestination = Screen.SplashScreen.route) {

        composable(
            route = Screen.SplashScreen.route

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

        composable(
route = Screen.MainScreen.route
        ){
           MainScreen()
        }






    }

}