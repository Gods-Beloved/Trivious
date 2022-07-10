package com.example.trivious.presentation.mainscreen.home

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.trivious.domain.model.ApiResponse
import com.example.trivious.domain.model.MessageBarState
import com.example.trivious.domain.model.User
import com.example.trivious.domain.repository.Repository
import com.example.trivious.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
):ViewModel(

) {

        private val _user: MutableState<User?> = mutableStateOf(null)
        val user: State<User?> = _user

        private val _username: MutableState<String> = mutableStateOf("")
        val username: State<String> = _username

        private val _apiResponse: MutableState<RequestState<ApiResponse>> =
            mutableStateOf(RequestState.Idle)
        val apiResponse: State<RequestState<ApiResponse>> = _apiResponse

        private val _clearSessionResponse: MutableState<RequestState<ApiResponse>> =
            mutableStateOf(RequestState.Idle)
        val clearSessionResponse: State<RequestState<ApiResponse>> = _clearSessionResponse

        private val _messageBarState: MutableState<MessageBarState> = mutableStateOf(MessageBarState())
        val messageBarState: State<MessageBarState> = _messageBarState

        init {
            getUserInfo()
        }

        private fun getUserInfo() {
            _apiResponse.value = RequestState.Loading
            viewModelScope.launch {
                try {
                    val response = withContext(Dispatchers.IO) {
                        repository.getUserInfo()
                    }
                    _apiResponse.value = RequestState.Success(response)
                    _messageBarState.value = MessageBarState(
                        message = response.message,
                        error = response.error
                    )
                    if (response.user != null) {
                        _user.value = response.user
                        _username.value = response.user.username.split(" ").first()

                    }
                } catch (e: Exception) {
                    _apiResponse.value = RequestState.Error(e)
                    _messageBarState.value = MessageBarState(error = e)
                }
            }
        }



}