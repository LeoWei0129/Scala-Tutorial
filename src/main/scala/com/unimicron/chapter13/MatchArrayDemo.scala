package com.unimicron.chapter13

import scala.collection.mutable.ArrayBuffer

object MatchArrayDemo {
  def main(args: Array[String]): Unit = {
    val arrs = Array(Array(0), Array(1, 2), Array(0, 1, 0),
      Array(2, 1, 3), Array(2, 0, 1, 3), Array(3, 4, 1, 0))

    for (arr <- arrs) {
      val res = arr match {
        case Array(0) => "0"
        case Array(1, 2) => "對應值匹配"
        case Array(x, y) => x + "\t" + y
        case Array(x, y, z) => x + "\t" + y + "\t" + z
        case Array(2, _*) => "array starts with 2"
        case _ => "match error"
      }
      println(res)
    }

    println("----------------------------")

    // 應用: 給定一個數組集合，如Array(10, 20)，使用默認匹配，返回Array(20, 10)
    for (arr <- arrs) {
      val res = arr match {
        case Array(x, y) => ArrayBuffer(y, x) // Array(y, x)
        case _ => "match error"
      }
      println(res)
      // 從res陣列中取值，如果直接println(res)得到的是數組對象的地址
//      if (res.isInstanceOf[ArrayBuffer]) {
//        println(res.asInstanceOf[ArrayBuffer])
////        if(res)
////        arr.foreach((x: Int) => print(x + " "))
////        println()
//      } else {
//        println(res)
//      }
    }
  }
}
