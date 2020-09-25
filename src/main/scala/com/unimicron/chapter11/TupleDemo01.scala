package com.unimicron.chapter11

object TupleDemo01 {
  def main(args: Array[String]): Unit = {
    // tuple1就是一個tuple，類型是tuple3
    // 為了高校操作tuple，編譯器根據元素的個數不同，對應不同的元組類型
    // 分別是tuple1, tuple2, ... , tuple22
    // 這些類定義在package scala下(scala.Tuple1, scala.Tuple2, ... , Tuple22)
    val tuple1 = (1, "hello", 3.5)
    println(tuple1)

    // 訪問
    println(tuple1._1)
    println(tuple1._2)
    println(tuple1.productElement(2)) // 從0開始

    // 遍歷，元組的遍歷需用到迭代器
    for(item <- tuple1.productIterator){
      println(item + "\t")
    }



  }
}
