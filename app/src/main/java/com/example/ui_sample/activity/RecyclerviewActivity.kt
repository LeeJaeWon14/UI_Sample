package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_sample.R
import com.example.ui_sample.adapter.MyRecyclerAdapter
import com.example.ui_sample.databinding.ActivityRecyclerviewBinding
import com.example.ui_sample.databinding.InitDialogLayoutBinding
import com.example.ui_sample.databinding.InitDialogLayoutRvBinding

class RecyclerviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showInitDialog()
    }

    fun showInitDialog() {
        val dlgView = InitDialogLayoutRvBinding.inflate(layoutInflater)
        val dlg = AlertDialog.Builder(this).create()
        dlg.setView(dlgView.root)

        var layout = ""
        dlgView.apply {
            btnInput.setOnClickListener {
                val count = dlgView.edtInputCount.text.toString().toInt()
                initRecycler(count, layout)
                dlg.dismiss()
            }

            rgRecycle.apply {
                setOnCheckedChangeListener { radioGroup: RadioGroup, id: Int ->
                    layout = when(id) {
                        R.id.rb_linear_horizontal -> "Linear_Horizontal"
                        R.id.rb_linear_vertical -> "Linear_Vertical"
                        R.id.rb_grid_horizontal -> "Grid_Horizontal"
                        R.id.rb_grid_vertical -> "Grid.Vertical"
                        else -> "0" /* no-op */
                    }
                }
            }
        }

        dlg.show()
    }

    private fun initRecycler(count : Int, layout: String) {
        binding.rvRecycle.layoutManager = when(layout) {
            "Linear_Horizontal" -> {
                LinearLayoutManager(this).apply { orientation = LinearLayoutManager.HORIZONTAL }
            }
            "Linear_Vertical" -> {
                LinearLayoutManager(this).apply { orientation = LinearLayoutManager.VERTICAL }
            }
            "Grid_Horizontal" -> {
                GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false)
            }
            "Grid.Vertical" -> {
                GridLayoutManager(this, 2)
            }
            else -> { null /* no-op */ }
        }

        binding.rvRecycle.adapter = MyRecyclerAdapter(count)
    }
}