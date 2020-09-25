package com.unimicron.chapter12

object ScanDemo01 {
  def main(args: Array[String]): Unit = {
    def minus(n1: Int, n2: Int): Int = {
      n1 - n2
    }

    def add(n1: Int, n2: Int): Int = {
      n1 + n2
    }

    // scan運作機制
    // 先將5保存起來(從左邊) List(5)
    // 5放到(1, 2, 3, 4, 5)的左邊 -> (5, 1, 2, 3, 4, 5)
    // 5 - 1 = 4 List(5, 4)
    // (5 - 1) - 2 = 2 List(5, 4, 2)
    // ((5 - 1) - 2) - 3 = -1 List(5, 4, 2, -1)
    // (((5 - 1) - 2) - 3) - 4 = -5 List(5, 4, 2, -1, -5)
    // ((((5 - 1) - 2) - 3) - 5) = -10 List(5, 4, 2, -1, -5, -10)
    val res1 = (1 to 5).scanLeft(5)(minus) // res1's type: IndexedSeq[Int]
    println("res1 = " + res1)

    // scan運作機制
    // 先將5保存起來(從右邊) List(5)
    // 5放到(1, 2, 3, 4, 5)的右邊 -> (1, 2, 3, 4, 5, 5)
    // 5 + 5 = 10 List(10, 5)
    // (5 + 5) + 4 = 14 List(14, 10, 5)
    // ((5 + 5) + 4) + 3 = 17 List(17, 14, 10, 5)
    // (((5 + 5) + 4) + 3) + 2 = 19 List(19, 17, 14, 10, 5)
    // ((((5 + 5) + 4) + 3) + 2 + 1) = 20 List(20, 19, 17, 14, 10, 5)
    val res2 = (1 to 5).scanRight(5)(add)
    println("res2 = " + res2)
  }
}


