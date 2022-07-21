package com.example.trivious.presentation.mainscreen.board

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.trivious.presentation.mainscreen.home.academic.AcademicScreen
import com.example.trivious.presentation.mainscreen.home.entertainment.EntertainmentScreen
import com.example.trivious.presentation.mainscreen.home.live.LiveScreen
import com.example.trivious.ui.theme.bgColorEdge
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch




@Composable
fun DashboardTabLayout(

    text: String,
    selected: Boolean,
    onSelect: () -> Unit
) {


    OutlinedButton(
        onClick = onSelect ,
        border =
            BorderStroke(
                width = 2.dp,
             if (selected){
                 bgColorEdge
             }else{
                 Color.Black
             }

            ),


        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Black)
    ) {
        Text(text = text, color =   if (selected){
            bgColorEdge
        }else{
            Color.White
        } )
    }




}







