package com.example.ui_sample

import com.example.ui_sample.util.MyDateUtil

fun main() {
//    var a = 2
//    var b = 1
//
//    a = readLine()?.toInt()!!
//    b = readLine()?.toInt()!!
////    val c = a > b ? "bigger a" : "bigger b"
//
//
//    val c = if (a > b) "bigger a" else "bigger b"

//    println(c)

//    ConstClass("Hi", 2, 50)
    ConstClass("Hi", 2, 50, 50.05).test(testPrint)
    println(testPrint.invoke("22"))

    val x = 18
    var test: Int = run {
        var arr = x.toString().toCharArray()
        arr[0].toString().toInt() + arr[1].toString().toInt()
    }
    println(test)

    val arr1 = arrayOf(1, 2, 3)
    val arr2 = intArrayOf(1, 2, 3)
    arr1.toIntArray()
    arr2.toTypedArray()

//    println(MyDateUtil.getDate(MyDateUtil.COLONE))
//    println(MyDateUtil.getDate(MyDateUtil.HANGUEL))
//    println(MyDateUtil.getDate(MyDateUtil.HYPHEN))
//    println(MyDateUtil.getDate(MyDateUtil.SLASH))
    println(MyDateUtil.getDate("yyyy년 MM월 dd일 E요일"))
}

class ConstClass {
    constructor(name: String, val_1: Int, val_2: Int) {
        println("$name / $val_1 / $val_2")
        test {
            true
        }
    }

    constructor(name: String, val_1: Int, val_2: Int, val_3: Double) {
        println("$name / $val_1 / $val_2 / $val_3")
    }

    fun test(func : (message: Any?) -> Boolean) {
        func.invoke("1")
    }
}

val testPrint : (message: Any?) -> Boolean = {
    println(it)
    true
}

var egg = 1
var milk = 1
fun func() {
    if(egg > 0) {
        milk = 6
    }
    else {
        milk = 1
    }
}