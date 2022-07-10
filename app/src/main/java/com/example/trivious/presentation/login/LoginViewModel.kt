package com.example.trivious.presentation.login

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trivious.domain.model.*
import com.example.trivious.domain.repository.Repository
import com.example.trivious.presentation.signup.SignUpAuthState
import com.example.trivious.presentation.signup.SignUpAuthUiEvent
import com.example.trivious.util.RequestState
import com.example.trivious.util.SignInAuthUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

    private val repository: Repository

):ViewModel() {

    private val _signedInState:MutableState<Boolean> = mutableStateOf(false)
    val signedInState: State<Boolean> = _signedInState

    private val _messageBarState:MutableState<MessageBarState> = mutableStateOf(MessageBarState())
    val messageBarState: State<MessageBarState> = _messageBarState

    private val _apiResponse:MutableState<RequestState<ApiResponse>> = mutableStateOf(RequestState.Idle)
    val apiResponse: State<RequestState<ApiResponse>> = _apiResponse

    var state by mutableStateOf(SignInAuthState())


    fun onEvent(event: SignInAuthUiEvent) {
        when (event) {
            is SignInAuthUiEvent.SignInUsernameChanged -> {
                state = state.copy(signInUsername = event.value)
            }

            is SignInAuthUiEvent.SignIn -> {
                signInUserOnBackend()
            }
            is SignInAuthUiEvent.SignInPasswordChanged -> {
                state = state.copy(signInPassword = event.value)
            }

        }
    }

     fun startLoading(){
        _apiResponse.value = RequestState.Loading
    }

    private fun signInUserOnBackend(){
        _apiResponse.value = RequestState.Loading

        try {

            viewModelScope.launch(Dispatchers.IO) {
                val request = SignInUserRequest(
                    username = state.signInUsername,
                    password = state.signInPassword,

                )
                val response = repository.signInUser(request)


                _apiResponse.value = RequestState.Success(response)

                _messageBarState.value = MessageBarState(
                    message = response.message,
                    error = response.error
                )

            }

        } catch (e: Exception) {
            _apiResponse.value = RequestState.Error(e)

            _messageBarState.value = MessageBarState(
                error = e
            )


        }
    }



    init {
        viewModelScope.launch {
            repository.readSignedInState().collect{
                completed->
                _signedInState.value = completed

            }
        }
    }

    fun saveSignedInState(signedIn:Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveSignedInState(signedIn = signedIn)

        }
    }

    fun updateMessageBarState(){
        _messageBarState.value = MessageBarState(error= GoogleAccountNotFoundException())

    }



    fun verifyTokenOnBackend(request:ApiRequest){

        _apiResponse.value = RequestState.Loading

        try {
            viewModelScope.launch(Dispatchers.IO) {
                val response = repository.verifyTokenOnBackend(request = request)

                _apiResponse.value = RequestState.Success(response)

                _messageBarState.value  = MessageBarState(
                    message = response.message,
                    error = response.error
                )

            }

        }catch (e:Exception){
            _apiResponse.value = RequestState.Error(e)

            _messageBarState.value  = MessageBarState(
                error = e
            )

        }
    }








}

class GoogleAccountNotFoundException(
    override val message: String? = "No Google Account Found"
):Exception()