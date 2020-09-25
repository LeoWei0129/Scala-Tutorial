package com.unimicron.chapter13

object MatchVariableDefDemo {
  def main(args: Array[String]): Unit = {
    // match中每一個case都可以單獨提取出來
    // 可以在一行中賦值給多個變量
    val (x, y) = (1, 2)
    val (q, r) = BigInt(10) /% 3 // 較少用
    val arr = Array(1, 2, 3, 4, 5)
    val Array(first, second, _*) = Array(6, 7, 8, 9, 10) // 提取出數組中的前兩個元素

    println(x, y)
    println(q, r)
    println(arr)
    println(first, second)
  }
}
