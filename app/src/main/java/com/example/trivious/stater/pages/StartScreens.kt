package com.example.trivious.stater.pages


import android.view.animation.OvershootInterpolator
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.R
import com.example.trivious.navigation.Screen
import com.example.trivious.ui.theme.*
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, modifier: Modifier = Modifier) {


    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }




    // AnimationEffect
    LaunchedEffect(key1 = true) {

        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1300,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                })
        )

        delay(1800L)


        navController.navigate(Screen.ContestScreen.route){


        }
    }




    // Image
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = modifier.scale(scale.value),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,


            ) {



            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.White,
                        )
                    ) {
                        append("trivea")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = trivious_orange
                        )
                    ) {
                        append(".")
                    }

                }, style = trviaTypography.h1
            )

            Text(
                text = "Your Live Quiz App",
                style = trviaTypography.subtitle2.copy(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(400)
                ),
                color = trivious_ash
            )
        }


    }

}


@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(navController = rememberNavController())
}

@Composable
fun ContestScreen(modifier: Modifier = Modifier,navController: NavController) {

    Box {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(trivious_black)
                .padding(vertical = 35.dp, horizontal = 30.dp)
        ) {
            Column() {
                Text(

                    text = "Contest",
                    style = trviaTypography.h3,
                    color = trivious_orange
                )
                Text(
                    modifier = modifier.padding(end = 15.dp),
                    text = "Pay to contest in any quiz category and question of your choice",
                    style = trviaTypography.subtitle1,
                    color = trivious__ash_2
                )
                Spacer(modifier = modifier.height(20.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        shape = CircleShape,
                        color = trivious_orange,
                        elevation = 4.dp,
                        modifier = modifier.size(18.dp)
                    ) {}
                    Surface(
                        shape = CircleShape,
                        color = trivious_orange.copy(alpha = 0.3f),
                        elevation = 4.dp,
                        modifier = modifier
                            .padding(start = 4.dp)
                            .size(10.dp)
                    ) {}
                    Surface(
                        shape = CircleShape,
                        color = trivious_orange.copy(alpha = 0.3f),
                        elevation = 4.dp,
                        modifier = modifier
                            .padding(start = 4.dp)
                            .size(10.dp)
                    ) {}
                }

                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()){


                    Image(painter = painterResource(id = R.drawable.contestpng) ,
                        contentDescription ="orange background on context screen",
                        modifier= modifier
                            .fillMaxSize(),

                    contentScale = ContentScale.Fit
                        )




                }


            }




        }

        Row(
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(end = 30.dp, bottom = 70.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Skip", style = trviaTypography.subtitle1, color = trivious_ash)

            Spacer(modifier = Modifier.width(12.dp))

            FloatingActionButton(
                onClick = {
                          navController.navigate(Screen.PlayScreen.route)
                },
                backgroundColor = trivious_orange

            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Forward arrow")
            }
        }


    }
}


@Preview
@Composable
fun ContestPreview() {
    ContestScreen(navController = rememberNavController())

}
@Composable
fun PlayScreen(modifier: Modifier = Modifier,navController: NavController) {
    Box {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(trivious_black)
                .padding(top = 35.dp)
        ) {
            Column {
                Text(

                    text = "Play",
                    style = trviaTypography.h3,
                    color = trivious_orange,
                    modifier = modifier.padding(start = 30.dp)
                )
                Text(
                    modifier = modifier.padding(end = 45.dp,start = 30.dp),
                    text = "Play by answering only one quiz question in any category",
                    style = trviaTypography.subtitle1,
                    color = trivious__ash_2,

                )
                Spacer(modifier = modifier.height(20.dp))

                Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(start = 30.dp)) {

                    Surface(
                        shape = CircleShape,
                        color = trivious_orange.copy(alpha = 0.3f),
                        elevation = 4.dp,
                        modifier = modifier
                            .padding(end = 4.dp)
                            .size(10.dp)
                    ) {}
                    Surface(
                        shape = CircleShape,
                        color = trivious_orange,
                        elevation = 4.dp,
                        modifier = modifier.size(18.dp)
                    ) {}
                    Surface(
                        shape = CircleShape,
                        color = trivious_orange.copy(alpha = 0.3f),
                        elevation = 4.dp,
                        modifier = modifier
                            .padding(start = 4.dp)
                            .size(10.dp)
                    ) {}
                }

                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()){


                    Image(painter = painterResource(id = R.drawable.playpng) ,
                        contentDescription ="orange background on context screen",
                        modifier= modifier
                            .fillMaxSize()
                            ,
                        contentScale = ContentScale.Crop
                    )


                }


            }




        }

        Row(
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(end = 30.dp, bottom = 70.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Skip", style = trviaTypography.subtitle1, color = trivious_ash)

            Spacer(modifier = Modifier.width(12.dp))

            FloatingActionButton(
                onClick = {
                          navController.navigate(Screen.WinScreen.route)
                },
                backgroundColor = trivious_orange

            ) {
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Forward arrow")
            }
        }


    }
}

