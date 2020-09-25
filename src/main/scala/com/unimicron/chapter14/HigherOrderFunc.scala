package com.unimicron.chapter14

object HigherOrderFunc {
  def main(args: Array[String]): Unit = {
    def test(f: Double => Double, d: Double => Int, n1: Double) = {
      f(d(n1))
    }

    def sum(d: Double): Double = {
      d + d
    }

    def mod(d: Double): Int = {
      d.toInt % 2
    }

    // 將sum()的地址傳給參數f
    val res = test(sum, mod, 5)
    println(res) // 2.0

    // minusxy是高階函數，因為他返回匿名函數
    // 返回的匿名函數(y: Int) => x - y
    // 返回的匿名函數可以使用變量接收
    def minusxy(x: Int) = {
      (y: Int) => x - y // 匿名函數
    }

    // 分步執行
    // 1. res2就是(y: Int) => 3 - y
    def res2 = minusxy(3)
    println(res2(1)) // 3-1
    println(res2(5)) // 3-5

    // 也可以一步到位的調用(函數柯里化)
    // 先執行minusxy(5) => (y: Int) => 5 - y
    // 再執行上面匿名函數的部分: 5 - 8
    println(minusxy(5)(8)) // 5-8
  }
}
