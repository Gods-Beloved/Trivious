package com.example.trivious.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.R
import com.example.trivious.navigation.Screen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_black
import com.example.trivious.ui.theme.trviaTypography

@Composable
fun SignInScreen(modifier: Modifier = Modifier,navController: NavController) {
    val scrollState = rememberScrollState()


    SignInForm(state = scrollState, navController = navController)


}

@Composable
fun SignInForm(
    modifier: Modifier = Modifier,
    state: ScrollState,
    navController: NavController
    ) {

    var emailValue by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var showPassword by remember { mutableStateOf(false) }



    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(state)
            .padding(start = 30.dp, end = 30.dp, top = 30.dp)
    ) {

        Text(
            text = "Sign in to your account",
            style = trviaTypography.h5.copy(fontWeight = FontWeight(700))
        )
        Text(
            text = "Welcome back. New quiz questions await you with grande prizes to win. See you there champ.",
            style = trviaTypography.caption.copy()
        )
        OutlinedTextField(value = emailValue, onValueChange = {
            emailValue = it
        }, label = {
            Text(text = "Email")
        },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),

            shape = RoundedCornerShape(8.dp),
            singleLine = true

        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()

                .padding(top = 8.dp),
            label = {
                Text("Password")

            },
            shape = RoundedCornerShape(8.dp),
            trailingIcon = {
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            imageVector = Icons.Filled.Visibility,
                            contentDescription = null
                        )
                    }
                } else {
                    IconButton(onClick = { showPassword = true }) {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = null
                        )
                    }
                }

            },

            singleLine = true,


            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            }


        )

        Text(
            text = "Forgot Password?",
            textAlign = TextAlign.Right,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            style = MaterialTheme.typography.caption,
            color = Color(0f, 0f, 0f, 0.5f)
        )

        Button(
            onClick = {
                navController.navigate(Screen.SignUpScreen.route)

            }, shape = RoundedCornerShape(8.dp), modifier = modifier
                .padding(top = 32.dp)
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(text = "Sign In")
        }

        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 13.sp
                    )
                ) {
                    append("Not having an account?")

                }
                withStyle(
                    style = SpanStyle(

                        color = MaterialTheme.colors.primary,
                        fontSize = 13.sp
                    )
                ) {
                    append(" Sign Up")
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 12.dp)
                .clickable(
                    indication = rememberRipple(color = Color.White),
                    onClick = {
                        navController.navigate(Screen.SignUpScreen.route)
                    },
                    interactionSource = remember { MutableInteractionSource() }
                ),
            textAlign = TextAlign.Center,

            )

        Text(
            text = "or",
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.caption
        )

        OutlinedButton(
            onClick = { /*TODO*/ }, shape = RoundedCornerShape(8.dp), modifier = modifier
                .padding(top = 32.dp)
                .height(50.dp)
                .width(230.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_google_icon),
                tint = Color.Unspecified,
                contentDescription = "Google Icon",
                modifier= modifier
                    .align(alignment = Alignment.CenterVertically)
                    .size(30.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Text(text = "Sign in with Google", color = trivious_black)
        }

        OutlinedButton(
            onClick = { /*TODO*/ }, shape = RoundedCornerShape(8.dp), modifier = modifier
                .padding(top = 8.dp, bottom = 24.dp)
                .height(50.dp)
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_facebook),
                tint = Color.Unspecified,
                contentDescription = "Facebook Icon",
                modifier= modifier
                    .align(alignment = Alignment.CenterVertically)
                    .size(30.dp)

            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Sign in with Facebook", color = trivious_black)
        }


    }
}

@Preview(widthDp = 400)
@Composable
fun SignInScreenPreview() {
    TriviousTheme() {
        SignInScreen(navController = rememberNavController())
    }

}