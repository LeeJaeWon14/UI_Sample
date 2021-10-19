package com.example.ui_sample.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ui_sample.fragment.FirstFragment

class MyPagerAdapter(fragmentActivity: FragmentActivity, private val count : Int) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return count
    }

    override fun createFragment(position: Int): Fragment {
        return FirstFragment.newInstance(position)
    }
}