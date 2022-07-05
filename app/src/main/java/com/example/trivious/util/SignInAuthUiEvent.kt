package com.example.trivious.util

sealed class SignInAuthUiEvent {

    data class SignInUsernameChanged(val value: String): SignInAuthUiEvent()
    data class SignInPasswordChanged(val value: String): SignInAuthUiEvent()
    object SignIn: SignInAuthUiEvent()
}
