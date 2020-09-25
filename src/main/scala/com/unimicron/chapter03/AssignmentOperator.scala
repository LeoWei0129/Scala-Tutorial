package com.unimicron.chapter03

object AssignmentOperator {
  def main(args: Array[String]): Unit = {
    var num = 2
    num <<= 2
    println(num)
    num >>= 1
    println(num)

    // Scala也支持代碼塊返回值
    val res = {
      if (num > 1) "Hello World" else 100
    }
    println(res)

    // 兩個變量交換值，不經過中間變量
    var a = 10
    var b = 20
    a = a + b
    b = a - b // a
    a = a - b // b
  }
}
