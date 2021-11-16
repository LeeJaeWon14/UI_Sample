package com.example.ui_sample.listener

import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.widget.Toast

abstract class OnDoubleTabListener : View.OnTouchListener {
    // 더블탭 시간 간격
    private val INTERVAL: Long = 500
    // 마지막 탭 시간
    private var lastTabTime: Long = 0
    abstract fun onDoubleTab(v: View?)

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if(event?.action == MotionEvent.ACTION_UP) {
            // 탭한 시간
            val currentTabTime = SystemClock.uptimeMillis()
            // 이전에 탭한 시간과 현재시간 차이 계산
            val intervalTab = currentTabTime - lastTabTime
            // 마지막 탭 시간 업데이트
            lastTabTime = currentTabTime

            if(intervalTab <= INTERVAL) {
                onDoubleTab(v)
                return true
            }
        }


        return false
    }
}