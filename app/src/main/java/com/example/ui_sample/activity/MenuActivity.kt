package com.example.ui_sample.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.ui_sample.DialogSampleFragment
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionBar?.hide()

        binding.tbrToolbar.title = "Toolbar"
        binding.tbrToolbar.setTitleTextColor(Color.WHITE)
        binding.tbrToolbar.setBackgroundColor(getColor(R.color.purple_500))

        //Toolbar를 App bar(Actionbar)로 지정
        setSupportActionBar(binding.tbrToolbar)

        registerForContextMenu(binding.btnMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.first -> {
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show()
            }
            R.id.second -> {
                Toast.makeText(this, "second", Toast.LENGTH_SHORT).show()
            }
        }

        return true
    }

    //context menu 여러 개 가능한지?
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.context_first -> {
                Toast.makeText(this, "first", Toast.LENGTH_SHORT).show()
            }
            R.id.context_second -> {
                Toast.makeText(this, "second", Toast.LENGTH_SHORT).show()
            }
        }

        return true
    }
}