package com.example.trivious.presentation.mainscreen.home.live

import android.content.Intent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.navigation.Screen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun LiveCorrectAnswer(
   viewModel: LiveViewModel = hiltViewModel(),
    navController: NavController
) {

    LiveCorrectContent(viewModel = viewModel, navController = navController)

}

@Composable
fun LiveCorrectContent(
    viewModel: LiveViewModel,
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
                text = "Correct Answer",
                style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
                color = trivious_ash
            )
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "You chose the correct answer",
                style = MaterialTheme.typography.subtitle2.copy(fontWeight = FontWeight.ExtraLight),
                color = trivious_ash
            )
            Spacer(modifier = Modifier.height(12.dp))


            Button(
                onClick = {
                   
                }, shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(), colors = ButtonDefaults.buttonColors(
                    backgroundColor = trivious_ash
                    

                )
            ){
                Text(text = viewModel.correctanswer, fontWeight = FontWeight(700))

            }

            Spacer(modifier = Modifier.height(12.dp))




        }

    }
    
    Spacer(modifier = Modifier.height(40.dp))
    
    Text(text = "You Have Won" , style = MaterialTheme.typography.h5, color = MaterialTheme.colors.primary, fontWeight = FontWeight(700))
    Text(text = "$100",style = MaterialTheme.typography.h4, color = MaterialTheme.colors.primary,fontWeight = FontWeight(700))

    Spacer(modifier = Modifier.height(40.dp))

    val context = LocalContext.current
    OutlinedButton(
        onClick = {




            val type = "text/plain"
            val subject = "Played Trivea"
            val extraText = "I just won $100 on trivea"
            val shareWith = "ShareWith"

            val intent = Intent(Intent.ACTION_SEND)
            intent.type = type
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TITLE,"Conquered Trivea")
            intent.putExtra(Intent.EXTRA_TEXT, extraText)

            ContextCompat.startActivity(
                context,
                Intent.createChooser(intent, shareWith),
                null
            )
        },
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

            navController.navigate(BottomNavScreen.Wallet.id){
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
        Text(text = "Withdraw", fontWeight = FontWeight(700))

    }




}

}



@Preview
@Composable
fun LiveCorrectAnswerPreview() {
    TriviousTheme() {
        LiveCorrectAnswer(navController = rememberNavController())

    }
}