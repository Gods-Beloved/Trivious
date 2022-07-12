package com.example.trivious.presentation.signup

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.R
import com.example.trivious.components.MessageBar
import com.example.trivious.components.ShowTermsAndConditionsDialog
import com.example.trivious.domain.model.ApiResponse
import com.example.trivious.navigation.Screen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_orange
import com.example.trivious.ui.theme.trviaTypography
import com.example.trivious.util.RequestState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel:SignUpViewModel = hiltViewModel()

) {
    val scrollState = rememberScrollState()



    SignUpForm(state = scrollState, navController = navController, viewModel = viewModel)


}

@Composable
fun SignUpForm(
    modifier: Modifier = Modifier,
    state: ScrollState,
    navController: NavController,
    viewModel: SignUpViewModel

    ) {





    val signUpstate = viewModel.state

    val messageBarState by viewModel.messageBarState
    val apiResponse by viewModel.apiResponse
    val checked by viewModel.checked







    var showPassword by remember { mutableStateOf(false) }



    Column(
        modifier = modifier
            .fillMaxSize()

    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            MessageBar(messageBarState = messageBarState)
        }



            LaunchedEffect(apiResponse){
                when(apiResponse){
                    is RequestState.Success -> {
                        val response = (apiResponse as RequestState.Success<ApiResponse>).data.success
                        if (response){

                            navigateToLoginScreen(navController = navController)
                        }else{

                        }
                    }
                    else -> {

                    }
                }
            }


        if (apiResponse is RequestState.Loading){
            LinearProgressIndicator(
                modifier = modifier.fillMaxWidth(),
                color = MaterialTheme.colors.primary
            )
        }


            Column(

                modifier = Modifier
                    .animateContentSize()
                    .fillMaxSize()
            ) {



                Column(
                    modifier = modifier
                        .verticalScroll(state)
                        .weight(9F)
                        .padding(30.dp, end = 30.dp, top = 30.dp),
                ) {


                    Text(
                        text = "Sign Up",
                        style = trviaTypography.h5.copy(fontWeight = FontWeight(700))
                    )
                    Text(
                        text = "Be a part of the trivia quiz app where making money just gets bigger and better. Lets get started.",
                        style = trviaTypography.caption.copy()
                    )
                    OutlinedTextField(value = signUpstate.signUpUsername,
                        onValueChange = { username ->
                            viewModel.onEvent(SignUpAuthUiEvent.SignUpUsernameChanged(username))
                        },
                        label = {
                            Text(text = "Username")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp),

                        shape = RoundedCornerShape(8.dp),
                        singleLine = true

                    )

                    Row(
                        modifier = Modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(value = " +233", onValueChange = {

                        }, label = {
                            Text(text = "Country")
                        },
                            shape = RoundedCornerShape(8.dp),
                            singleLine = true,
                            modifier = modifier
                                .width(100.dp)
                                .padding(end = 8.dp),
                            enabled = false,
                            readOnly = true
                        )

                        OutlinedTextField(value = signUpstate.signUpPhoneNumber,
                            onValueChange = { phoneNumber ->
                                viewModel.onEvent(SignUpAuthUiEvent.SignUpPhoneChanged(phoneNumber))
                            },
                            label = {
                                Text(text = "Phone Number")
                            },
                            shape = RoundedCornerShape(8.dp),
                            singleLine = true,
                            modifier = modifier
                                .weight(1f)
                                .fillMaxWidth()
                        )

                    }
                    OutlinedTextField(value = signUpstate.signUpEmail, onValueChange = { email ->
                        viewModel.onEvent(SignUpAuthUiEvent.SignUpEmailChanged(email))
                    }, label = {
                        Text(text = "Email")
                    },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp),

                        shape = RoundedCornerShape(8.dp),
                        singleLine = true

                    )

                    OutlinedTextField(
                        value = signUpstate.signUpPassword,
                        onValueChange = { password ->
                            viewModel.onEvent(SignUpAuthUiEvent.SignUpPasswordChanged(password))
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

                    OutlinedTextField(
                        value = signUpstate.signUpConfirmPassword,
                        onValueChange = { confirmPassword ->
                            viewModel.onEvent(
                                SignUpAuthUiEvent.SignUpConfirmPasswordChanged(
                                    confirmPassword
                                )
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()

                            .padding(top = 8.dp),
                        label = {
                            Text("Confirm Password")

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



                    Button(
                        onClick = {
                            viewModel.onEvent(SignUpAuthUiEvent.SignUp)
                        }, shape = RoundedCornerShape(8.dp), modifier = modifier
                            .padding(top = 32.dp)
                            .fillMaxWidth()
                            .height(50.dp), enabled = checked


                    ) {
                        Text(text = "Sign Up")
                    }
                    Spacer(modifier = Modifier.height(16.dp))



                    Row(
                        modifier = modifier.padding(
                            bottom = 32.dp
                        )
                    ) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = {
                                viewModel.checkChanged()
                                              },
                            colors = CheckboxDefaults.colors(
                                checkmarkColor = trivious_orange,
                                uncheckedColor = Color.LightGray,


                                )

                        )
                        Spacer(modifier = Modifier.width(6.dp))

                        AnnotatedClickableText(navController = navController,viewModel)

                    }

                }
            }
            









    }

}

@Composable
fun AnnotatedClickableText(navController: NavController, viewModel: SignUpViewModel) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 13.sp, fontFamily = FontFamily( Font(R.font.poppins_regular, FontWeight.Normal))
            )
        ) {
            append("By Signing up you agree to the terms and conditions in using the Trivia app. ")

        }
        pushStringAnnotation(
            tag = "terms",
            annotation = "Terms and Conditions"
        )
        withStyle(
            style = SpanStyle(

                color = MaterialTheme.colors.primary,
                fontSize = 13.sp, fontFamily = FontFamily( Font(R.font.poppins_regular, FontWeight.Normal))
            )
        ) {
            append("Terms and Conditions")

        }
        pop()
        withStyle(
            style = SpanStyle(

                fontSize = 13.sp, fontFamily = FontFamily( Font(R.font.poppins_regular, FontWeight.Normal))
             )
        ) {
            append(" apply.")

        }
    }

    ShowTermsAndConditions(annotatedText,viewModel)




}

@Composable
fun ShowTermsAndConditions(annotatedText: AnnotatedString, viewModel: SignUpViewModel) {

    ShowTermsAndConditionsDialog(viewModel = viewModel)


    ClickableText(
        text = annotatedText,
        onClick = {

                offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(tag = "terms", start = offset,
                end = offset)
                .firstOrNull()?.let { annotation ->
                    // If yes, we log its value
                    viewModel.showDialogWindow()
                    Log.d("terms and conditions", annotation.item)
                }



        }
    )
}

private fun navigateToLoginScreen(
    navController: NavController
){
    navController.navigate(route = Screen.LogInScreen.route){

    }
}


@Preview(widthDp = 400)
@Composable
fun SignUpScreenPreview() {
    TriviousTheme {
        SignUpScreen(navController = rememberNavController())
    }

}