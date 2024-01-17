package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Spacer(modifier = modifier.weight(2f))
        NameSection(modifier = modifier.weight(2.5f))
        Spacer(modifier = modifier.weight(1f))
        ContactInformation(modifier = modifier.weight(1.5f))
    }
}

@Composable
fun NameSection(modifier: Modifier = Modifier) {
    val profilePicture = painterResource(id = R.drawable.alhaitham_sticker_1)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = profilePicture,
            contentDescription = "A picture portraying a man",
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = "Full Name",
            fontSize = 32.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        Text(
            text = "Title",
            color = Color(0xFF0d5202),
            fontSize = 20.sp
        )
    }
}

@Composable
fun ContactInformation(modifier: Modifier = Modifier) {
    // Contain the contact information inside a column
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start,
        //Default minimum size for the column. Width can be extended if its content has longer
        //length, for example try using a longer email address -v
        modifier = modifier.defaultMinSize(minWidth = 200.dp, minHeight = 50.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(bottom = 8.dp) //Space between each row
        ) {
            val phoneIcon = painterResource(id = R.drawable.ic_call_24)
            Image(
                painter = phoneIcon,
                contentDescription = "Phone number",
                modifier = Modifier.padding(end = 24.dp)
            )
            Text(text = "+192837465")
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(bottom = 8.dp) //Space between each row
        ) {
            val phoneIcon = painterResource(id = R.drawable.ic_share_24)
            Image(
                painter = phoneIcon,
                contentDescription = "Phone number",
                modifier = Modifier.padding(end = 24.dp)
            )
            Text(text = "@A_Lousy_Coder")
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(bottom = 8.dp) //Space between each row
        ) {
            val phoneIcon = painterResource(id = R.drawable.ic_inbox_24)
            Image(
                painter = phoneIcon,
                contentDescription = "Phone number",
                modifier = Modifier.padding(end = 24.dp)
            )
            Text(text = "ndc@gmail.com")
            //Text(text = "ndclkllkidnvcipcmaso@gmail.com")
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}