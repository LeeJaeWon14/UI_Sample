package com.example.ui_sample

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.ui_sample.databinding.FragmentDialogSampleBinding

class DialogSampleFragment : DialogFragment() {
    private lateinit var binding : FragmentDialogSampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //isCancelable = false
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDialogSampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(view.context, "Text", Toast.LENGTH_SHORT).show()
        binding.tvDialog.text = "it's Dialog Fragment Sample"
        binding.btnDialogClose.setOnClickListener {
            dismiss()
        }
    }
}