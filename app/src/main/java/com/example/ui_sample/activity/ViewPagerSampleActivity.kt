package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.ui_sample.R
import com.example.ui_sample.adapter.MyPagerAdapter
import com.example.ui_sample.databinding.ActivityViewPagerSampleBinding

class ViewPagerSampleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityViewPagerSampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerSampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager2.adapter = MyPagerAdapter(this, 3)
    }
}