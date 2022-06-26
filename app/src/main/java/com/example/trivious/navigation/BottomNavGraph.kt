package com.example.trivious.presentation.mainscreen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.navigation.SettingsNavGraph
import com.example.trivious.presentation.mainscreen.home.HomeScreen


@Composable
fun BottomNavigationGraph(navController: NavHostController, modifier: androidx.compose.ui.Modifier) {

    NavHost(navController = navController, startDestination = BottomNavScreen.Home.id) {

        composable(route = BottomNavScreen.Home.id) {
            HomeScreen()
        }
        composable(route = BottomNavScreen.Board.id) {
            BoardScreen()
        }
        composable(route = BottomNavScreen.Wallet.id) {
            WalletScreen()
        }
        composable(route = BottomNavScreen.Settings.id) {
            SettingsNavGraph(rememberNavController())
        }

    }

}