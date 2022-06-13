package com.example.trivious.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.trivious.presentation.LoginFormState

class LoginViewModel: ViewModel() {

    var state by mutableStateOf(LoginFormState())

}