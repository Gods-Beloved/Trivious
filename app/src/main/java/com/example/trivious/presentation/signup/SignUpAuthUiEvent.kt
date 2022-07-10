package com.example.trivious.presentation.signup

sealed class SignUpAuthUiEvent {
    data class SignUpUsernameChanged(val value: String): SignUpAuthUiEvent()
    data class SignUpPasswordChanged(val value: String): SignUpAuthUiEvent()
    data class SignUpEmailChanged(val value: String): SignUpAuthUiEvent()
    data class SignUpPhoneChanged(val value: String): SignUpAuthUiEvent()
    data class SignUpConfirmPasswordChanged(val value: String): SignUpAuthUiEvent()
    object SignUp: SignUpAuthUiEvent()
}

