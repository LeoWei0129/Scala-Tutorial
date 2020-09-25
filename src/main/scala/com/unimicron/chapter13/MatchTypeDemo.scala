package com.unimicron.chapter13

object MatchTypeDemo {
  def main(args: Array[String]): Unit = {
    val a = 3
    // obj實例的類型根據a的值來返回
    val obj = if (a == 1) 1
    else if (a == 2) "2"
    else if (a == 3) BigInt(3)
    else if (a == 4) Map("aa" -> 4)
    else if (a == 5) Map(5 -> "aa")
    else if (a == 6) Array(1, 2, 3, 4, 5, 6)
    else if (a == 7) Array(7, 5, 3, 1)
    else if (a == 8) Array(1, 2, 4, 8)

    // 根據obj的類型來匹配(obj給到case後的變量名，並透過接著的":"進行類型匹配判斷)
    // 可以在=>後直接寫變量名，代表返回obj，此時這個match-case單純做類型驗證
    val res = obj match {
      case _: Map[String, Int] => "只進行類型匹配判斷，隱藏變量，不使用"
      case a: Int => a
      case b: Map[String, Int] => "對象是一個字符串-數字的Map集合"
      case c: Map[Int, String] => "對象是一個數字-字符串的Map集合"
      case d: Array[String] => "對象是一個字符串數組"
      case e: Array[Int] => "對象是一個數字數組"
      case f: BigInt => Int.MaxValue
      case _ => "Type mismatch"
    }
    println(res)
  }
}
