package com.example.trivious.presentation

data class LoginFormState(
    val email:String="",
    val emailError:String? = null,
    val password:String = ""
)
