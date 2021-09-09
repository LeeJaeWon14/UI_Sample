package com.example.ui_sample.activity

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivityRippleBinding

class RippleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRippleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRippleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
}