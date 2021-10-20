package com.example.ui_sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.ui_sample.R
import com.example.ui_sample.adapter.MyPagerAdapter
import com.example.ui_sample.databinding.ActivitySwipeTabBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class SwipeTabActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySwipeTabBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySwipeTabBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val tabTitle = arrayOf("First", "Second", "Third", "four", "five", "six", "seven")
        binding.viewPager.adapter = MyPagerAdapter(this, tabTitle.size)
        TabLayoutMediator(binding.tabLayout, binding.viewPager, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                // 각 tab에 독립된 view를 지정 가능 (customView)
//                val tabView = TextView(this@SwipeTabActivity)
//                tabView.setText(tabTitle[position])
//                tabView.setTextColor(getColor(R.color.black))
//                tabView.textAlignment = View.TEXT_ALIGNMENT_CENTER
//                tab.customView = tabView

                // 기본적으로 tab은 하이라이팅을 지원, text 대신 icon으로 이미지 지정도 가능
                tab.text = tabTitle[position]
//                tab.icon = getDrawable(R.drawable.ic_launcher_foreground)
            }
        }).attach()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                // ViewPager를 Swipe할 때
                super.onPageSelected(position)
//                binding.tabLayout.getTabAt(position)?.text = tabTitle[position]
            }
        })

        binding.tabLayout.setSelectedTabIndicatorColor(getColor(R.color.purple_700))
    }
}