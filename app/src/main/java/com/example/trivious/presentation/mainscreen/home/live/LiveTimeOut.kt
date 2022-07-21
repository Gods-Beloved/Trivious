package com.example.trivious.presentation.mainscreen.home.live


import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash
import com.example.trivious.ui.theme.trivious_orange

@Composable
fun LiveTimeOutScreen(
    //viewModel: LiveViewModel = hiltViewModel(),
    navController: NavController
) {

    LiveTimeOutContent(navController = navController)

}

@Composable
fun LiveTimeOutContent(
    navController: NavController
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Surface(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .width(width = 300.dp)
                .wrapContentHeight()
            ,
            shape = RoundedCornerShape(32.dp),
            color = Color.Black,
            border = BorderStroke(2.dp, trivious_ash)

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                modifier = Modifier
                    .animateContentSize()
                    .padding(12.dp)
            ) {
                Text(
                    modifier = Modifier.padding(top = 30.dp),
                    text = "Time's Up!",
                    style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                    color = trivious_ash
                )
                Spacer(modifier = Modifier.height(18.dp))

                Text(
                    text = "Oooopsy! Your Time is Up.",
                    style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.ExtraLight),
                    color = trivious_ash
                )
                Spacer(modifier = Modifier.height(12.dp))

                Column(

                    modifier = Modifier
                        .padding(top = 16.dp, bottom = 10.dp)
                        .size(25.dp)
                        .drawBehind {

                            drawCircle(

                                color= trivious_ash,
                                radius = size.width ,
                                style = Stroke(width = 2.dp.toPx())

                                )

                        },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center


                ){
                    Text(
                        text = "0 s",
                        style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Bold),
                        color = trivious_ash,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }



                Spacer(modifier = Modifier.height(12.dp))




            }

        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(text = "You Lose!" , style = MaterialTheme.typography.h5, color = MaterialTheme.colors.primary, fontWeight = FontWeight(700))

        Spacer(modifier = Modifier.height(40.dp))


        OutlinedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Black,
                contentColor = trivious_ash

            ), border = BorderStroke(2.dp, trivious_ash)

        ) {
            Text(text = "Share")
        }

        Spacer(modifier = Modifier.height(12.dp))


        Button(
            onClick = {

                navController.navigate(BottomNavScreen.Home.id){
                    popUpTo(BottomNavScreen.Home.id){
                        inclusive
                    }
                }

            }, shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(), colors = ButtonDefaults.buttonColors(



            )
        ){
            Text(text = "Retry", fontWeight = FontWeight(700))

        }




    }

}



@Preview
@Composable
fun LiveTimeOutPreview() {
    TriviousTheme() {
        LiveTimeOutScreen(navController = rememberNavController())

    }
}