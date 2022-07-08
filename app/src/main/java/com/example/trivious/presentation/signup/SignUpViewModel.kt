package com.example.trivious.presentation.signup

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trivious.domain.model.ApiRequest
import com.example.trivious.domain.model.ApiResponse
import com.example.trivious.domain.model.MessageBarState
import com.example.trivious.domain.model.UserRequest
import com.example.trivious.domain.repository.Repository
import com.example.trivious.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val repository:Repository
): ViewModel() {


    private val _apiResponse: MutableState<RequestState<ApiResponse>> =
        mutableStateOf(RequestState.Idle)
    val apiResponse: State<RequestState<ApiResponse>> = _apiResponse

    private val _messageBarState: MutableState<MessageBarState> = mutableStateOf(MessageBarState())
    val messageBarState: State<MessageBarState> = _messageBarState


    var state by mutableStateOf(SignUpAuthState())

    fun onEvent(event: SignUpAuthUiEvent) {
        when (event) {
            is SignUpAuthUiEvent.SignUpUsernameChanged -> {
                state = state.copy(signUpUsername = event.value)
            }
            is SignUpAuthUiEvent.SignUpEmailChanged -> {
                state = state.copy(signUpEmail = event.value)
            }
            is SignUpAuthUiEvent.SignUp -> {
                signUpUserOnBackend()
            }
            is SignUpAuthUiEvent.SignUpPasswordChanged -> {
                state = state.copy(signUpPassword = event.value)
            }
            is SignUpAuthUiEvent.SignUpConfirmPasswordChanged -> {
                state = state.copy(signUpConfirmPassword = event.value)
            }
            is SignUpAuthUiEvent.SignUpPhoneChanged -> {
                state = state.copy(signUpPhoneNumber = event.value)
            }


        }
    }

    private fun signUpUserOnBackend() {
        _apiResponse.value = RequestState.Loading

        try {

            viewModelScope.launch(Dispatchers.IO) {
                val request = UserRequest(
                    username = state.signUpUsername,
                    password = state.signUpConfirmPassword,
                    email = state.signUpEmail,
                    phoneNumber = state.signUpPhoneNumber

                )
                val response = repository.signUpUser(request)


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
}