@Preview
@Composable
fun PlayPreview() {
PlayScreen(navController = rememberNavController())
}

@Composable
fun WinScreen(modifier: Modifier = Modifier,navController: NavController) {
    Box {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(trivious_black)
                .padding(top = 35.dp, end = 30.dp)
        ) {
            Column {
                Text(

                    text = "Win",
                    style = trviaTypography.h3,
                    color = trivious_orange,
                    modifier = modifier.padding(start = 30.dp)
                )
                Text(
                    modifier = modifier.padding(end = 15.dp, start = 30.dp),
                    text = "Win the amazing prize on each and every question",
                    style = trviaTypography.subtitle1,
                    color = trivious__ash_2
                )
                Spacer(modifier = modifier.height(20.dp))

                Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.padding(start = 30.dp)) {

                    Surface(
                        shape = CircleShape,
                        color = trivious_orange.copy(alpha = 0.3f),
                        elevation = 4.dp,
                        modifier = modifier
                            .padding(end = 4.dp)
                            .size(10.dp)
                    ) {}

                    Surface(
                        shape = CircleShape,
                        color = trivious_orange.copy(alpha = 0.3f),
                        elevation = 4.dp,
                        modifier = modifier
                            .padding(end = 4.dp)
                            .size(10.dp)
                    ) {}
                    Surface(
                        shape = CircleShape,
                        color = trivious_orange,
                        elevation = 4.dp,
                        modifier = modifier.size(18.dp)
                    ) {}
                }
                Spacer(modifier = modifier.height(20.dp))


                Box(
                    Modifier
                        .weight(1f)
                        .fillMaxSize()){


                    Image(painter = painterResource(id = R.drawable.win) ,
                        contentDescription ="orange background on context screen",
                        modifier= modifier
                            .fillMaxSize()
                            .align(Alignment.TopCenter),
                        contentScale = ContentScale.Crop
                    )


                }


            }




        }

        Box(
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(end = 30.dp, bottom = 70.dp),

        ) {

            Button(onClick = { /*TODO*/ },
                enabled=false,
                shape = RoundedCornerShape(50),
            modifier = modifier.height(45.dp),
                elevation = ButtonDefaults.elevation(0.dp),
                colors = ButtonDefaults.buttonColors(
                    disabledBackgroundColor = trivious_orange,

                )
                ) {
                Text(text = "Sign Up")
                Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Forward arrow")

            }

            Button(onClick = {
                             navController.navigate(Screen.LogInScreen.route)
            },
                shape = RoundedCornerShape(50),
                border= BorderStroke(2.dp, trivious_black),
                modifier = modifier
                    .height(45.dp)
                    .offset(x = 3.dp, y = (-3).dp),
                elevation = ButtonDefaults.elevation(0.dp),

                colors = ButtonDefaults.buttonColors(
                    backgroundColor = trivious_orange,
                    contentColor = trivious_black,

                )
            ) {
                Text(text = "Sign Up")
                Icon(imageVector = Icons.Default.ArrowForward,
                    contentDescription = "Forward arrow", tint = trivious_black)

            }
        }


    }
}

@Preview
@Composable
fun WinPreview() {
    TriviousTheme {
        WinScreen(navController = rememberNavController())

    }
}