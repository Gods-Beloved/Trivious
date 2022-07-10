package com.example.trivious.presentation.login

data class SignInAuthState(
    val isLoading: Boolean = false,
    val signInUsername: String = "",
    val signInPassword: String = "",
)