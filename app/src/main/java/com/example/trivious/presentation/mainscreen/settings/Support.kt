package com.example.trivious.presentation.mainscreen.settings

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.trivious.R
import com.example.trivious.navigation.BottomNavScreen
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun SupportScreen(
    navController: NavController
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        color = Color.Black
    ) {
        Box() {
            Icon(
                imageVector = Icons.Filled.ArrowBackIosNew,
                contentDescription = "Back Button",
                tint = trivious_ash,
                modifier = Modifier
                    .padding(top = 30.dp, start = 16.dp)
                    .size(30.dp)
                    .align(Alignment.TopStart)
                    .clickable {
                        navController.navigate(BottomNavScreen.Settings.id)
                    }

            )

            Text(
                text = "Support", style = MaterialTheme.typography.h5.copy(
                    fontSize= 20.sp,
                    fontWeight = FontWeight(700),
                    lineHeight = 37.5.sp
                ), color = trivious_ash,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .align(Alignment.TopCenter)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            CustomerSupportLink()


        }
    }


}

@Composable
fun CustomerSupportLink() {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.bradybunch, FontWeight.Light)),
                color = trivious_ash,

            )
        ) {
            append("Customer support is available if you experience any difficulties. Customer support can be reached by email at ")

        }
        pushStringAnnotation(
            tag = "support",
            annotation = "support@trivea.com"
        )
        withStyle(
            style = SpanStyle(

                color = MaterialTheme.colors.primary,
                fontSize = 25.sp, fontFamily = FontFamily(
                    Font(R.font.bradybunch, FontWeight.Medium)


                ), textDecoration = TextDecoration.Underline
            )
        ) {
            append("support@trivea.com")

        }
        pop()
        withStyle(
            style = SpanStyle(

                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.bradybunch, FontWeight.Light)),
                color = trivious_ash
            )
        ) {
            append(". Any complaints or disputes may be sent to this email address.")

        }
    }

    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:") // only email apps should handle this
    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("support@trivea.com"))
    intent.putExtra(Intent.EXTRA_SUBJECT, "Trivea Support")
    val context = LocalContext.current



    ClickableText(
        text = annotatedText,
        onClick = {

                offset ->
            // We check if there is an *URL* annotation attached to the text
            // at the clicked position
            annotatedText.getStringAnnotations(
                tag = "support", start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    // If yes, we log its value
                    startActivity(context, intent, null)
                }


        }
    )

}


@Preview
@Composable
fun PreviewSupport() {
    TriviousTheme {
        SupportScreen(navController = rememberNavController())
    }

}