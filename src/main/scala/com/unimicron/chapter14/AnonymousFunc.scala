package com.unimicron.chapter14

object AnonymousFunc {
  def main(args: Array[String]): Unit = {
    // 匿名函數說明
    // 1. 不需要寫 def 函數名
    // 2. 不需要寫返回類型，編譯器會自動類型推導，寫了反而報錯
    // 3. = 變成 =>
    //4. 如果有多行，使用{}
    val triple = (x: Double) => x + 3
    println(triple(5))

    // 編寫一個匿名函數，可以返回2個整數的和，並輸出該匿名函數的類型
    // 此時f1就是匿名函數
    val f1 = (x: Int, y: Int) => {
      println("匿名函數被調用")
      x + y
    }

    println("f1的類型: " + f1)
    println(f1(10, 20))
  }
}
