package com.example.trivious.presentation.mainscreen.wallet

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.trivious.R
import com.example.trivious.ui.theme.TriviousTheme
import com.example.trivious.ui.theme.trivious_ash

@Composable
fun Transactions() {
  TransactContent()
}

@Composable
fun TransactContent() {
Column(
    modifier = Modifier.fillMaxSize().background(Color.Black),
    horizontalAlignment = Alignment.CenterHorizontally) {

    LazyColumn() {
        items(1) { index ->
            Spacer(modifier = Modifier.height(8.dp))
           SingleWithdrawal(amount = 16 * (index + 2))
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(2){
            index ->
            SingleDeposit(amount = 35 * (index + 2))
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(1) {

            SingleWithdrawal(amount = 16 * (2 + 2))

        }
    }

}
}

@Composable
fun SingleTransaction(
    profilePhoto:String? = null
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    ) {

        Surface(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .size(50.dp)
                .background(Color.Transparent),
            border = BorderStroke(2.dp, MaterialTheme.colors.primary)

        ) {


            if (profilePhoto != null) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(profilePhoto)
                        .crossfade(durationMillis = 1000)
                        .placeholder(drawableResId = R.drawable.ic_placeholder)
                        .transformations(CircleCropTransformation())
                        .build(),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Profile Photo"
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.resize2),
                    contentDescription = "profile photo",
                    contentScale = ContentScale.Crop
                )
            }


        }
        Spacer(modifier = Modifier.width(12.dp))
        Row {
            Column() {
                Text("MTN Agent", style = MaterialTheme.typography.caption.copy(fontWeight = FontWeight(700), color = trivious_ash))
                Text("Deposit", style = MaterialTheme.typography.overline.copy(fontWeight = FontWeight(700)))

            }

            Text(text = "+$10.00", style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight(700)), modifier = Modifier.weight(1f), color = trivious_ash, textAlign = TextAlign.Right)


        }




    }
}

@Preview
@Composable
fun SingleTransactionPreview() {
    TriviousTheme()  {
        SingleTransaction( )

    }
}

@Preview
@Composable
fun TransactPreview() {
    TriviousTheme() {
        Transactions()

    }
}