package com.example.trivious.presentation.mainscreen.home.live

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.rememberNavController
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.navigation.Screen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash
import com.example.trivious.ui.theme.trivious_orange
import kotlinx.coroutines.delay


@Composable
fun LiveQuizScreen(
    navController: NavController,
    viewModel: LiveViewModel = hiltViewModel()
) {
    QuizContent(navController = navController, viewModel = viewModel)


}

@Composable
fun QuizContent(
    navController: NavController,
    viewModel: LiveViewModel
) {
    var showQuiz by remember {
        mutableStateOf(false)
    }

    val selectedOption by viewModel.selectedOption


    var ticks by remember { mutableStateOf(5) }

    var quizticks by remember { mutableStateOf(15) }

    Surface(
        color = Color.Black
    ) {

        AnimatedVisibility(visibleState = MutableTransitionState(showQuiz)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp, end = 20.dp, top = 50.dp),

                horizontalAlignment = CenterHorizontally
            ) {

                Text(
                    text = "Cash Price",
                    color = trivious_ash,
                    style = MaterialTheme.typography.h3.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400)
                    )


                )
                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Win: $100",
                    color = trivious_ash,
                    style = MaterialTheme.typography.h3.copy(
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Normal
                    )

                )
                Spacer(modifier = Modifier.height(48.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(CenterHorizontally),

                    ) {

                    val animateFloat = remember { Animatable(0f) }
                    LaunchedEffect(animateFloat) {
                        animateFloat.animateTo(
                            targetValue = 1f,
                            animationSpec = tween(durationMillis = 15000, easing = LinearEasing)
                        )
                    }
                    Box(
                        Modifier
                            .align(TopCenter)
                            .padding(top = 15.dp)

                    ) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()

                                .align(Center),
                            shape = RoundedCornerShape(16.dp),
                            border = BorderStroke(2.dp, trivious_ash),
                            color = Color.Black

                        ) {
                            Column(
                                horizontalAlignment = CenterHorizontally,
                                modifier = Modifier
                                    .wrapContentHeight()
                                    .padding(8.dp)
                            ) {
                                Spacer(modifier = Modifier.height(48.dp))

                                Text(
                                    text = "Who does a  boy become ?",
                                    color = trivious_ash,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    fontWeight = FontWeight(700),
                                    fontSize = 20.sp
                                )

                                Spacer(modifier = Modifier.height(32.dp))
                            }

                        }
                    }


                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .align(TopCenter)
                            .drawBehind {

                                drawCircle(

                                    color = trivious_ash,
                                    radius = size.width + 2.dp.toPx(),

                                    )
                                drawArc(
                                    color = Color.Black,
                                    startAngle = 0f,
                                    sweepAngle = -360f * animateFloat.value,
                                    size = Size(size.width, size.height),
                                    useCenter = false,
                                    style = Stroke(size.width)

                                )
                            }


                    ) {


                        LaunchedEffect(Unit) {
                            for (i in quizticks downTo 0) {
                                delay(1000)
                                quizticks--
                                if (quizticks == 0) {
                                    navController.navigate(Screen.LiveTimeOutScreen.route){
                                        popUpTo(BottomNavScreen.Home.id){
                                            inclusive
                                        }
                                    }

                                }

                            }




                    }
                        Text(
                            text = "$quizticks s",
                            style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.Bold),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Center)
                        )


                    }


                }
                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(8.dp)
                            .animateContentSize(),
                        horizontalAlignment = CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(4.dp, CenterVertically)


                    ) {


//

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp, CenterHorizontally)
                        ) {
                            Button(
                                onClick = {
                                    viewModel.onSelectionChange(0)
                                }, shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .wrapContentHeight(), colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (viewModel.options[0] == selectedOption) {
                                        MaterialTheme.colors.primary
                                    } else {
                                        trivious_ash
                                    }

                                )
                            ) {
                                Text(text = viewModel.options[0], fontWeight = FontWeight(700))
                            }
                            Button(
                                onClick = {
                                    viewModel.onSelectionChange(1)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .wrapContentHeight(),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (viewModel.options[1] == selectedOption) {
                                        MaterialTheme.colors.primary
                                    } else {
                                        trivious_ash
                                    }

                                )

                            ) {
                                Text(text = viewModel.options[1], fontWeight = FontWeight(700))
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp, CenterHorizontally),
                            verticalAlignment = CenterVertically
                        ) {
                            Button(
                                onClick = {
                                    viewModel.onSelectionChange(2)
                                }, shape = RoundedCornerShape(8.dp),
                                modifier = Modifier
                                    .weight(1f)
                                    .wrapContentHeight(), colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (viewModel.options[2] == selectedOption) {
                                        MaterialTheme.colors.primary
                                    } else {
                                        trivious_ash
                                    }

                                )
                            ) {
                                Text(text = viewModel.options[2], fontWeight = FontWeight(700))
                            }
                            Button(
                                onClick = {
                                    viewModel.onSelectionChange(3)
                                },
                                modifier = Modifier
                                    .weight(1f)
                                    .wrapContentHeight(),
                                shape = RoundedCornerShape(8.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = if (viewModel.options[3] == selectedOption) {
                                        MaterialTheme.colors.primary
                                    } else {
                                        trivious_ash
                                    }

                                )

                            ) {
                                Text(text = viewModel.options[3], fontWeight = FontWeight(700))
                            }
                        }


                    }

                    Spacer(modifier = Modifier.height(42.dp))



                    OutlinedButton(
                        onClick = {

                            if (viewModel.checkAnswerChosen() ) {
                                navController.navigate(Screen.LiveCorrectScreen.route) {
                                    popUpToTop(navController = navController)
                                }
                            } else {
                                navController.navigate(Screen.LiveWrongScreen.route + "/${viewModel.selectedOption.value}"  ) {
                                    popUpToTop(navController = navController)
                                }
                            }
                        },
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Black,
                            contentColor = MaterialTheme.colors.primary

                        ), border = BorderStroke(2.dp, MaterialTheme.colors.primary)

                    ) {
                        Text(text = "Submit")


                    }
                }


                Spacer(modifier = Modifier.height(16.dp))


            }

        }



        Box {
            if (!showQuiz) {

                val animateFloat = remember { Animatable(0f) }
                LaunchedEffect(animateFloat) {
                    animateFloat.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(durationMillis = 5000, easing = LinearEasing)
                    )
                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Box(modifier = Modifier
                        .size(50.dp)
                        .padding(bottom = 0.dp)

                        .drawBehind {

                            drawCircle(

                                color = trivious_orange,
                                radius = size.width,


                                )
                            drawArc(
                                color = Color.Black,
                                startAngle = 0f,
                                sweepAngle = -360f * animateFloat.value,
                                size = Size(size.width, size.height),
                                useCenter = false,
                                style = Stroke(size.width)

                            )
                        }
                        .align(CenterHorizontally)) {


                        LaunchedEffect(Unit) {
                            for (i in ticks downTo 0) {
                                delay(1000)
                                ticks--
                            }


                        }

                        if (ticks == 0) {
                            showQuiz = true
                        }
                        Text(
                            text = "$ticks s",
                            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.align(Center)
                        )


                    }

                    Text(
                        modifier = Modifier.padding(top = 40.dp),
                        text = "Loading Quiz",
                        style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                        color = trivious_ash
                    )

                    Text(
                        text = "Please wait. Setting Question",
                        style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.ExtraLight),
                        color = trivious_ash
                    )


                }


            }
        }

    }


}

fun NavOptionsBuilder.popUpToTop(navController: NavController) {
    popUpTo(navController.currentBackStackEntry?.destination?.route ?: return) {
        inclusive = true
    }
}

@Preview
@Composable
fun LiveQuizPreview() {
    TriviousTheme {
        LiveQuizScreen(navController = rememberNavController(), viewModel = LiveViewModel())

    }
}

