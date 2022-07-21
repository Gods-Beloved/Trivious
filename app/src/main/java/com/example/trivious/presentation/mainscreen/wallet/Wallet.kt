package com.example.trivious.presentation.mainscreen.wallet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun WalletScreen(
    navController: NavController
) {
    WalletContent(navController = navController)
}

@Composable
fun WalletContent(
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
                        navController.navigate(BottomNavScreen.Home.id)
                    }

            )

            Text(
                text = "Wallet", style = MaterialTheme.typography.h5.copy(
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
                .padding(top = 90.dp, start = 30.dp, end = 30.dp)
                .verticalScroll(rememberScrollState())

        ){

            Column(
                Modifier
                    .weight(4f)
                    .fillMaxWidth()) {
                Text(
                    text = "Hi James",
                    style = MaterialTheme.typography.h6.copy(
                        color = trivious_ash, fontWeight = FontWeight(700)
                    )
                )
                Text(
                    text = "What would like to do today?",
                    style = MaterialTheme.typography.subtitle2.copy(
                        color = trivious_ash, fontWeight = FontWeight(300)
                    )
                )
                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp,Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Surface (
                        color = Color.Black,
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(2.dp, trivious_ash) ,
                                modifier = Modifier
                                    .weight(1f)
                                    .size(width = 150.dp, height = 180.dp)

                            ){
                        Box (
                            modifier = Modifier.padding(16.dp)

                                ){
                            Column(
                                modifier = Modifier.align(Alignment.TopStart)
                            ) {
                                Text(

                                    text = "Account Balance",
                                    color = trivious_ash,
                                    style = MaterialTheme.typography.subtitle2

                                )
                                Text(
                                    text = "$10.00",
                                        color = trivious_ash,
                                    style = MaterialTheme.typography.h6.copy(
                                       fontWeight =  FontWeight(700)
                                    )
                                )
                                
                            }

                            OutlinedButton(
                                modifier = Modifier
                                    .align(Alignment.BottomStart) ,
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(50),
                                border = BorderStroke(2.dp,MaterialTheme.colors.primary),
                                 colors = ButtonDefaults.buttonColors(
                                     backgroundColor = Color.Black,
                                     contentColor = MaterialTheme.colors.primary
                                 )
                            ) {
                                
                                Text(text = "Deposit")

                            }


                        }

                    }
                    Surface (
                        color = Color.Black,
                        modifier = Modifier
                            .weight(1f)
                            .size(width = 150.dp, height = 180.dp),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(2.dp, trivious_ash)
                    ){
                        Box(
                            modifier = Modifier.padding(16.dp)

                        ) {
                            Column(
                                modifier = Modifier.align(Alignment.TopStart)
                            ) {
                                Text(

                                    text = "Winnings",
                                    color = trivious_ash,
                                    style = MaterialTheme.typography.subtitle2

                                )
                                Text(
                                    text = "$45.00",
                                    color = trivious_ash,
                                    style = MaterialTheme.typography.h6.copy(
                                        fontWeight =  FontWeight(700)
                                    )
                                )

                            }

                            OutlinedButton(
                                modifier = Modifier
                                    .align(Alignment.BottomStart) ,
                                onClick = { /*TODO*/ },
                                shape = RoundedCornerShape(50),
                                border = BorderStroke(2.dp, trivious_ash),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Black,
                                    contentColor = trivious_ash
                                )
                            ) {

                                Text(text = "Withdraw")

                            }


                        }

                    }
                }



            }
            Column(modifier = Modifier
                .weight(4.5f)
                .fillMaxWidth()) {
                Text("Transactions", style = MaterialTheme.typography.subtitle1, color = MaterialTheme.colors.primary, fontWeight = FontWeight(700))
                WalletTabLayout(navController = rememberNavController())
            }
            Column(
                modifier = Modifier
                    .weight(1.1f)
                    .fillMaxWidth()
            ) {

            }

        }
    }

}

@Preview
@Composable
fun WalletPreview() {
    TriviousTheme() {
        WalletScreen(navController = rememberNavController())

    }
}