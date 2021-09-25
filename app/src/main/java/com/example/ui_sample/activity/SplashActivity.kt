package com.example.ui_sample.activity

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_sample.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val media = MediaPlayer.create(this, R.raw.test)
//        media.start()
//
//        media.setOnCompletionListener {
//
//        }
        Handler(Looper.getMainLooper()).postDelayed(
                Runnable { startActivity(Intent(this, LaunchActivity::class.java)) }, 2000
        )
    }
}