package com.example.trivious

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import com.example.trivious.navigation.Navigation
import com.example.trivious.ui.theme.TriviousTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviousTheme(darkTheme = false) {
                val navController = rememberAnimatedNavController()


                // A surface container using the 'background' color from the theme
                Navigation(navController)

                }

            }
        }
    }





