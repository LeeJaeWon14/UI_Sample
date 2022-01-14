package com.example.ui_sample.activity

import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import com.example.ui_sample.databinding.ActivitySeekbarBinding

class SeekbarActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeekbarBinding
    private var volume: Int = 0
    private var volumeMax = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeekbarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
        binding.apply {
            volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
            volume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)

            sbVolume.apply {
                max = volumeMax
                progress = volume
                setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        audioManager.setStreamVolume(
                            AudioManager.STREAM_MUSIC,
                            progress,
                            0
                        )
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        //
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        //
                    }
                })
            }
        }
    }
}