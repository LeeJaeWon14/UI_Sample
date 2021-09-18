package com.example.ui_sample.activity

import android.content.DialogInterface
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

        binding.btnDialog.setOnClickListener {
            val dlg = AlertDialog.Builder(this)
                .setMessage("Dialog!")
                .setPositiveButton("확인", object : DialogInterface.OnClickListener {
                    override fun onClick(p0: DialogInterface?, p1: Int) {
                        Toast.makeText(this@CustomActivity, "Dialog!", Toast.LENGTH_SHORT).show()
                    }

                })
                .show()
        }

        binding.btnCustomDialog.setOnClickListener {
            //Toast.makeText(this, "Dialog", Toast.LENGTH_SHORT).show()
            val dlgView = CustomDialogBinding.inflate(layoutInflater)
            val dlg = AlertDialog.Builder(this).create()
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