package com.example.trivious.components


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.FlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.trivious.R
import com.example.trivious.presentation.signup.SignUpViewModel
import com.itextpdf.text.pdf.PdfReader
import com.itextpdf.text.pdf.parser.PdfTextExtractor
import org.w3c.dom.Text


// on below line we are creating an extract data method to extract our data.


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ShowTermsAndConditionsDialog(
viewModel: SignUpViewModel
) {



    var visible by remember {
        mutableStateOf(viewModel.showDialog)
    }

    visible = viewModel.showDialog


    if (visible.value) {
        Dialog(
            onDismissRequest = {
                viewModel.closeDialogWindow()
            },


            properties = DialogProperties(
                dismissOnClickOutside = false,

            )

        ){
            Surface(shape = RoundedCornerShape(8.dp), border = BorderStroke(1.dp,MaterialTheme.colors.primary)) {
                Box(modifier = Modifier.fillMaxSize()){
                    Column()

                    {
                        Text(text = "TERMS AND CONDITIONS",
                            Modifier
                                .background(MaterialTheme.colors.primary)
                                .padding(8.dp)
                                .fillMaxWidth()
                        , style = MaterialTheme.typography.h6.copy(fontFamily = FontFamily(Font(R.font.bradybunch)),
                                letterSpacing = 0.25.sp, fontSize = 24.sp),
                            textAlign = TextAlign.Center
                        )
                        Column( modifier = Modifier
                            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                            .verticalScroll(rememberScrollState())) {
                            Text(text = extractData().toString())
                            Spacer(modifier = Modifier.height(16.dp))
                        }



                    }

                        Button(onClick = {
                            viewModel.closeDialogWindow()
                            viewModel.checkChanged()

                        },
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .padding(bottom = 4.dp)
                                .width(120.dp),
                            shape = RoundedCornerShape(topStart = 12.dp, bottomStart = 12.dp)
                        ) {
                            Text(text = "I AGREE")
                        }

                    Button(onClick = {
                        viewModel.closeDialogWindow()

                    },
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(bottom = 4.dp)
                            .width(120.dp),
                        shape = RoundedCornerShape(topEnd = 12.dp, bottomEnd = 12.dp)
                    ) {
                        Text(text = "I DISAGREE")
                    }

                    }


            }
        }
    }



}


fun extractData(): String? {
    // on below line we are running a try and catch
    // block to handle extract data operation.
    try {
        // on below line we are creating a variable
        // for storing our extracted text
        var extractedText = ""

        // on below line we are creating a variable for our pdf extracter.
        val pdfReader: PdfReader = PdfReader("res/raw/trivea.pdf")

        // on below line we are creating
        // a variable for pages of our pdf.
        val n = pdfReader.numberOfPages

        // on below line we are running a for loop.
        for (i in 0 until n) {

            // on below line we are appending our data to
            // extracted text from our pdf file using pdf reader.
            extractedText =
                """
				$extractedText${
                    PdfTextExtractor.getTextFromPage(pdfReader, i + 1).trim { it <= ' ' }
                }

				""".trimIndent()
            // to extract the PDF content from the different pages
        }

        // on below line we are setting
        // extracted text to our text view.


        // on below line we are
        // closing our pdf reader.
        pdfReader.close()
        return extractedText

    }
    // on below line we are handling
    // our exception using catch block
    catch (e: Exception) {
        e.printStackTrace()
        return null
    }
}
