//package com.example.trivious.server
//
//import retrofit2.HttpException
//import java.lang.Exception
//
//class AuthRepositoryImpl(
//     private val api: ServerApi
//):AuthRepository {
//    override suspend fun signUp(
//        username: String,
//        password: String,
//        email: String,
//        phoneNumber: String
//    ): AuthResult<Unit> {
//       return try {
//           api.signUp(
//               request = SignUpAuthRequest(
//                   username = username,
//                   password = password,
//                   email = email,
//                   phoneNumber = phoneNumber
//               )
//           )
//           signIn(username = username, password = password)
//
//        }catch (e:HttpException){
//            if(e.code() == 401){
//                AuthResult.UnAuthorized()
//            }else{
//                AuthResult.UnknownError()
//            }
//
//        }catch (e:Exception){
//            AuthResult.UnknownError()
//        }
//    }
//
//    override suspend fun signIn(username: String, password: String): AuthResult<Unit> {
//        return try {
//            api.signIn(
//                request = SignUpAuthRequest(
//                    username = username,
//                    password = password,
//                    email = email,
//                    phoneNumber = phoneNumber
//                )
//            )
//
//        }catch (e:HttpException){
//            if(e.code() == 401){
//                AuthResult.UnAuthorized()
//            }else{
//                AuthResult.UnknownError()
//            }
//
//        }catch (e:Exception){
//            AuthResult.UnknownError()
//        }
//    }
//
//    override suspend fun authenticate(): AuthResult<Unit> {
//        TODO("Not yet implemented")
//    }
//}