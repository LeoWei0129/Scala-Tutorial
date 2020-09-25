package com.unimicron.chapter12

object ReduceDemo01 {
  def main(args: Array[String]): Unit = {
    /*
    使用化簡的方式，val list = List(1, 20, 30, 40, 5)，求List的和
     */
    val list = List(1, 20, 30, 40, 5)
    val list2 = list.reduceLeft(sum) // reduceLeft()是遞歸調用
    // 執行流程分析
    // 1. (1 + 20)
    // 2. (1 + 20) + 30
    // 3. ((1 + 20) + 30) + 40
    // 4. (((1 + 20) + 30) + 40) + 5
    println("list2 = " + list2)
  }

  def sum(n1: Int, n2: Int): Int = {
    println("sum()被調用")
    n1 + n2
  }
}
