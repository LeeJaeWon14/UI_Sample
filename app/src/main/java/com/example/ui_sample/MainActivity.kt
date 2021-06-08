package com.example.ui_sample

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_sample.adapter.MyRecyclerAdapter
import com.example.ui_sample.databinding.ActivityMainBinding
import com.example.ui_sample.databinding.InitDialogLayoutBinding

class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding
        get() = _binding!!
    private var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.refresh.setProgressBackgroundColorSchemeColor(getColor(R.color.purple_500))
        binding.refresh.setColorSchemeColors(Color.WHITE)
        binding.refresh.setOnRefreshListener {
            binding.recycler.adapter!!.notifyDataSetChanged()
            binding.refresh.isRefreshing = false
        }

        showInitDialog()
    }

    private fun initRecycler(count : Int) {
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = MyRecyclerAdapter(count)
    }

    private fun showInitDialog() {
        val dlgView = InitDialogLayoutBinding.inflate(layoutInflater)
        val dlg = AlertDialog.Builder(this).create()
        dlg.setView(dlgView.root)

        dlgView.btnInput.setOnClickListener {
            count = dlgView.edtInputCount.text.toString().toInt()
            initRecycler(count)
            dlg.dismiss()
        }

        dlg.show()
    }
}