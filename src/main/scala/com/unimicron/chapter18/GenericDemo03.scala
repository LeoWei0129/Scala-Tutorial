package com.unimicron.chapter18

class GenericDemo03 {
  def main(args: Array[String]): Unit = {
    val list1 = List("mouse", "dog", "cat")
    val list2 = List(20, 3, 10)

    println(midList[String](list1))
    println(midList[Int](list2))
  }

  def midList[E](list: List[E]) = {
    list(list.length / 2)
  }
}


