package com.example.trivious.presentation.mainscreen.home.live

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.trivious.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LiveViewModel @Inject constructor(
   // private val repository: Repository
): ViewModel(

){

    val options = listOf(
        "Man",
        "Woman",
        "Girl",
        "Teen",
    )

    val correctanswer = "Man"

    private val _selectedOption: MutableState<String> = mutableStateOf("")
    val selectedOption: State<String> = _selectedOption


    private val _showDialog: MutableState<Boolean> = mutableStateOf(false)
    val showDialog: State<Boolean> = _showDialog


    private val _showLoading: MutableState<Boolean> = mutableStateOf(false)
    val showLoading: State<Boolean> = _showLoading

    private val _isSuccess: MutableState<Boolean> = mutableStateOf(false)
    val isSuccess: State<Boolean> = _isSuccess

    private val _isFailed: MutableState<Boolean> = mutableStateOf(false)
    val isFailed: State<Boolean> = _isFailed

    val onSelectionChange = {  i:Int ->
        _selectedOption.value = options[i]
    }

    fun checkAnswerChosen():Boolean{
        return _selectedOption.value == correctanswer
    }



    fun showDialogWindow(){
        _showDialog.value = true
    }
    fun closeDialogWindow(){
        _showDialog.value = false
    }

    fun showPaymentOkWindow(){
        _isSuccess.value = true
    }
    fun closePaymentOkWindow(){
        _isSuccess.value = false
    }

    fun showPaymentErrorWindow(){
        _isFailed.value = true
    }
    fun closePaymentErrorWindow(){
        _isFailed.value = false
    }

    fun showWait(){
        _showLoading.value = true
    }

    fun checkValue(){
        showPaymentOkWindow()

    }

}