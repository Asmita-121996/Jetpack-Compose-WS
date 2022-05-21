package com.enjaymobile.jetpackapp

import android.content.Context
import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight.Companion.ExtraBold
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

class LoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CreateLayout()
        }
    }
}

@Preview(showBackground = true,uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    CreateLayout()
}

@Composable
fun CreateLayout() {
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
            modifier = Modifier.size(180.dp)
        )

        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Shop Your Taste",
            style = TextStyle(color = colorResource(id = R.color.colorPrimaryDark)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 20.dp, 20.dp, 20.dp),
            fontSize = 22.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = ExtraBold,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(20.dp))


        val username = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = username.value,
            onValueChange = {
                username.value = it
                when {
                    username.value.text.isEmpty() -> {

                    }
                    else -> {

                    }

                }
            },
            label = { Text(text = "Enter username", fontFamily = FontFamily.Serif) },
            maxLines = 1, singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.colorPrimaryDark),
                unfocusedBorderColor = colorResource(id = R.color.grey),
                cursorColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        val password = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = password.value, onValueChange = { password.value = it },
            label = { Text(text = "Enter password", fontFamily = FontFamily.Serif) },
            maxLines = 1, singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.colorPrimaryDark),
                unfocusedBorderColor = colorResource(id = R.color.grey),
                cursorColor = colorResource(id = R.color.black)
            )
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(
            onClick = {
                loginClickAction(context)
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
                text = "Login", fontSize = 16.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = ExtraBold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif
            )
        }

        Row() {
            Text(
                text = "Do not have Account ?",
                style = TextStyle(color = colorResource(id = R.color.colorPrimaryDark)),
                modifier = Modifier
                    .padding(20.dp, 20.dp, 0.dp, 20.dp),
                fontSize = 12.sp,
                fontStyle = FontStyle.Normal,
                fontWeight = ExtraBold,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.Serif
            )
            ClickableText(
                text = AnnotatedString("Sign Up Now"),
                modifier = Modifier
                    .padding(5.dp, 20.dp, 20.dp, 20.dp),
                style = TextStyle(
                    color = colorResource(id = R.color.colorPrimaryDark),
                    textDecoration = TextDecoration.Underline,
                    fontSize = 12.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = ExtraBold,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.Serif
                ),
                softWrap = true, overflow = TextOverflow.Clip,
                maxLines = 1, onClick = {
                    signUpClickAction(context)
                }

            )
        }

        Spacer(modifier = Modifier.height(30.dp))

    }
}

fun loginClickAction(context: Context) {
    Log.e("Asmita==>", " context = $context")
    val intent = Intent(context, ListActivity::class.java)
    startActivity(context, intent, null)
}

fun signUpClickAction(context: Context) {
    Log.e("Asmita==>", " context = $context")
    val intent = Intent(context, RegisterActivity::class.java)
    startActivity(context, intent, null)
}


