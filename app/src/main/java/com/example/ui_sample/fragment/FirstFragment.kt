package com.example.ui_sample.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ui_sample.R
import com.example.ui_sample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding : FragmentFirstBinding? = null
    private val binding
        get() = _binding!!
    companion object {
        fun newInstance(page : Int) : FirstFragment {
            val fragment = FirstFragment()
            val args = Bundle()
            args.putInt("page", page)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        when(requireArguments().get("page")) {
            0 -> binding.tvFragTitle.text = getString(R.string.str_first_fragment)
            1 -> binding.tvFragTitle.text = getString(R.string.str_second_fragment)
            2 -> binding.tvFragTitle.text = getString(R.string.str_third_fragment)
            3 -> binding.tvFragTitle.text = "4"
            4 -> binding.tvFragTitle.text = "5"
            5 -> binding.tvFragTitle.text = "6"
            6 -> binding.tvFragTitle.text = "7"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}