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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.trivious.components.TabLayout
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious__ash_2

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {

        Column(
            Modifier
                .weight(2.9F)
                .background(color = Color.Black)
                .fillMaxWidth(),

            ) {

            Box(modifier = Modifier.padding(top = 6.dp)) {
                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 8.dp)
                        .size(40.dp)
                        .align(Alignment.CenterStart),
                    border = BorderStroke(1.dp,MaterialTheme.colors.primary)

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.black),
                        contentDescription = "profile photo",
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = "trivea.", style = MaterialTheme.typography.h3.copy(fontSize = 40.sp), modifier = Modifier
                        .align(
                            Alignment.Center
                        )
                        .fillMaxWidth(), textAlign = TextAlign.Center, color = trivious__ash_2

                )
            }
            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = "Hi Godwill",
                color = trivious__ash_2,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.subtitle1.copy(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700)
                )
            )

            Text(text = "Contest | Play | Win",
                color = trivious__ash_2,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.subtitle2.copy(
                    fontWeight = FontWeight(400)
                )
            )


        }
        Column(
            Modifier
                .weight(6.1F)
                .fillMaxWidth()
        ) {

            TabLayout()

        }
        Column(
            Modifier
                .weight(0.8F)
                .background(Color.Black)
                .fillMaxWidth()
        ) {

        }


    }


}

@Preview
@Composable
fun HomePreview() {
    TriviousTheme {
        HomeScreen()

    }
}