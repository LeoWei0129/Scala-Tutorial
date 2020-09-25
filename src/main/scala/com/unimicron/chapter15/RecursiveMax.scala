package com.unimicron.chapter15

object RecursiveMax {
  def main(args: Array[String]): Unit = {
    val list = List(2, 4, 1, 4, 5, 2, 4, 8, 1, 5, 7)
    val res = myMax(list)
    println(res)
  }

  def myMax(xs: List[Int]): Int = {
    // 如果為empty，拋出異常
    if(xs.isEmpty)
      throw new java.util.NoSuchElementException()
    if(xs.size == 1)
      xs.head
    // 遞歸告訴計算機做甚麼，而不是怎麼做
    else if(xs.head > myMax(xs.tail)) xs.head
    else myMax(xs.tail)
  }
}
