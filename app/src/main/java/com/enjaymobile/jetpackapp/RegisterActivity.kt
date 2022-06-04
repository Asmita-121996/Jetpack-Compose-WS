package com.enjaymobile.jetpackapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.enjaymobile.jetpackapp.ui.theme.JetpackAppTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackAppTheme {
                CreateRegisterLayout()
            }
        }
    }
}

@Composable
fun CreateRegisterLayout() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier
                .height(30.dp)
                .fillMaxWidth()
        )

        Image(
            painterResource(R.drawable.ic_online_shopping),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(120.dp)
        )

        Spacer(
            modifier = Modifier
                .height(10.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Shop Your Taste",
            style = TextStyle(color = colorResource(id = R.color.colorPrimaryDark)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 20.dp, 20.dp, 20.dp),
            fontSize = 20.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(10.dp))


        val username = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = username.value,
            onValueChange = {
                username.value = it
                when {
                    username.value.text.isEmpty() -> {

                    }else -> {

                    }
                }
            },
            label = {
                Text(
                    text = "Enter username",
                    fontFamily = FontFamily.Serif,
                    fontSize = 14.sp
                )
            },
            maxLines = 1, singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.colorPrimaryDark),
                unfocusedBorderColor = colorResource(id = R.color.grey),
                cursorColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(15.dp))
        val phoneNumber = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = phoneNumber.value, onValueChange = { phoneNumber.value = it },
            label = {
                Text(
                    text = "Enter Phone Number",
                    fontFamily = FontFamily.Serif,
                    fontSize = 14.sp
                )
            },
            maxLines = 1, singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.colorPrimaryDark),
                unfocusedBorderColor = colorResource(id = R.color.grey),
                cursorColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(15.dp))
        val email = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = email.value, onValueChange = { email.value = it },
            label = {
                Text(
                    text = "Enter Phone Number",
                    fontFamily = FontFamily.Serif,
                    fontSize = 14.sp
                )
            },
            maxLines = 1, singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.colorPrimaryDark),
                unfocusedBorderColor = colorResource(id = R.color.grey),
                cursorColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(15.dp))
        val password = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = password.value, onValueChange = { password.value = it },
            label = {
                Text(
                    text = "Enter password",
                    fontFamily = FontFamily.Serif,
                    fontSize = 14.sp
                )
            },
            maxLines = 1, singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.colorPrimaryDark),
                unfocusedBorderColor = colorResource(id = R.color.grey),
                cursorColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(15.dp))
        val confirm_password = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = confirm_password.value, onValueChange = { confirm_password.value = it },
            label = {
                Text(
                    text = "Confirm password",
                    fontFamily = FontFamily.Serif,
                    fontSize = 14.sp
                )
            },
            maxLines = 1, singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.colorPrimaryDark),
                unfocusedBorderColor = colorResource(id = R.color.grey),
                cursorColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(15.dp))


        Button(
            onClick = {
                registerClickAction(context)
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.colorPrimaryDark),
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(8.dp)
                .background(
                    colorResource(id = R.color.colorPrimaryDark),
                    RectangleShape
                ),
        ) {
            Text(
                text = "Register", fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

    }
}

fun registerClickAction(context: Context) {
    val intent = Intent(context, LoginActivity::class.java)
    startActivity(context, intent, null)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview1() {
    JetpackAppTheme {
        CreateRegisterLayout()
    }
}