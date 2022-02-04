package com.example.ui_sample.activity

import android.content.ClipData
import android.content.ClipDescription.MIMETYPE_TEXT_PLAIN
import android.content.ClipboardManager
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import com.example.ui_sample.R
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
        val clipManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
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

                        // progress is display to percentage
                        tvVolume.text = (progress * 6.7).toInt().toString().plus("%")
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        //
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        //
                    }
                })
            }

            checkPaste(clipManager)
            tvClipboard.text = getString(R.string.app_name)
            tvClipboard.setOnClickListener {
                val clip = ClipData.newPlainText("simple text", (it as TextView).text)
                clipManager.setPrimaryClip(clip)
                Toast.makeText(this@SeekbarActivity, "클립보드에 복사되었습니다.", Toast.LENGTH_SHORT).show()
                checkPaste(clipManager)
            }

            btnClipboard.setOnClickListener {
                tvClipboard.text = clipManager.primaryClip?.getItemAt(0)?.text
                Toast.makeText(this@SeekbarActivity, "${clipManager.primaryClip?.getItemAt(0)?.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkPaste(clipManager: ClipboardManager) {
        binding.btnClipboard.isEnabled = when {
            !clipManager.hasPrimaryClip() -> false
            !(clipManager.primaryClipDescription?.hasMimeType(MIMETYPE_TEXT_PLAIN))!! -> false
            else -> true
        }
    }
}