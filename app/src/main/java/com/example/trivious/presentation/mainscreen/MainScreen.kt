package com.example.trivious.presentation.mainscreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.trivious.components.CustomBottomNavigation
import com.example.trivious.navigation.BottomNavigationGraph
import com.example.trivious.ui.theme.TriviousTheme

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    
    TriviousTheme {
        Scaffold(
            bottomBar = { CustomBottomNavigation(navController = navController)}
        ) {
BottomNavigationGraph(navController = navController, modifier = Modifier.padding(it))
        }
        
    }




        
    }


