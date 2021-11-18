package com.example.ui_sample.util

import java.text.SimpleDateFormat
import java.util.*

object MyDateUtil {
    const val HYPHEN = "yyyy-MM-dd"
    const val SLASH = "yy/MM/dd"
    const val HANGUEL = "yyyy년 MM월 dd일"
    const val COLONE = "yyyy:MM:dd"

    fun getDate(format: String) : String {
//        return when(format) {
//            HYPHEN -> SimpleDateFormat(HYPHEN, Locale.KOREA).format(date)
//            SLASH -> SimpleDateFormat(SLASH, Locale.KOREA).format(date)
//            HANGUEL -> SimpleDateFormat(COLONE, Locale.KOREA).format(date)
//            else -> SimpleDateFormat(format, Locale.KOREA).format(date)
//        }
        println(SimpleDateFormat("yyyy:MM:dd:HH:mm", Locale.FRANCE).format(Date()))
        return SimpleDateFormat(format, Locale.KOREA).format(Date())
    }


    /*
    패턴 의미 출력
    G 연대(BC, AD) AD
    y 년도 2017
    M 월(1~12) 12
    w 해당 년도의 몇 번째 주(1~53) 52
    W 해당 월의 몇 번째 주(1~5) 5
    D 해당 연도의 몇 번째 일(1~366) 364
    d 해당 월의 몇 번째 일(1~31) 30
    F 해당 월의 몇 번째 요일(1~5) 5
    E 요일(월~일) Sat
    a 오전/오후(AM, PM) PM
    H 시간(0~23) 21 h 시간(1~12) 9
    K 시간(0~11) 9 k 시간(1~24) 21
    m 분(0~59) 31 s 초(0~59) 8
    S 1/1000초(0~999) 297
    Z 타임존 +0900
    z 타임존(RFC 822) KST
     */
}