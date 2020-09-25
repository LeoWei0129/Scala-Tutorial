package com.unimicron.chapter13

object MatchIfDemo {
  def main(args: Array[String]): Unit = {
    println('!'.toInt)
    // 對"+-3!"進行遍歷
    for (ch <- "+-3!") {
      // 每次遍歷的ch的type是Char
      var sign = 0
      var digit = 0
      ch match {
        case '+' => sign = 1
        case '-' => sign = -1
        // 如果case後有條件守衛if，那麼這時的_不是表示默認匹配
        // 而是表示忽略傳入的ch，並且之後要走if條件來判斷匹配
        case _ if (ch.toString.equals("3")) => digit = 3
        case _ if ch.toInt > 50 => println("int comparison")
        case _ => sign = 3
      }
      println("---------------")
      println("sign = " + sign + "\t" + "digit = " + digit)
    }
  }
}
