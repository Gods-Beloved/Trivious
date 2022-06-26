package com.example.trivious.presentation.common

import android.app.Activity
import android.util.Log
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import com.example.trivious.util.Constant.CLIENT_ID
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.CommonStatusCodes

@Composable
fun StartActivityForResult(
    key: Any,
    onResultReceived: (String) -> Unit,
    onDialogDismissed: () -> Unit,
    launcher: (ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>) -> Unit
) {

    val activity = LocalContext.current as Activity

    val activityLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.StartIntentSenderForResult()) { activityResult ->
            try {
                if (activityResult.resultCode == Activity.RESULT_OK) {
                    val oneTapClient = Identity.getSignInClient(activity)
                    val credential = oneTapClient.getSignInCredentialFromIntent(activityResult.data)
                    val tokenId = credential.googleIdToken
                    if(tokenId != null){
                        onResultReceived(tokenId)
                    }
                }else{
                    Log.d("StartActivityForResult: ","BLACK SCRIM CLICKED,DIALOG CLOSED")
                    onDialogDismissed()
                }

            } catch (e:ApiException) {
                when(e.statusCode){

                    CommonStatusCodes.CANCELED->{
                        Log.d("StartActivityForResult: ","One Tap Dialog Cancelled")
                        onDialogDismissed()
                    }
                    CommonStatusCodes.NETWORK_ERROR->{
                        Log.d("StartActivityForResult: ","ONE-TAP NETWORK ERROR")
                        onDialogDismissed()
                    }
                    else ->{
                        Log.d("StartActivityForResult: ","${e.message}")
                         onDialogDismissed()
                    }
                }

            }
        }


    LaunchedEffect(key1 = key)  {
        launcher(activityLauncher)
    }

}

fun signIn(
    activity: Activity,
    launchActivityResult: (IntentSenderRequest) -> Unit,
    accountNotFound: () -> Unit

) {
    val onTapClient = Identity.getSignInClient(activity)
    val signInRequest = BeginSignInRequest.Builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setServerClientId(CLIENT_ID)
                .setFilterByAuthorizedAccounts(true)
                .build()
        )
        .setAutoSelectEnabled(true)
        .build()

    onTapClient.beginSignIn(signInRequest)
        .addOnSuccessListener {
                result ->
            try {
                launchActivityResult(
                    IntentSenderRequest.Builder(
                        result.pendingIntent.intentSender
                    ).build()
                )

            } catch (e: Exception) {
                Log.d("SignIn", "signIn:Could not start One tap signIn ${e.message}")

            }

        }
        .addOnFailureListener {

            Log.d("SignIn ", "signing up failure... ${it.message}")
            signUp(
                activity = activity,
                launchActivityResult = launchActivityResult,
                accountNotFound = accountNotFound
            )
        }

}

fun signUp(
    activity: Activity,
    launchActivityResult: (IntentSenderRequest) -> Unit,
    accountNotFound: () -> Unit

) {
    val onTapClient = Identity.getSignInClient(activity)
    val signInRequest = BeginSignInRequest.Builder()
        .setGoogleIdTokenRequestOptions(
            BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                .setSupported(true)
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(CLIENT_ID)
                .build()
        )
        .build()

    onTapClient.beginSignIn(signInRequest)
        .addOnSuccessListener { result ->
            try {
                launchActivityResult(
                    IntentSenderRequest.Builder(
                        result.pendingIntent.intentSender
                    ).build()
                )

            } catch (e: Exception) {
                Log.d("SignUp", "signIn:Could not start One tap signIn ${e.message}")

            }

        }
        .addOnFailureListener {
            Log.d("SignUp ", "signing up ... $it")
            accountNotFound()
        }

}