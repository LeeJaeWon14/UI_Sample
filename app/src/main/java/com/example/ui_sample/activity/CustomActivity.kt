package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.ui_sample.DialogSampleFragment
import com.example.ui_sample.R
import com.example.ui_sample.databinding.ActivityCustomDialogBinding
import com.example.ui_sample.databinding.CustomDialogBinding

class CustomActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCustomDialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomDialogBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.btnCustomDialog.setOnClickListener {
            //Toast.makeText(this, "Dialog", Toast.LENGTH_SHORT).show()
            val dlgView = CustomDialogBinding.inflate(layoutInflater)
            val dlg = AlertDialog.Builder(this, R.style.dialog_fullscreen).create()
            dlg.window?.setBackgroundDrawableResource(R.drawable.button)
            dlg.setView(dlgView.root)

            dlgView.btnCustomDialog.setOnClickListener {
                dlg.dismiss()
            }

            dlg.show()
        }

        binding.btnCustomFragment.setOnClickListener {
            DialogSampleFragment().show(supportFragmentManager, "DialogFragmentSample")
        }
    }
}