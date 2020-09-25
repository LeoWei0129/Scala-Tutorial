package com.unimicron.chapter01

// 只要看到有object TestScala，可以理解為
// 1. object TestScala對應的是一個TestScala$中的一個靜態對象MODULE$
// 2. 在程式中是一個單例對象
// 可以使用Java模擬Scala運行機制代碼
object TestScala {
  def main(args: Array[String]): Unit = {
    println("Hello, Scala, idea...")
  }
}
