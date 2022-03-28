package com.example.ui_sample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_sample.databinding.ActivityCustomKeypadBinding

class CustomKeypadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomKeypadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}