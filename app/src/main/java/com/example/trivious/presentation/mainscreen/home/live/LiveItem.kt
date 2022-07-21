package com.example.trivious.presentation.mainscreen.home.live

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.trivious.presentation.mainscreen.home.HomeViewModel

@Composable
fun LiveScreen(
    title: String,
    viewModel: LiveViewModel = hiltViewModel(),
    navController: NavController

) {


    LazyColumn(modifier = Modifier.background(Color.Black)) {
        items(8) { index ->
            LiveSingleQuestionItem(title = title, index = index, viewModel = viewModel, navController = navController)
        }
    }


}