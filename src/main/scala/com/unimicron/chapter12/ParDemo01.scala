package com.unimicron.chapter12

object ParDemo01 {
  def main(args: Array[String]): Unit = {
    // 按順序執行
    (1 to 5).foreach(println(_))
    println()
    // 將每個println(_)的任務分散/配到不同CPU，造成有些數字輸出的較快，有些較慢
    // 輸出結果是無序的
    (1 to 5).par.foreach(println(_))
    val list = List(1, 2, 3, 4, 5)
//    list.par.map(...) > list.map(...)

    // 查看並行集合中執行的線程數
    val res1 = (0 to 100).map(case_ => Thread.currentThread.getName).distinct
    val res2 = (0 to 100).par.map(case_ => Thread.currentThread.getName).distinct
    println(res1) // 非並行
    println()
    println(res2) // 並行
  }
}
