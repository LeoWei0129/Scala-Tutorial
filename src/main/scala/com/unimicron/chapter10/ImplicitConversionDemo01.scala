package com.unimicron.chapter10

object ImplicitConversionDemo01 {
  def main(args: Array[String]): Unit = {
    // 編寫一個隱式函數，用作Double -> Int 轉換
    // 隱式函數應當在作用域才能生效
    implicit def f1(d: Double): Int = { // 底層生成f1$1()
      d.toInt
    }

    implicit def f2(d: Float): Int = {
      d.toInt
    }

    def test(n1: Int): Unit = {
      println("ok")
    }

    // 必須保證隱式函數的匹配只能式唯一的，f2和f3不能衝突
//    implicit def f3(d2: Float): Int = {
//      d2.toInt
//    }

    val num1: Int = 3.5 // 底層編譯int num1 = f1$1(3.5)
    val num2: Int = 4.5f

    println(num1)
    println(num2)

    test(10.5)
  }
}


