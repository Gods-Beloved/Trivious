package com.example.trivious.presentation.login

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.presentation.common.StartActivityForResult
import com.example.trivious.presentation.common.signIn
import com.example.trivious.ui.theme.TriviousTheme

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    scrollState: ScrollState = rememberScrollState()

) {
    val signedInState by loginViewModel.signedInState
    val messageBarState by loginViewModel.messageBarState


    SignInContent(
        signedInState = signedInState,
        messageBarState = messageBarState,
        state = scrollState,
        navController = navController
    ){
        loginViewModel.saveSignedInState(signedIn = true)
    }


    val activity = LocalContext.current as Activity
    StartActivityForResult(
        key = signedInState,
        onResultReceived = {
                idToken ->
            Log.d("Tokens","Google Token  $idToken")
        },
        onDialogDismissed = {
            loginViewModel.saveSignedInState(false)
        }

    ) {

            activityLauncher ->
        if (signedInState){
            signIn(activity,
                launchActivityResult = {
                        intentSenderRequest ->
                    activityLauncher.launch(intentSenderRequest)
                },
                accountNotFound = {
                    loginViewModel.saveSignedInState(signedIn = false)
                    loginViewModel.updateMessageBarState()
                }
            )
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