package com.example.ui_sample.activity

import com.example.ui_sample.activity.*
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        val items = arrayOf("Refresh Layout", "Ripple", "Layouts", "Dialog", "Menu", "Selector")
        dlg.setItems(items, DialogInterface.OnClickListener {dialog, which ->
            when(which) {
                0 -> { startActivity(Intent(this, MainActivity::class.java)) }
                1 -> { startActivity(Intent(this, RippleActivity::class.java)) }
                2 -> { startActivity(Intent(this, RippleActivity::class.java)) }
                3 -> { startActivity(Intent(this, CustomActivity::class.java)) }
                4 -> { startActivity(Intent(this, MenuActivity::class.java)) }
                5 -> { startActivity(Intent(this, SelectorActivity::class.java)) }
            }
        })
        dlg.setNegativeButton("취소", null)
        dlg.setCancelable(false)
        dlg.show()
    }

    private var time : Long = 0
    override fun onBackPressed() { //뒤로가기 클릭 시 종료 메소드
        if(System.currentTimeMillis() - time >= 2000) {
            time = System.currentTimeMillis()
            Toast.makeText(this@LaunchActivity, "한번 더 누르면 종료합니다", Toast.LENGTH_SHORT).show()
        }
        else if(System.currentTimeMillis() - time < 2000) {
            this.finishAffinity()
        }
    }
}