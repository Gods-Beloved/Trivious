package com.example.trivious.presentation.mainscreen.home.sport

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.trivious.presentation.mainscreen.home.SportSingleQuestionItem


@Composable
fun SportScreen(title: String) {


    LazyColumn(modifier = Modifier.background(Color.Black)) {
        items(8) { index ->
            SportSingleQuestionItem(title = title, index = index)
        }
    }


}