package com.example.trivious.presentation.mainscreen.settings

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberScrollableState
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
fun AboutScreen(
    navController: NavController
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
                text = "About Trivea", style = MaterialTheme.typography.h5.copy(
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

            Text(
                text = "TRIVEA is a live quiz mobile app, that allow " +
                        "users to play in daily live quizzes. The Quiz App helps users to expand " +
                        "their knowledge whiles winning real cash instantly",
                style = MaterialTheme.typography.h5.copy(
                    color = trivious_ash, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                )
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Every day, Quiz questions are posted on the platform " +
                        "with its contest fee and cash prize in various categories to " +
                        "choose from.", style = MaterialTheme.typography.h5.copy(
                    color = trivious_ash, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Play Trivea to see if you have what it " +
                        "takes to win real cash instantly.", style = MaterialTheme.typography.h5.copy(
                    color = trivious_ash, fontFamily = FontFamily(
                        Font(
                            R.font.bradybunch, FontWeight.Light
                        )
                    )
                )
            )
            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = "Trivea, play the Quiz win the money.", style = MaterialTheme.typography.h5.copy(
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
fun PreviewAbout() {
    TriviousTheme() {
        AboutScreen(rememberNavController())
    }


}