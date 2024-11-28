package com.dow.cmcompose.presentation.ui.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
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
fun ProfileScreen() {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxSize()) {
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
        SettingSubMenu(R.drawable.baseline_notifications_24, R.string.menu_sub_notice)
        SettingSubMenu(R.drawable.baseline_settings_24, R.string.menu_sub_settings)
        SettingSubMenu(R.drawable.baseline_mail_outline_24, R.string.menu_sub_contact_us)
        SettingSubMenu(R.drawable.baseline_help_outline_24, R.string.menu_sub_help)
        SettingSubMenu(R.drawable.baseline_cruelty_free_24, R.string.menu_sub_other, true)
        AppVersion()
    }
}

@Composable
fun SettingSubMenu(iconRes: Int, titleRes: Int, isLast: Boolean = false) {
    val context = LocalContext.current
    val title = stringResource(titleRes)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                //top border
                drawLine(
                    color = Color(0xFFE1E1E1),
                    strokeWidth = 1.dp.toPx(),
                    start = androidx.compose.ui.geometry.Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(size.width, 0f)
                )
                // bottom border
                if (isLast) {
                    drawLine(
                        color = Color(0xFFE1E1E1),
                        strokeWidth = 1.dp.toPx(),
                        start = androidx.compose.ui.geometry.Offset(0f, size.height),
                        end = androidx.compose.ui.geometry.Offset(size.width, size.height)
                    )
                }
            }
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.CenterStart)
        ) {
            Icon(
                painterResource(iconRes),
                contentDescription = "no history data",
                modifier = Modifier
                    .padding(start = 16.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
            )
            Text(
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(8.dp)
                    .align(Alignment.CenterVertically),
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                ), color = Color.Black
            )
        }
        Icon(
            painterResource(R.drawable.outline_arrow_forward_24),
            contentDescription = "move to notice",
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 16.dp)
                .align(Alignment.CenterEnd)
                .clickable {
                    Toast
                        .makeText(context, title, Toast.LENGTH_SHORT)
                        .show()
                }
        )
    }
}

@Composable
fun AppVersion() {
    val context = LocalContext.current
    val (versionName, versionCode) = remember {
        try {
            val packageInfo = context.packageManager.getPackageInfo(
                context.packageName,
                0
            )
            packageInfo.versionName to packageInfo.longVersionCode
        } catch (e: Exception) {
            "Unknown" to 0L
        }
    }
    Text(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(8.dp),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        ), color = Color.Gray, text = "application version $versionName.$versionCode"
    )
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}