package com.unimicron.chapter03

object OperatorDemo {
  def main(args: Array[String]): Unit = {
    var r1: Int = 10 / 3 // 3
    var r2: Double = 10 / 3 // 3.0，兩邊都是整數時，做整數除法，再轉乘Double
    var r3: Double = 10.0 / 3 // 3.33333...
    println(r3.formatted("%.2f")) // 3.33

    println(10 % 3)
    println(-10 % 3)
    println(10 % -3)
    println(-10 % -3)

    // Scala中沒有++和--，只有+=和-=
    var num1 = 10
    num1 += 10
    println("num1= " + num1)
  }
}
