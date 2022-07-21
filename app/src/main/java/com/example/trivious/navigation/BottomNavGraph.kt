package com.example.trivious.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.trivious.presentation.mainscreen.board.DashboardScreen

import com.example.trivious.presentation.mainscreen.home.HomeScreen
import com.example.trivious.presentation.mainscreen.home.live.*
import com.example.trivious.presentation.mainscreen.settings.AboutScreen
import com.example.trivious.presentation.mainscreen.settings.HowToPlayScreen
import com.example.trivious.presentation.mainscreen.settings.SettingsScreen
import com.example.trivious.presentation.mainscreen.settings.SupportScreen
import com.example.trivious.presentation.mainscreen.settings.profile.ProfileScreen
import com.example.trivious.presentation.mainscreen.wallet.WalletScreen


@Composable
fun BottomNavigationGraph(navController: NavHostController, modifier: androidx.compose.ui.Modifier) {

    NavHost(navController = navController, startDestination = BottomNavScreen.Home.id) {

        composable(route = BottomNavScreen.Home.id) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomNavScreen.Board.id) {
            DashboardScreen(navController = navController)
        }
        composable(route = BottomNavScreen.Wallet.id) {
            WalletScreen(navController = navController)
        }
        composable(route = BottomNavScreen.Settings.id) {
            SettingsScreen(navController = navController)
        }

        composable(route= Screen.ProfileScreen.route){
            ProfileScreen(navController=navController)
        }

        composable(route= Screen.AboutUsScreen.route){
            AboutScreen(navController = navController)
        }

        composable(route= Screen.HowToPlayScreen.route){
            HowToPlayScreen(navController = navController)
        }

        composable(route= Screen.SupportScreen.route){
            SupportScreen(navController = navController)
        }

        composable(route= Screen.LiveQuizScreen.route){
            LiveQuizScreen(navController=navController)
        }

        composable(route= Screen.LiveCorrectScreen.route){
           LiveCorrectAnswer(navController = navController)
        }

        composable(route= Screen.LiveWrongScreen.route + "/{id}"){
            navbacstack -> val wrongAnswer = navbacstack.arguments?.getString("id").toString()
            LiveWrongAnswer(navController = navController, viewModel = LiveViewModel(), wrongAnswer = wrongAnswer)
        }

        composable(route= Screen.LivePaymentScreen.route){
            LivePaymentDialog(navController=navController, viewModel = LiveViewModel())
        }

        composable(route= Screen.LiveTimeOutScreen.route){
            LiveTimeOutScreen(navController = navController)
        }





    }

}