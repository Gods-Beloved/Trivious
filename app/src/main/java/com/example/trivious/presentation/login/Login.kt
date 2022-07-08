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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.domain.model.ApiRequest
import com.example.trivious.domain.model.ApiResponse
import com.example.trivious.navigation.Screen
import com.example.trivious.presentation.common.StartActivityForResult
import com.example.trivious.presentation.common.signIn
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.util.RequestState

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    loginViewModel: LoginViewModel = hiltViewModel(),
    scrollState: ScrollState = rememberScrollState()

) {
    val signedInState by loginViewModel.signedInState
    val messageBarState by loginViewModel.messageBarState
    val apiResponse by loginViewModel.apiResponse


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
                tokenId ->
            Log.d("SignInScreen:", tokenId)
            loginViewModel.verifyTokenOnBackend(request = ApiRequest(tokenId = tokenId))
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

    LaunchedEffect(apiResponse){
        when(apiResponse){
            is RequestState.Success -> {
                val response = (apiResponse as RequestState.Success<ApiResponse>).data.success
                if (response){
                    navigateToMainScreen(navController = navController)
                }else{
                    loginViewModel.saveSignedInState(signedIn = false)

                }
            }
            else ->{

            }
        }
    }


}
private fun navigateToMainScreen(
    navController: NavController
){
    navController.navigate(route = Screen.MainScreen.route){
        popUpTo(route = Screen.LogInScreen.route){
            inclusive = true
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