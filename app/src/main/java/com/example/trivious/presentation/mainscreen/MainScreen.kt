package com.example.trivious.presentation.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.trivious.components.CustomBottomNavigation
import com.example.trivious.navigation.BottomNavigationGraph
import com.example.trivious.navigation.Screen
import com.example.trivious.ui.theme.TriviousTheme

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    showBottomBar = when (navBackStackEntry?.destination?.route) {
        Screen.ProfileScreen.route -> false // on this screen bottom bar should be hidden
        Screen.AboutUsScreen.route-> false // here too
        Screen.HowToPlayScreen.route -> false
        Screen.SupportScreen.route ->false
        Screen.LiveQuizScreen.route ->false
        Screen.LiveCorrectScreen.route -> false
        Screen.LiveWrongScreen.route -> false
        Screen.LiveTimeOutScreen.route -> false
        Screen.SportQuizScreen.route ->false
        Screen.EntertainmentQuizScreen.route ->false
        Screen.AcademicQuizScreen.route ->false
        else -> true // in all other cases show bottom bar
    }


    TriviousTheme {
        Scaffold(
            bottomBar = { if (showBottomBar) CustomBottomNavigation(navController = navController)}
        ) {
BottomNavigationGraph(navController = navController, modifier = Modifier.padding(it))
        }
        
    }




        
    }


