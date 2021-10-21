package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.ui_sample.R

class ColorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color)

        val layout = findViewById<LinearLayout>(R.id.cl_colorLayout)

        var count = 0
        layout.setOnClickListener {
            when(count) {
                0 -> {
                    count = 1
                    layout.setBackgroundColor(getColor(R.color.black))
                    Toast.makeText(this, "!!!", Toast.LENGTH_SHORT).show()
                }
                1 -> {
                    count = 2
                    layout.setBackgroundColor(getColor(R.color.black_70))
                }
                2 -> {
                    count = 0
                    layout.setBackgroundColor(ContextCompat.getColor(this, R.color.black_30))
                }
            }
        }
    }
}