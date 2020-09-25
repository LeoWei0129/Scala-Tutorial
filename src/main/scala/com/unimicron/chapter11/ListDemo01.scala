package com.unimicron.chapter11

object ListDemo01 {
  def main(args: Array[String]): Unit = {
    // 默認情況下，List是Scala.collection.immutable.List，即不可變
    // 如果要使用可變的List，使用ListBuffer
    // List是package object scala做了val list1 = scala.collection.immutable.List
    val list1 = List(1, 2, 3) // 創建時，直接分配元素
    println(list1)

    // val Nil = scala.collection.immutable.Nil
    // Nil != Null
    val list2 = Nil // 空集合，創建後是List()
    println(list2)

    // 訪問
    val value1 = list1(1)
    println(value1) // 2

    // 通過:+和+:追加數據，但本身的集合並沒有變化
    val list3 = list1 :+ 5
    println(list1)
    println(list3)

    // ::符號的使用，順序: 從右向左
    // 1. 將list4放入空集合Nil，List(List(1, 2, 3, "Hello"))
    // 2. 7放入集合，List(7, List(1, 2, 3, "Hello"))
    // ...
    val list4 = List(1, 2, 3, "Hello")
    val list5 = 4 :: 5 :: 5 :: 7 :: list4 :: Nil
    println(list5)

    // List()
    // List(1, 2, 3, "Hello")
    // List(7, 1, 2, 3, "Hello")
    // ...
    val list6 = 4 :: 5 :: 5 :: 7 :: list4 ::: list5
    println(list6)
  }
}
