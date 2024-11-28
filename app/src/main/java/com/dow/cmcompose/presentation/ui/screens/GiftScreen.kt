package com.dow.cmcompose.presentation.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dow.cmcompose.R

@Composable
fun GiftScreen() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp), contentAlignment = Alignment.Center
    ) {
        Column {
            Icon(
                painterResource(R.drawable.twotone_card_gift_24),
                contentDescription = "no history data",
                modifier = Modifier
                    .padding(8.dp)
                    .width(46.dp)
                    .height(46.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = stringResource(R.string.no_gift_data_not_login),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                , modifier = Modifier.padding(8.dp)
            )
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(8.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color(0xFFE9E3D8), containerColor = Color(0xFFE9E3D8)),
                onClick = {
                    Toast.makeText(context, "login", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text(
                    modifier = Modifier
                        .background(Color.Transparent),
                    text = stringResource(R.string.button_login_text),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    , color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GiftScreenPreview() {
    GiftScreen()
}