package com.example.trivious.presentation.mainscreen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.trivious.R
import com.example.trivious.components.TabLayout
import com.example.trivious.ui.theme.trivious__ash_2
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun HomeContent(

    username: String,
    profilePhoto: String?,
    navController:NavController

    ){


    Column(
        modifier = Modifier
            .fillMaxSize(),

        ) {

        Column {

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
                                .background(Color.Transparent)
                                .align(Alignment.CenterStart),
                            border = BorderStroke(1.dp, MaterialTheme.colors.primary)

                        ) {
                            
                            if (profilePhoto != null){
                                AsyncImage(
                                    model = ImageRequest.Builder(LocalContext.current)
                                        .data(profilePhoto)
                                        .crossfade(durationMillis = 1000)
                                        .placeholder(drawableResId = R.drawable.ic_placeholder)
                                        .transformations(CircleCropTransformation())
                                        .build()
                                    ,
                                    contentScale = ContentScale.Crop,
                                    contentDescription = "Profile Photo"
                                )   
                            }else{
                                Image(
                                    painter = painterResource(id = R.drawable.resize2),
                                    contentDescription = "profile photo",
                                    contentScale = ContentScale.Crop
                                )
                            }

                        
                        }

                        Text(
                            text = "trivea.", style = MaterialTheme.typography.h3.copy(fontSize = 40.sp), modifier = Modifier
                                .align(
                                    Alignment.Center
                                )
                                .fillMaxWidth(), textAlign = TextAlign.Center, color = trivious_ash

                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Hi James",
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

                    TabLayout(navController = navController)

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

}