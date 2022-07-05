package com.example.trivious.server

data class SignUpAuthRequest(
    val username:String,
    val password:String,
    val email:String,
    val phoneNumber:String,

)
