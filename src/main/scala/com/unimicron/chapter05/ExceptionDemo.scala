package com.unimicron.chapter05

object ExceptionDemo {
  def main(args: Array[String]): Unit = {
    try {
      val r = 10 / 0
    } catch {
      // 1. Scala中只有一個catch
      // 2. catch中有多個case，每個case可以匹配一種異常
      // 3. => 關鍵符號，表示後面是對該異常的處理代碼塊
      // 4. finally是最終必定要執行的
      case ex: ArithmeticException => {
        println("abc")
        println("def")
      }
      case ex: Exception => println("ghi")
    } finally { // 通常做資源回收/分配
      println("jkl")
    }

    println("mno")
  }
}
