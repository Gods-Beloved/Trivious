package com.example.trivious.presentation.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.trivious.domain.repository.Repository
import com.example.trivious.domain.model.MessageBarState
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




}

class GoogleAccountNotFoundException(
    override val message: String? = "No Google Account Found"
):Exception()