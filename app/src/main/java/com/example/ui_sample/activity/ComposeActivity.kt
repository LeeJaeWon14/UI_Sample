package com.example.ui_sample.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Text("Hello World!")
            MessageCard("Jeep Chief")
        }
    }

    @Composable
    private fun MessageCard(msg: String) {
        Text(text = "Hello $msg!")
    }
}