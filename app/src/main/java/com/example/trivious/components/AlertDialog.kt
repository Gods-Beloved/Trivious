package com.example.trivious.components


import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontWeight

@Composable
fun DisplayAlertDialog(
    title: String = "Delete your account?",
    message: String = "Are you sure you want to delete your account?",
    openDialog: Boolean,

) {
    var isOpen by remember{ mutableStateOf(openDialog)}

    if (isOpen) {
        AlertDialog(
            title = {
                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold
                )
            },
            text = {
                Text(
                    text = message,
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        isOpen = false
                    }
                ) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = {isOpen = false }) {
                    Text(text = "No")
                }
            },
            onDismissRequest = {isOpen = false}
        )
    }
}
