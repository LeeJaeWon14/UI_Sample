package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.isVisible
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivityProgressbarBinding

class ProgressbarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProgressbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgressbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnProgressShow.setOnClickListener {
//                pbProgress.isVisible = true
//                Handler(Looper.getMainLooper()).postDelayed(Runnable {
//
////                    Thread.sleep(1500)
//                    pbProgress.isVisible = false
//                }, 1500)

                pbProgress.run { isVisible = !isVisible }
            }
        }
    }
}