package com.example.trivious.presentation.mainscreen.settings.profile

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.trivious.R
import com.example.trivious.components.DisplayAlertDialog
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@Composable
fun ProfileScreen(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    navController: NavController
) {

    val user by profileViewModel.user

    ProfileContent(
        navController = navController,
        profilePhoto = user?.profilePicture,
        username = user?.username,
        email = user?.email,
        bio = user?.bioData


    )

}


@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun PreviewProfile() {
    TriviousTheme {
        ProfileScreen(navController = rememberAnimatedNavController())
    }

}

@Composable
fun ProfileContent(
    navController: NavController,
    profilePhoto: String?,
    username: String? ,
    email:String?,
    bio:String?

) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
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
                        navController.navigate(BottomNavScreen.Settings.id)
                    }

            )


        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)

        ) {
            Text(
                text = "User Profile", style = MaterialTheme.typography.h5.copy(
                    fontSize= 20.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 37.5.sp
                ), color = trivious_ash
            )

            Spacer(modifier = Modifier.height(46.dp))

            Surface(
                shape = RoundedCornerShape(24),
                modifier = Modifier
                    .size(120.dp)
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
                        painter = painterResource(id = R.drawable.resize2),
                        contentDescription = "profile photo",
                        contentScale = ContentScale.Crop
                    )
                }


            }

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "James Godwill", style = MaterialTheme.typography.h4.copy(
                    fontFamily = FontFamily(
                        Font(R.font.bradybunch)
                    ), color = MaterialTheme.colors.primary
                )
            )

            Text(text = "Ghana", style = MaterialTheme.typography.subtitle2, color = trivious_ash)
            Spacer(modifier = Modifier.height(8.dp))

            Column(
                modifier = Modifier.verticalScroll(rememberScrollState()),

                ) {
                Column(
                    modifier = Modifier.horizontalScroll(rememberScrollState()),

                ) {
                    Text(text = "Email:",
                        style = MaterialTheme.typography.h5.copy(
                            fontFamily = FontFamily(
                                Font(R.font.bradybunch)
                            )
                        , color = trivious_ash
                        )
                    )
                    Text(text = "Jamesgodwillarkoh@gmail.com" , color = trivious_ash)

                }
                Spacer(modifier = Modifier.height(6.dp))
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }
            Spacer(modifier = Modifier.height(8.dp))

            Column {
                Column(
                    modifier = Modifier.verticalScroll(rememberScrollState()),

                    ) {
                    Text(text = "Bio:",
                        style = MaterialTheme.typography.h5.copy(
                            fontFamily = FontFamily(
                                Font(R.font.bradybunch)
                            )
                            , color = trivious_ash
                        )
                    )
                    Text(text = "Trivios App Player", color = trivious_ash)

                }
                Spacer(modifier = Modifier.height(6.dp))
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }
            Spacer(modifier = Modifier.height(6.dp))


            Column {

                    Text(text = "Game History",
                        style = MaterialTheme.typography.h5.copy(
                            fontFamily = FontFamily(
                                Font(R.font.bradybunch)
                            )
                            , color = trivious_ash
                        )
                    )
                Spacer(modifier = Modifier.height(6.dp))



                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }
            Spacer(modifier = Modifier.height(6.dp))


            Column {

                Text(text = "Invite",
                    style = MaterialTheme.typography.h5.copy(
                        fontFamily = FontFamily(
                            Font(R.font.bradybunch)
                        )
                        , color = trivious_ash
                    )
                )


                Spacer(modifier = Modifier.height(6.dp))
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }
            Spacer(modifier = Modifier.height(6.dp))

            var visible by remember { mutableStateOf(false) }



            Column {


                Text(text = "Delete Account",
                    style = MaterialTheme.typography.h5.copy(
                        fontFamily = FontFamily(
                            Font(R.font.bradybunch)
                        )
                        , color = trivious_ash
                    ), modifier = Modifier.clickable {

                        visible = true
                    }
                )
                
               

                Spacer(modifier = Modifier.height(6.dp))
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }

            if (visible) {
                Dialog(
                    onDismissRequest = {
                        visible = false
                    },


                    properties = DialogProperties(
                        dismissOnClickOutside = false,

                        )

                ) {
                    Surface(
                        shape = RoundedCornerShape(32.dp),
                        color = Color.Black,
                        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                        modifier = Modifier.size(250.dp)
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(16.dp)
                        )

                        {
                            Text(
                                text = "Delete Account", style = MaterialTheme.typography.h5.copy(
                                    color = MaterialTheme.colors.primary, fontFamily = FontFamily(
                                        Font(
                                            R.font.bradybunch, FontWeight.Light
                                        )
                                    )
                                )
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Are you sure you want to delete your account?",
                                style = MaterialTheme.typography.subtitle2,
                                color = trivious_ash,
                                textAlign = TextAlign.Center
                            )
                            Spacer(modifier = Modifier.height(12.dp))


                            OutlinedButton(
                                onClick = {
                                    visible = false
                                },
                                shape = RoundedCornerShape(50),
                                colors = ButtonDefaults.outlinedButtonColors(
                                    contentColor = trivious_ash,
                                    backgroundColor = Color.Black

                                ),
                                border = BorderStroke(1.dp, trivious_ash),
                                modifier = Modifier.fillMaxWidth()


                            ) {
                                Text(text = "Yes! I want to ", fontWeight = FontWeight.SemiBold)

                            }
                            Spacer(modifier = Modifier.height(8.dp))


                            Button(
                                onClick = { visible = false },
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(50)
                            ) {

                                Text(text = "No! More Fun", fontWeight = FontWeight.SemiBold)
                            }


                        }


                    }
                }
            }



        }


    }
}