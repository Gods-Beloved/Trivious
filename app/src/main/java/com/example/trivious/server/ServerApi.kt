package com.example.trivious.server

import com.example.trivious.domain.model.*
import retrofit2.http.*

interface ServerApi {

    @POST("/token_verification")
    suspend fun verifyTokenOnBackend(
        @Body
        request:ApiRequest
    ):ApiResponse

    @GET("/get_user")
    suspend fun getUserInfo():ApiResponse

    @PUT("/update_user")
    suspend fun updateUserInfo(
        @Body
        userUpdate: UserUpdate

    ):ApiResponse

    @DELETE("/delete_user")
    suspend fun deleteUser():ApiResponse

    @DELETE("sign_out")
    suspend fun signOutUser():ApiResponse

    @POST("/signup_user")
    suspend fun signUpUser(
        @Body
        signUserUp: UserRequest
    ):ApiResponse

    @POST("/signin_user")
    suspend fun signInUser(
        @Body
        signUserIn:SignInUserRequest
    ):ApiResponse





//    @POST("signup_user")
//    suspend fun signUp(
//        @Body
//        request: SignUpAuthRequest
//    )
//
//    @POST("signin_user")
//    suspend fun signIn(
//        @Body
//        request: SignUpAuthRequest
//    ):TokenResponse
//
//
//    @GET("authorized")
//    suspend fun authorized(
//        @Header("Authorization")token:String
//
//    )
}