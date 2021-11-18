package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivityDoubleTabBinding
import com.example.ui_sample.listener.OnDoubleTabListener
import com.example.ui_sample.listener.OnTabListener

class DoubleTabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDoubleTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoubleTabBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.addFlags(WindowManager.LayoutParams.FLAG_SECURE)

        binding.viewGradient.setOnClickListener(object : OnTabListener() {
            override fun onDoubleTab(v: View?) {
                Toast.makeText(v?.context, "Double Tab", Toast.LENGTH_SHORT).show()
            }
        })

        binding.btnTab.setOnClickListener(object : OnTabListener() {
            override fun onDoubleTab(v: View?) {
                Toast.makeText(v?.context, "Double Tab", Toast.LENGTH_SHORT).show()
            }
        })
//        binding.btnTab.setOnTouchListener(object : OnDoubleTabListener() {
//            override fun onDoubleTab(v: View?) {
//                Toast.makeText(this@DoubleTabActivity, "Double Tab", Toast.LENGTH_SHORT).show()
//            }
//        })
    }
}