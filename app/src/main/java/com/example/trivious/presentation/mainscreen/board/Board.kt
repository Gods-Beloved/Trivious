package com.example.trivious.presentation.mainscreen.board

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun DashboardScreen(
    navController: NavController
) {
    DashboardContent(navController = navController)
}

enum class Tab {
    Day,
    Week,
    Month,
}



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardContent(
    navController: NavController
) {
    Surface(
        color = Color.Black,
        modifier = Modifier.fillMaxSize(),



    ) {


            Box() {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = "Back Button",
                    tint = trivious_ash,
                    modifier = Modifier
                        .padding(top = 30.dp, start = 16.dp)
                        .size(30.dp)
                        .align(Alignment.TopStart)
                        .clickable {
                            navController.navigate(BottomNavScreen.Home.id)
                        }

                )

                Text(
                    text = "Leaderboard", style = MaterialTheme.typography.h5.copy(
                        fontSize= 20.sp,
                        fontWeight = FontWeight(700),
                        lineHeight = 37.5.sp
                    ), color = trivious_ash,
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .align(Alignment.TopCenter)
                )
            }
            var selectedTab by remember { mutableStateOf(Tab.Day) }
            Scaffold(
                modifier = Modifier.padding(top = 70.dp,start = 30.dp, end = 30.dp, bottom = 70.dp) ,
                topBar = {
                Row(
                    Modifier
                        .background(Color.Black)
                        .fillMaxWidth()
                        .padding(5.dp)
                    ,
                    horizontalArrangement = Arrangement.SpaceBetween

                ) {
                    Tab.values().forEach { tab ->
                        DashboardTabLayout(
                            tab.name,
                            selected = selectedTab == tab,
                            onSelect = {

                                selectedTab = tab

                            },
                        )
                    }
                }
            }) {
                when (selectedTab) {
                    Tab.Day -> TodayDashboard()
                    Tab.Week -> WeekDashboard()
                    Tab.Month -> MonthDashboard()
                }
            }









    }

}

@Preview
@Composable
fun DashboardPreview() {
    TriviousTheme() {
        DashboardScreen(navController = rememberNavController())

    }
}