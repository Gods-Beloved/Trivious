package com.example.trivious.util

data class SignInAuthState(
    val isLoading: Boolean = false,
    val signInUsername: String = "",
    val signInPassword: String = "",
)
