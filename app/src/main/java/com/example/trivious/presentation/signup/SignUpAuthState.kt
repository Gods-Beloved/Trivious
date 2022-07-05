package com.example.trivious.presentation.signup

data class SignUpAuthState(
    val isLoading: Boolean = false,
    val signUpUsername: String = "",
    val signUpPassword: String = "",
    val signUpEmail:String = "",
    val signUpPhoneNumber:String = "",
    val signUpConfirmPassword:String = ""
)