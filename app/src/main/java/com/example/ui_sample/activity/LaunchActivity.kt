package com.example.ui_sample.activity

import com.example.ui_sample.activity.*
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivityLaunchBinding

class LaunchActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLaunchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLaunchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        binding.toolbar.title = "UI"
        binding.toolbar.setTitleTextColor(Color.WHITE)
        binding.toolbar.setBackgroundColor(getColor(R.color.purple_700))
        setSupportActionBar(binding.toolbar)
        showDialog()
        binding.btnSelect.setOnClickListener { showDialog() }
        binding.btnSelect.setOnLongClickListener {
            startActivity(Intent(this, ViewPagerSampleActivity::class.java))
            true
        }
    }

    private fun showDialog() {
        val dlg = AlertDialog.Builder(this)
        val items = arrayOf("Refresh Layout", "Ripple", "Layouts", "Dialog", "Menu", "Selector", "SwipeTab", "Tab", "Progress Bar", "Spannable & Linkfy", "SeekBar")
        dlg.setItems(items, DialogInterface.OnClickListener {dialog, which ->
            when(which) {
                0 -> { startActivity(Intent(this, MainActivity::class.java)) }
                1 -> { startActivity(Intent(this, RippleActivity::class.java)) }
                2 -> { startActivity(Intent(this, RippleActivity::class.java)) }
                3 -> { startActivity(Intent(this, CustomActivity::class.java)) }
                4 -> { startActivity(Intent(this, MenuActivity::class.java)) }
                5 -> { startActivity(Intent(this, SelectorActivity::class.java)) }
                6 -> { startActivity(Intent(this, SwipeTabActivity::class.java)) }
                7 -> { startActivity(Intent(this, DoubleTabActivity::class.java)) }
                8 -> { startActivity(Intent(this, ProgressbarActivity::class.java)) }
                9 -> { startActivity(Intent(this, SpannableActivity::class.java)) }
                10 -> { startActivity(Intent(this, SeekbarActivity::class.java)) }
            }
        })
        dlg.setNegativeButton("취소", null)
        dlg.setCancelable(false)
        dlg.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.launch_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.launch_1 -> Toast.makeText(this, "Launch1", Toast.LENGTH_SHORT).show()
            R.id.launch_2 -> Toast.makeText(this, "Launch2", Toast.LENGTH_SHORT).show()
            R.id.launch_3 -> Toast.makeText(this, "Launch3", Toast.LENGTH_SHORT).show()
            R.id.launch_4 -> {
//                val popup = PopupMenu(this, currentFocus)
//                menuInflater.inflate(R.menu.launch_menu_2, popup.menu)
//                popup.setOnMenuItemClickListener {
//                    when(item.itemId) {
//                        R.id.launch2_1 -> { }
//                        R.id.launch2_2 -> { }
//                        R.id.launch2_3 -> { }
//                    }
//
//                    return@setOnMenuItemClickListener true
//                }
//                popup.show()
            }
        }

        return true
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