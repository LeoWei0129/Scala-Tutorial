package com.unimicron.chapter13

object MatchDemo {
  def main(args: Array[String]): Unit = {
    val oper = 3
    val n1 = 20
    val n2 = 10
    var res = 0

    // match(類似於switch)和case是關鍵字
    // => 匹配成功後執行的語句，可以是代碼塊(多行)
    // 匹配的順序是從上到下，匹配到一個就執行對應的代碼
    // => 後面的代碼塊不需要寫break，會自動退出match
    // 如果任何一個都沒有匹配成功，會執行case _的部分
    oper match {
      case '+' => {
        res = n1 + n2
      }
      case '-' => res = n1 - n2
      case '*' => res = n1 * n2
      case '/' => res = n1 / n2
      case 1 => println("match 1")
      case 1.1 => println("match list")
      case _ => println("oper error")
    }
    println("res = " + res)
  }
}
