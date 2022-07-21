package com.example.trivious.presentation.mainscreen.home.live

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.trivious.R
import com.example.trivious.components.extractData
import com.example.trivious.navigation.Screen
import com.example.trivious.presentation.signup.SignUpViewModel
import com.example.trivious.ui.theme.trivious_ash
import com.example.trivious.ui.theme.trivious_orange
import kotlinx.coroutines.delay
import java.util.EnumSet.range
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LivePaymentDialog(
    viewModel: LiveViewModel,
    navController: NavController,

) {


    val visible by remember {
        mutableStateOf(viewModel.showDialog)
    }
        val isPaid by remember {
        mutableStateOf(viewModel.isSuccess)
    }
        val isFailed by remember {
        mutableStateOf(viewModel.isFailed)
    }
    val isLoading by remember {
        mutableStateOf(viewModel.showLoading)
    }





    if (visible.value) {
        BackHandler(true) {

        }
        Dialog(
            onDismissRequest = {
               viewModel.closeDialogWindow()
            },



            properties = DialogProperties(
                dismissOnClickOutside = false,

                )

        ) {
            Surface(
                shape = RoundedCornerShape(32.dp),
                color = Color.Black,
                border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                modifier = Modifier.size(width = 290.dp, height = 185.dp)
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                )

                {
                    Text(
                        text = "Entry Deduction", style = MaterialTheme.typography.h5.copy(
                            color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                                Font(
                                    R.font.bradybunch, FontWeight.Light
                                )
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "We are deducting an entry fee of \$10 " +
                                "from your account",
                        style = MaterialTheme.typography.subtitle2,
                        color = trivious_ash,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))


                    OutlinedButton(
                        onClick = {
                            viewModel.closeDialogWindow()
                                  viewModel.checkValue()
                        },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = trivious_ash,
                            backgroundColor = Color.Black

                        ),
                        border = BorderStroke(1.dp, trivious_ash),
                        modifier = Modifier.fillMaxWidth()


                    ) {
                        Text(text = "Continue", fontWeight = FontWeight.SemiBold)

                    }


                }


            }
        }
    }

    if (isPaid.value) {
        BackHandler(true) {

        }
        Dialog(
            onDismissRequest = {
               viewModel.closePaymentOkWindow()
            },


            properties = DialogProperties(
                dismissOnClickOutside = false,

                )

        ) {
            Surface(
                shape = RoundedCornerShape(32.dp),
                color = Color.Black,
                border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                modifier = Modifier
                    .width(width = 290.dp)
                    .height(185.dp)
                    .animateContentSize()
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .padding(16.dp)
                        .animateContentSize()
                )

                {
                    Text(
                        text = "Payment Successful", style = MaterialTheme.typography.h5.copy(
                            color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                                Font(
                                    R.font.bradybunch, FontWeight.Light
                                )
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Your entry fee payment was successful. " +
                                "Continue to play Quiz.",
                        style = MaterialTheme.typography.subtitle2,
                        color = trivious_ash,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                        Button(
                            onClick = {
                                viewModel.closePaymentOkWindow()
                             navController.navigate(Screen.LiveQuizScreen.route)


                            },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(50)
                        ) {

                            Text(text = "Continue", fontWeight = FontWeight.SemiBold)
                        }




                }


            }
        }
    }

    if (isFailed.value) {
        Dialog(
            onDismissRequest = {
               viewModel.closePaymentErrorWindow()
            },


            properties = DialogProperties(
                dismissOnClickOutside = false,

                )

        ) {
            Surface(
                shape = RoundedCornerShape(32.dp),
                color = Color.Black,
                border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                modifier = Modifier.size(width = 290.dp, height = 185.dp)
            ) {

                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                )

                {
                    Text(
                        text = "Insufficient Balance!", style = MaterialTheme.typography.h5.copy(
                            color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                                Font(
                                    R.font.bradybunch, FontWeight.Light
                                )
                            )
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "You have insufficient balance in your" +
                                " account. Top up to continue.",
                        style = MaterialTheme.typography.subtitle2,
                        color = trivious_ash,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(12.dp))



                    OutlinedButton(
                        onClick = {
                            viewModel.checkValue()
                        },
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = trivious_ash,
                            backgroundColor = Color.Black

                        ),
                        border = BorderStroke(1.dp, trivious_ash),
                        modifier = Modifier.fillMaxWidth()


                    ) {
                        Text(text = "Deposit", fontWeight = FontWeight.SemiBold)

                    }


                }


            }
        }
    }






}
