package com.unimicron.chapter14

object FuncParameter {
  def main(args: Array[String]): Unit = {
    def plus(x: Int) = 3 + x

    val res1 = Array(1, 2, 3, 4).map(plus) // Array(1, 2, 3, 4).map(plus(_))
    println(res1.mkString(","))

    // Scala中，函數也是有類型，比如plus就是<function1>
    // 根據參數個數決定函數的類型: function 1, function2, function 3, ...
    // plus _: 不執行, plus: 執行
    println("Type of plus: " + plus _)
  }
}
