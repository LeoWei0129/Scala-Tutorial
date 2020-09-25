package com.unimicron.chapter04

object WhileDemo {
  def main(args: Array[String]): Unit = {
    // 1. 外部定義循環變量
    var i = 0
    // 2. While迴圈中定義循環條件
    while (i < 10) {
      // 定義循環體
      println(i)
      // 迭代循環變量
      i = i + 1
    }

    // 與if不同，while本身沒有返回值，即整個while語句的結果是Unit類型的{}
    // 因為while / do-while 沒有返回值，所以使用該語句來計算並返回結果時，不可避免地要使用到變量，而變量需要聲明在while外部
    // 那麼就等同while / do-while 的內部變量影響了外部變量，所以作者推薦使用for

    // Scala也支持do-while
    do {
      println(i)
      i += 1
    } while (i < 20)
  }
}
