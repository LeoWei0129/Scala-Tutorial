package com.unimicron.chapter12

object ZipDemo01 {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 4, 5)
    val list2 = List(2, 9, 10)
    val list3 = list1.zip(list2)
    println(list3) // List((1,2), (4,9), (5,10))

    val list4 = List(3, 8)
    println(list2.zip(list4)) // List((2,3), (9,8))

  }
}
