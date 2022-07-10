package com.example.trivious.presentation.mainscreen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import com.example.trivious.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.trivious.components.TabLayout
import com.example.trivious.domain.model.ApiResponse
import com.example.trivious.domain.model.MessageBarState
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious__ash_2
import com.example.trivious.util.RequestState

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    ) {



    val user by homeViewModel.user
    val username by homeViewModel.username

    HomeContent(

        username = username ,
        profilePhoto = user?.profilePicture)

}

@Preview
@Composable
fun HomePreview() {
    TriviousTheme {
        HomeScreen()

    }
}