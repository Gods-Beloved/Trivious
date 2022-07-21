package com.example.trivious.presentation.mainscreen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.ui.theme.TriviousTheme

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController:NavController

    ) {


    val user by homeViewModel.user
    val username by homeViewModel.username

    HomeContent(

        username = username ,
        profilePhoto = user?.profilePicture,
        navController = navController

    )

}

@Preview
@Composable
fun HomePreview() {
    TriviousTheme {
        HomeScreen(navController = rememberNavController())

    }
}