package com.example.trivious.presentation.mainscreen.settings

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.R
import com.example.trivious.components.extractData
import com.example.trivious.navigation.Screen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun SettingsScreen(navController: NavController) {

    var visible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp, Alignment.CenterVertically)
    ) {

        settingsList.forEach { eachItem ->

            Text(
                text = eachItem,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.primary,
                modifier = Modifier.clickable {


                    when (eachItem.lowercase()) {
                        "profile" -> navController.navigate(Screen.ProfileScreen.route)
                        "about us" -> navController.navigate(Screen.AboutUsScreen.route)
                        "how to play" -> navController.navigate(Screen.HowToPlayScreen.route)
                        "support" -> navController.navigate(Screen.SupportScreen.route)
                        "log out" -> visible = true
                    }
                })


        }
    }

    if (visible) {
        Dialog(
            onDismissRequest = {
                visible = false
            },


            properties = DialogProperties(
                dismissOnClickOutside = false,

                )

        ) {
            Surface(
                shape = RoundedCornerShape(32.dp),
                color = Color.Black,
                border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                modifier = Modifier.size(250.dp)
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                )

                {
                    Text(
                        text = "Log Out", style = MaterialTheme.typography.h5.copy(
                            color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                                Font(
                                    R.font.bradybunch, FontWeight.Light
                                )
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Are you sure you want to log out of the fun?",
                        style = MaterialTheme.typography.subtitle2,
                        color = trivious_ash,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))


                    OutlinedButton(
                        onClick = {
                            visible = false
                        },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = trivious_ash,
                            backgroundColor = Color.Black

                        ),
                        border = BorderStroke(1.dp, trivious_ash),
                        modifier = Modifier.fillMaxWidth()


                    ) {
                        Text(text = "Yes! I want to ", fontWeight = FontWeight.SemiBold)

                    }
                    Spacer(modifier = Modifier.height(8.dp))


                    Button(
                        onClick = { visible = false },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(50)
                    ) {

                        Text(text = "No! More Fun", fontWeight = FontWeight.SemiBold)
                    }


                }


            }
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