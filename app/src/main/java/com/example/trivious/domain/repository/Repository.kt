package com.example.trivious.domain.repository

import com.example.trivious.domain.model.*
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*

interface Repository {

    suspend fun saveSignedInState(signedIn: Boolean)

    fun readSignedInState(): Flow<Boolean>

    suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse


    suspend fun getUserInfo(): ApiResponse


    suspend fun updateUserInfo(userUpdate: UserUpdate): ApiResponse


    suspend fun deleteUser(): ApiResponse


    suspend fun signOutUser(): ApiResponse


    suspend fun signUpUser(
        signUserUp: UserRequest
    ): ApiResponse


    suspend fun signInUser(
        signUserIn: SignInUserRequest
    ): ApiResponse

}