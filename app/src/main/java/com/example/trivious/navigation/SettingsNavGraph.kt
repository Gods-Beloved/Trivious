package com.example.trivious.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.trivious.presentation.mainscreen.settings.*

@Composable
fun SettingsNavGraph(
    navHostController: NavHostController

) {

    NavHost(navController = navHostController, startDestination = SettingScreen.SettingsMainScreen.route){

        composable(route = SettingScreen.SettingsMainScreen.route) {
            SettingsScreen(navHostController)
        }

        composable(route= SettingScreen.ProfileScreen.route){
            ProfileScreen()
        }

        composable(route= SettingScreen.ProfileScreen.route){
            ProfileScreen()
        }
        composable(route= SettingScreen.ProfileScreen.route){
            ProfileScreen()
        }
        composable(route= SettingScreen.AboutUsScreen.route){
            AboutScreen()
        }

        composable(route= SettingScreen.HowToPlayScreen.route){
            HowToPlayScreen()
        }
        composable(route= SettingScreen.SupportScreen.route){
            SupportScreen()
        }

    }

}