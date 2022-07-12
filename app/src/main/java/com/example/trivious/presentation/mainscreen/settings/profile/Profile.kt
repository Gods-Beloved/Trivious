package com.example.trivious.presentation.mainscreen.settings

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
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
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.trivious.R
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun ProfileScreen() {

    ProfileContent()

}


@Preview
@Composable
fun PreviewProfile() {
    TriviousTheme {
        ProfileScreen()
    }

}

@Composable
fun ProfileContent(
    profilePhoto: String? = null,
    username: String? = null,
    email:String = "jamesgodwillarkoh@gmail.com",
    bio:String = "I am a trivea player"

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
                    .size(40.dp)
                    .align(Alignment.TopStart)

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
                        painter = painterResource(id = R.drawable.avt3),
                        contentDescription = "profile photo",
                        contentScale = ContentScale.Crop
                    )
                }
                Box() {
                    Surface(
                        shape = RoundedCornerShape(8),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .background(Color.Transparent)
                            .padding(8.dp),


                        ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = "Edit",
                            tint = Color.Black,


                            )
                    }


                }


            }

            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "Hi $username", style = MaterialTheme.typography.h4.copy(
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
                    Text(text = email, color = trivious_ash)

                }
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
                    Text(text = email, color = trivious_ash)

                }
                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }
            Spacer(modifier = Modifier.height(8.dp))


            Column {

                    Text(text = "Game History",
                        style = MaterialTheme.typography.h5.copy(
                            fontFamily = FontFamily(
                                Font(R.font.bradybunch)
                            )
                            , color = trivious_ash
                        )
                    )



                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }
            Spacer(modifier = Modifier.height(8.dp))


            Column {

                Text(text = "Invite",
                    style = MaterialTheme.typography.h5.copy(
                        fontFamily = FontFamily(
                            Font(R.font.bradybunch)
                        )
                        , color = trivious_ash
                    )
                )



                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }
            Spacer(modifier = Modifier.height(8.dp))


            Column {

                Text(text = "Delete Account",
                    style = MaterialTheme.typography.h5.copy(
                        fontFamily = FontFamily(
                            Font(R.font.bradybunch)
                        )
                        , color = trivious_ash
                    )
                )



                Divider(modifier = Modifier
                    .fillMaxWidth()
                    .background(trivious_ash))
            }


        }


    }
}