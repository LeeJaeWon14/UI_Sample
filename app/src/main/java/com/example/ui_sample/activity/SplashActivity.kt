package com.example.ui_sample.activity

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_sample.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val videoHolder = VideoView(this)
            setContentView(videoHolder)
            val video = Uri.parse("android.resource://${packageName}/${R.raw.test}")
            videoHolder.setVideoURI(video)

            videoHolder.setOnCompletionListener {
                jump()
            }
            videoHolder.start()
        } catch (e : Exception) {
            e.printStackTrace()
            jump()
        }
    }

    private fun jump() {
        startActivity(Intent(this, LaunchActivity::class.java))
        finish()
    }
}