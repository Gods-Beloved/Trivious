package com.example.trivious.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
val username:String,
val password:String,
val email:String,
val phoneNumber:String,

)
