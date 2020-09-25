package com.unimicron.chapter12

object MapOperateDemo03 {
  def main(args: Array[String]): Unit = {
    val list = List("Leo", "Alice", "Tim")
    val list2 = list.map(upper)
    println(list2)

    val myList = MyList()

  }

  def upper(str: String): String = {
    str.toUpperCase
  }
}

