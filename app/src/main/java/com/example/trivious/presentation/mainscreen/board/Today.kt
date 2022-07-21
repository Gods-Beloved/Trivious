package com.example.trivious.presentation.mainscreen.board

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.trivious.R
import com.example.trivious.presentation.mainscreen.wallet.SingleDeposit
import com.example.trivious.presentation.mainscreen.wallet.SingleWithdrawal
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun TodayDashboard() {
    TodayContent()
}

@Composable
fun TodayContent(
    profilePhoto: String? = null,

    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        val quizorder = listOf(

            DummyData(
                "Kofi Mensah",
                1200
            ),
            DummyData(
                "John Doe",
                680
            ),
            DummyData(
                "Katherina",
                413
            ),
        )

        LazyColumn() {
          items(   1){
              TodayTopThree()
          }

        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn() {
            items(quizorder) { index ->
                Spacer(modifier = Modifier.height(12.dp))
                TodayFullLeaderBoard(
                    index = quizorder.indexOf(index)+4,
                    name = index.name ,
                    amount = index.amount ,
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

        }


    }
}


@Composable
fun TodayTopThree(
    profilePhoto: String? = null,
) {

    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Row(
            modifier = Modifier
                .background(Color.Black)
                .align(Alignment.Center)
                .padding(top = 38.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(60.dp, Alignment.CenterHorizontally)
        ) {
            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "2nd",
                    color = trivious_ash,
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight(700))
                )
                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.Transparent),
                    border = BorderStroke(2.dp, MaterialTheme.colors.primary)

                ) {


                    if (profilePhoto != null) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(profilePhoto)
                                .crossfade(durationMillis = 1000)
                                .placeholder(drawableResId = R.drawable.ic_placeholder)
                                .transformations(CircleCropTransformation())
                                .build(),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Profile Photo"
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.esinam),
                            contentDescription = "profile photo",
                            contentScale = ContentScale.Crop
                        )
                    }


                }
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "@Esinam",
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight(700)),
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = "$1500",
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.caption
                )
            }

            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "3rd",
                    color = trivious_ash,
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight(700))
                )
                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.Transparent),
                    border = BorderStroke(2.dp, MaterialTheme.colors.primary)

                ) {


                    if (profilePhoto != null) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(profilePhoto)
                                .crossfade(durationMillis = 1000)
                                .placeholder(drawableResId = R.drawable.ic_placeholder)
                                .transformations(CircleCropTransformation())
                                .build(),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Profile Photo"
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.sara),
                            contentDescription = "profile photo",
                            contentScale = ContentScale.Crop
                        )
                    }


                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "@Sarah",
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight(700)),
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = "$1700",
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.caption
                )
            }


        }
        Box(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.king),
                    contentDescription = "leader",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(40.dp)
                )
                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Transparent),
                    border = BorderStroke(4.dp, Color.Black)

                ) {


                    if (profilePhoto != null) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(profilePhoto)
                                .crossfade(durationMillis = 1000)
                                .placeholder(drawableResId = R.drawable.ic_placeholder)
                                .transformations(CircleCropTransformation())
                                .build(),
                            contentScale = ContentScale.Crop,
                            contentDescription = "Profile Photo"
                        )
                    } else {
                        Image(
                            painter = painterResource(id = R.drawable.resize2),
                            contentDescription = "profile photo",
                            contentScale = ContentScale.Crop
                        )
                    }


                }

                Text(
                    text = "@James",
                    style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight(700)),
                    color = MaterialTheme.colors.primary
                )
                Text(
                    text = "$2000",
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.caption
                )
            }

        }

    }


}


@Preview
@Composable
fun TopThreePreview() {
    TriviousTheme() {
        TodayTopThree()
    }

}

@Composable
fun TodayFullLeaderBoard(
    index:Int,
    name: String,
    amount:Int

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(start = 5.dp)
            .background(Color.Black)
    ) {
        Text(text = "$index.", color = trivious_ash, fontWeight = FontWeight(700))
        Spacer(modifier = Modifier.width(16.dp))
        Surface(
            shape = RoundedCornerShape(40.dp),
            color = trivious_ash,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Row(
                modifier = Modifier.padding(end = 30.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Surface(
                    shape = CircleShape,
                    modifier = Modifier
                        .size(50.dp)
                        .background(Color.Transparent),


                    ) {

                    Image(
                        painter = painterResource(id = R.drawable.ghflag),
                        contentDescription = "profile photo",
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = "@$name",
                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight(700)),
                    color = Color.Black
                )

                Text(
                    text = "\$${amount}",
                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight(700)),
                    color = Color.Black
                )

            }

        }
    }


}

@Preview
@Composable
fun FullLeaderBoardPreview() {
    TriviousTheme() {
        TodayFullLeaderBoard(4,"James Godwill",100)
    }

}

@Preview
@Composable
fun TodayPreview() {
    TriviousTheme() {
        TodayDashboard()

    }
}