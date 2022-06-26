package com.example.trivious.presentation.mainscreen.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.navigation.SettingScreen
import com.example.trivious.ui.theme.TriviousTheme

@Composable
fun SettingsScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp,Alignment.CenterVertically)
    ) {

        settingsList.forEach { eachItem ->

            Text(
                text = eachItem,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {


                    when (eachItem.lowercase()) {
                        "profile" -> navController.navigate(SettingScreen.ProfileScreen.route)
                        "about us" -> navController.navigate(SettingScreen.AboutUsScreen.route)
                        "how to play" -> navController.navigate(SettingScreen.HowToPlayScreen.route)
                        "support" -> navController.navigate(SettingScreen.SupportScreen.route)
                    }
                })


        }
    }
}

val settingsList = listOf(
    "Profile",
    "ABOut Us",
    "HOW TO Play",
    "SUPPOrt",
    "LOG Out"
)


@Preview
@Composable
fun SettingsPreview() {
    TriviousTheme() {
        SettingsScreen(rememberNavController())
    }

}