package com.example.trivious.domain.model

import com.example.trivious.domain.model.account_info.Account
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class User(


    @SerialName("id")
    val id: String,
    val username:String,
    val salt:String?,
    val profilePicture:String? = null,
    val country:String?= null,
    val phoneNumber:String?= null,
    val bioData:String? = null,
    val password:String?,
    val account: Account,
    val email:String,
)
