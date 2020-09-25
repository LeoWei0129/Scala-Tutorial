package com.unimicron.chapter12

object FoldDemo01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)

    def minus(n1: Int, n2: Int): Int = {
      n1 - n2
    }

    // 折疊的理解和化簡的運行機制幾乎一樣
    // 理解list.foldLeft(5)(minus) 理解成 先做list(5, 1, 2, 3, 4) 再做list.reduceLeft(minus)
    // 接下來的做法同ReduceDemo01.scala
    // minus()被調用4次
    println(list.foldLeft(5)(minus)) // 函數的柯里化: 把函數的多個參數分散開來傳遞, -5
    // 理解list.foldLeft(5)(minus) 理解成 先做list(1, 2, 3, 4, 5) 再做list.reduceLeft(minus)
    println(list.foldRight(5)(minus)) // 3
  }
}
