package com.example.trivious.data.repository

import com.example.trivious.domain.model.*
import com.example.trivious.domain.repository.DataStoreOperations
import com.example.trivious.domain.repository.Repository
import com.example.trivious.server.ServerApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    private val serverApi: ServerApi
): Repository {
    override suspend fun saveSignedInState(signedIn: Boolean) {
        dataStoreOperations.saveSignedInState(signedIn = signedIn)
    }

    override fun readSignedInState(): Flow<Boolean> {
        return dataStoreOperations.readSignedInState()

    }

    override suspend fun verifyTokenOnBackend(request: ApiRequest): ApiResponse {
        return try {
            serverApi.verifyTokenOnBackend(request = request)

        }catch (e:Exception){
            ApiResponse(
                success = false,
                error = e
            )

        }
    }

    override suspend fun getUserInfo(): ApiResponse {
        return try {
            serverApi.getUserInfo()

        }catch (e:Exception){
            ApiResponse(
                success = false,
                error = e
            )

        }
    }

    override suspend fun updateUserInfo(userUpdate: UserUpdate): ApiResponse {
        return try {
            serverApi.updateUserInfo(userUpdate = userUpdate)

        }catch (e:Exception){
            ApiResponse(
                success = false,
                error = e
            )

        }
    }

    override suspend fun deleteUser(): ApiResponse {
        return try {
            serverApi.deleteUser()

        }catch (e:Exception){
            ApiResponse(
                success = false,
                error = e
            )

        }
    }

    override suspend fun signOutUser(): ApiResponse {
        return try {
            serverApi.signOutUser()

        }catch (e:Exception){
            ApiResponse(
                success = false,
                error = e
            )

        }
    }

    override suspend fun signUpUser(signUserUp: UserRequest): ApiResponse {
        return try {
            serverApi.signUpUser(signUserUp)

        }catch (e:Exception){
            ApiResponse(
                success = false,
                error = e
            )

        }
    }

    override suspend fun signInUser(signUserIn: SignInUserRequest): ApiResponse {
        return try {
            serverApi.signInUser(signUserIn = signUserIn)

        }catch (e:Exception){
            ApiResponse(
                success = false,
                error = e
            )

        }
    }
}