package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ui_sample.R
import com.example.ui_sample.adapter.CoordinatorAdapter
import com.example.ui_sample.databinding.ActivityCoordinatorBinding
import com.example.ui_sample.databinding.DialogCoordinatorBinding

class CoordinatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoordinatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoordinatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dlg = AlertDialog.Builder(this).create()
        val view = View.inflate(this, R.layout.dialog_coordinator, null)
        val dlgBinding = DialogCoordinatorBinding.inflate(layoutInflater)
        dlg.setView(view)

        val button = view.findViewById<Button>(R.id.btn_coordinator)
        val edit = view.findViewById<EditText>(R.id.edt_input_coordinator)
        button.setOnClickListener {
            binding.rvCoordinator.apply {
                layoutManager = LinearLayoutManager(this@CoordinatorActivity)
                adapter = CoordinatorAdapter(edit.text.toString().toInt())
            }
            dlg.dismiss()
        }
        dlg.show()
    }
}