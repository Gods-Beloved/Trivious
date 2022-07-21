package com.example.trivious.presentation.mainscreen.home.entertainment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious__ash_2

@Composable
fun EntertainmentSingleQuestionItem(modifier: Modifier = Modifier, title: String, index: Int) {
    Surface(
        modifier = modifier

            .fillMaxWidth()
            .wrapContentHeight()

            .padding(16.dp),
        border = BorderStroke(2.dp, MaterialTheme.colors.primary),
        shape = RoundedCornerShape(12.dp)
    ) {

        Column(Modifier.background(Color.White)) {
            Text(
                text = "$title Quiz",
                modifier = Modifier
                    .background(color = MaterialTheme.colors.primary)
                    .padding(6.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 24.dp)

            ) {
                Text(
                    text = "Question ${index + 1}",
                    style = MaterialTheme.typography.body1,
                    color = Color.Black
                )
                Text(
                    text = "Entry Fee:$10",
                    style = MaterialTheme.typography.body1,
                    color = Color.Black
                )
                Text(
                    text = "Win $100",
                    style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight(700)),
                    color = Color.Black
                )

            }

            Row(modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp)) {
                Button(
                    onClick = { /*TODO*/ }, modifier = Modifier
                        .weight(1f)
                        .height(50.dp), colors = ButtonDefaults.buttonColors(
                        backgroundColor = trivious__ash_2
                    ), shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Share", fontWeight = FontWeight(700))
                }
                Spacer(modifier = Modifier.width(8.dp))

                Button(
                    onClick = { /*TODO*/ },
                    Modifier
                        .weight(1f)
                        .height(50.dp), colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black
                    ), shape = RoundedCornerShape(8.dp)

                ) {
                    Text(text = "Contest", fontWeight = FontWeight(700), color = Color.White)
                }

            }

        }

    }
}

@Preview
@Composable
fun EntertainmentSingleItemPreview() {
    TriviousTheme {
        EntertainmentSingleQuestionItem(title = "Entertainment", index = 1)
    }

}
