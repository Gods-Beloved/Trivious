package com.example.trivious.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class SignInUserRequest(
    val username:String,
    val password:String,
)
