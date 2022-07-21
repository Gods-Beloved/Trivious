package com.example.trivious.presentation.mainscreen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.R
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun HowToPlayScreen(
    navController:NavController
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black

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
                        navController.navigate(BottomNavScreen.Settings.id)
                    }

            )

            Text(
                text = "How To Play", style = MaterialTheme.typography.h5.copy(
                    fontSize= 20.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 37.5.sp
                ), color = trivious_ash,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.TopCenter)
            )
        }
        Column(

            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 100.dp, start = 30.dp, end = 30.dp)
                .verticalScroll(rememberScrollState())

        ) {
            Text(text = "STEP 1 (SCAN QUIZ)",     style = MaterialTheme.typography.h5.copy(
                color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                    Font(
                        R.font.bradybunch, FontWeight.Light
                    )
                )
            ))

            Text(
                text = "Look through the daily quiz posted on the platform in each category.",
                style = MaterialTheme.typography.h5.copy(
                    color = trivious_ash, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                )
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "STEP 2 (SELECT QUIZ)",
                style = MaterialTheme.typography.h5.copy(
                color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                    Font(
                        R.font.bradybunch, FontWeight.Light
                    )
                )
            ))

            Text(
                text = "Select the quiz question you want to play and contest.",
                style = MaterialTheme.typography.h5.copy(
                    color = trivious_ash, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                )
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "STEP 3 (CONTEST)",
                style = MaterialTheme.typography.h5.copy(
                    color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                ))

            Text(
                text = "Pay the contest fee to enter the quiz zone.",
                style = MaterialTheme.typography.h5.copy(
                    color = trivious_ash, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                )
            )


            Spacer(modifier = Modifier.height(16.dp))

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "STEP 4 (ANSWER AND WIN)",
                style = MaterialTheme.typography.h5.copy(
                    color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                ))

            Text(
                text = "Answer one quiz question and win the cash prize on it instantly.",
                style = MaterialTheme.typography.h5.copy(
                    color = trivious_ash, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                )
            )



        }
    }



}


@Preview
@Composable
fun PreviewHowToPlay() {
    TriviousTheme() {
        HowToPlayScreen(rememberNavController())
    }

}