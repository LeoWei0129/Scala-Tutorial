package com.unimicron.chapter13

object MatchVariableDemo {
  def main(args: Array[String]): Unit = {
    val ch = 'v'

    ch match {
      case '+' => println("ok")
      // case mychar定義是mychar = ch
      // 這種 case 變量 的情況是一定會匹配到的，無條件匹配
      case mychar => println("match variable: " + mychar)
      case _ => println("match error")
    }

    // match是一個表達式，因此可以有返回值
    // 會把匹配到case對應的代碼塊中的最後一行作為返回值給變量res(如果是println()，返回值為())
    val ch1 = '+'
    val res = ch1 match {
      case '+' => ch1 + " Hello"
      // case mychar定義是mychar = ch
      // 這種 case 變量 的情況是一定會匹配到的，無條件匹配
      case mychar => println("match variable: " + mychar)
      case _ => println("match error")
    }
    println(res)
  }
}
