package com.example.ui_sample.listener

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.View
import android.widget.Toast

abstract class OnTabListener : View.OnClickListener {
    // 더블탭 시간 간격
    private val INTERVAL: Long = 500
    // 마지막 탭 시간
    private var lastTabTime: Long = 0
    private val tabHandler = Handler(Looper.getMainLooper())
//    abstract fun onSingleTab(v: View?)
    abstract fun onDoubleTab(v: View?)
    override fun onClick(v: View?) {
//        val singleTabRunnable = Runnable {
//            onSingleTab(v)
//        }

        // 탭한 시간
        val currentTabTime = SystemClock.uptimeMillis()
        // 이전에 탭한 시간과 현재시간 차이 계산
        val intervalTab = currentTabTime - lastTabTime
        // 마지막 탭 시간 업데이트
        lastTabTime = currentTabTime

//        if(intervalTab <= INTERVAL) {
//            if(tabHandler.hasCallbacks(singleTabRunnable)) {
//                tabHandler.removeCallbacks(singleTabRunnable)
//                onDoubleTab(v)
//            } else {
//                Toast.makeText(v?.context, "not have callbacks", Toast.LENGTH_SHORT).show()
//            }
//        }
//        else {
//            tabHandler.postDelayed(singleTabRunnable, INTERVAL)
//            if(tabHandler.hasCallbacks(singleTabRunnable)) {
//                Toast.makeText(v?.context, "have callbacks", Toast.LENGTH_SHORT).show()
//            } else {
//                Toast.makeText(v?.context, "not have callbacks", Toast.LENGTH_SHORT).show()
//            }
//        }

        if(intervalTab <= INTERVAL) {
            onDoubleTab(v)
        }
    }
}