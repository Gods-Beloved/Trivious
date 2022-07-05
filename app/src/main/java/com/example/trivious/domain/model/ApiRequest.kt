package com.example.trivious.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiRequest(
    val tokenId:String
)
