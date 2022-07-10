package com.example.trivious.presentation.login

sealed class LogInAuthUiEvent {
    data class SignInUsernameChanged(val value: String): LogInAuthUiEvent()
    data class SignInPasswordChanged(val value: String): LogInAuthUiEvent()
    object SignIn: LogInAuthUiEvent()
}

