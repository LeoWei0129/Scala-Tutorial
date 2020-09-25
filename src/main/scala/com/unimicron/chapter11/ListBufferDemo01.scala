package com.unimicron.chapter11

import scala.collection.mutable.ListBuffer

object ListBufferDemo01 {
  def main(args: Array[String]): Unit = {
    // 創建ListBuffer
    var lst1 = ListBuffer[Int](1, 2, 3)

    // 訪問
    println(lst1(2)) // 3
    for(item <- lst1){
      print(item + "\t")
    }

    // 創建空的ListBuffer
    var lst2 = new ListBuffer[Int]
    lst2 += 5 // 動態追加元素
    lst2.append(6, 3, 2)

    lst2 ++= lst1 // List(5, 6, 3, 2, 1, 2, 3)
    val lst3 = lst1 ++ lst2 // ++=的展開寫法
    val lst4 = lst2 :+ 8
    println("lst2 = " + lst2)
    println("lst3 = " + lst3)
    println("lst4 = " + lst4)
    println("lst2 = " + lst2)

    // 刪除
    lst1.remove(1) // 1: 索引
    println("lst1 = " + lst1)
  }
}
