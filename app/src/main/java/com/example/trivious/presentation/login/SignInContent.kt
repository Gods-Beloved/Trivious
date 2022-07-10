package com.example.trivious.presentation.login

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.trivious.R
import com.example.trivious.components.GoogleButton
import com.example.trivious.components.MessageBar
import com.example.trivious.domain.model.ApiResponse
import com.example.trivious.domain.model.MessageBarState
import com.example.trivious.navigation.Screen

import com.example.trivious.ui.theme.trivious_black
import com.example.trivious.ui.theme.trviaTypography
import com.example.trivious.util.RequestState
import com.example.trivious.util.SignInAuthUiEvent

@Composable
fun SignInContent(
    signedInState: Boolean,
    messageBarState: MessageBarState,
    state: ScrollState,
    signInViewModel: LoginViewModel,
    navController: NavController,
    onButtonClicked: () -> Unit
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            MessageBar(messageBarState = messageBarState)
        }

        Column(
            Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainContent(
                signedInState = signedInState,
                state = state,
                navController = navController,
                onButtonClicked = onButtonClicked,
                viewModel = signInViewModel
            )

        }

    }


}

@Composable
fun MainContent(
    signedInState: Boolean,
    modifier: Modifier = Modifier,
    state: ScrollState,
    viewModel: LoginViewModel,
    navController: NavController,
    onButtonClicked: () -> Unit
) {

    val messageBarState by viewModel.messageBarState
    val apiResponse by viewModel.apiResponse

    LaunchedEffect(apiResponse){
        when(apiResponse){
            is RequestState.Success -> {
                val response = (apiResponse as RequestState.Success<ApiResponse>).data.success
                if (response){

                    navigateToMainScreen(navController = navController)
                }
            }
            else -> {


            }
        }
    }


    var showPassword by remember { mutableStateOf(false) }
    val signInstate = viewModel.state

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        Column() {
            if (apiResponse is RequestState.Loading){
            LinearProgressIndicator(
                modifier = modifier.fillMaxWidth(),
                color = MaterialTheme.colors.primary
            )
            }
        }


    Column(
        modifier = modifier
            .fillMaxSize()
            .weight(9f)
            .verticalScroll(state)
            .padding(start = 30.dp, end = 30.dp, top = 50.dp)
    ) {

        Text(
            text = "Sign in to your account",
            style = trviaTypography.h5.copy(fontWeight = FontWeight(700))
        )
        Text(
            text = "Welcome back. New quiz questions await you with grande prizes to win. See you there champ.",
            style = trviaTypography.caption.copy()
        )
        OutlinedTextField(
            value = signInstate.signInUsername,
            onValueChange = { username ->
                viewModel.onEvent(SignInAuthUiEvent.SignInUsernameChanged(username))

            }, label = {
                Text(text = "Email|Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),

            shape = RoundedCornerShape(8.dp),
            singleLine = true

        )
        OutlinedTextField(
            value = signInstate.signInPassword,
            onValueChange = {
                    password ->
                viewModel.onEvent(SignInAuthUiEvent.SignInPasswordChanged(password))

                            },
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
                viewModel.startLoading()
                viewModel.saveSignedInState(signedIn = true)
                viewModel.onEvent(SignInAuthUiEvent.SignIn)


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

        Spacer(modifier = Modifier.height(24.dp))

        GoogleButton(
            modifier = modifier.align(Alignment.CenterHorizontally),
            loadingState = signedInState,
            onClick = onButtonClicked
        )

        OutlinedButton(
            onClick = {
                navController.navigate(route = Screen.MainScreen.route)
            }, shape = RoundedCornerShape(8.dp), modifier = modifier
                .padding(top = 8.dp, bottom = 24.dp)
                .height(50.dp)
                .width(260.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_facebook),
                tint = Color.Unspecified,
                contentDescription = "Facebook Icon",
                modifier = modifier
                    .align(alignment = Alignment.CenterVertically)
                    .size(30.dp)

            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Sign in with Facebook", color = trivious_black)
        }


    }

}
}

private fun navigateToMainScreen(
    navController: NavController
){
    navController.navigate(route = Screen.MainScreen.route){

    }
}