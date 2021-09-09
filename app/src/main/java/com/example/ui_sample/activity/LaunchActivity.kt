package com.example.ui_sample.activity

import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivityLaunchBinding

class LaunchActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLaunchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        showDialog()
        binding.btnSelect.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dlg = AlertDialog.Builder(this)
        val items = arrayOf("Refresh Layout", "Ripple")
        dlg.setItems(items, DialogInterface.OnClickListener {dialog, which ->
            when(which) {
                0 -> { startActivity(Intent(this, MainActivity::class.java)) }
                1 -> { startActivity(Intent(this, RippleActivity::class.java)) }
            }
        })
        dlg.setNegativeButton("취소", null)
        dlg.setCancelable(false)
        dlg.show()
    }
}