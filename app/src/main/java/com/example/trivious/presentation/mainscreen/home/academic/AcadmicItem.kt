package com.example.trivious.presentation.mainscreen.home.academic

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AcademicScreen(title: String) {


    LazyColumn(modifier = Modifier.background(Color.Black)) {
        items(8) { index ->
            AcademicSingleQuestionItem(title = title, index = index)
        }
    }


}
