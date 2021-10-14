package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivitySelectorBinding

class SelectorActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySelectorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectorBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}