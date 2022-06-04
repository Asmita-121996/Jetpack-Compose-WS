package com.enjaymobile.jetpackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enjaymobile.jetpackapp.ui.theme.JetpackAppTheme

class ListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    myapp()
                }
            }
        }
    }
}

@Composable
fun CreateListLayout(name: String) {
    Surface(color = MaterialTheme.colors.primary) {
        Text(text = "Hello $name!")
    }
}

@Composable
fun myapp(names: List<String> = listOf("World", "Jetpack", "Getlost")) {
    Column {
        for (name in names) {
            CreateListLayout(name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListLayoutPreview() {
    JetpackAppTheme {
        myapp()
    }
}