package com.example.trivious.server

interface AuthRepository {
    suspend fun signUp(
         username:String,
         password:String,
         email:String,
         phoneNumber:String,
    ):AuthResult<Unit>

    suspend fun signIn(
        username:String,
        password:String,
    ):AuthResult<Unit>
    suspend fun authenticate():AuthResult<Unit>
}