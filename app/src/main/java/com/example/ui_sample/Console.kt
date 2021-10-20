package com.example.ui_sample

fun main() {
    var a = 2
    var b = 1

    a = readLine()?.toInt()!!
    b = readLine()?.toInt()!!
//    val c = a > b ? "bigger a" : "bigger b"


    val c = if (a > b) "bigger a" else "bigger b"

    print(c)


}