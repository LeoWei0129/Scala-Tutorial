package com.unimicron.chapter12

object ReduceDemo02 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 20, 30, 40, 5)

    def minus(n1: Int, n2: Int): Int = {
      n1 - n2
    }

    def min(n1: Int, n2: Int): Int = {
      if(n1 < n2) n1 else n2
    }

    // 1 - 20
    // (1 - 20) - 30
    // ((1 - 20) - 30) - 40
    // (((1 - 20) - 30) - 40) - 5
    // reduceRight(): minus()的運算結果給到下一次遞歸minus()的左邊參數
    val list2 = list.reduceLeft(minus)
    // 40 - 5
    // 30 - (40 - 5)
    // 20 - (30 - (40 - 5))
    // 1 - (20 - (30 - (40 - 5)))
    // reduceRight(): minus()的運算結果給到下一次遞歸minus()的右邊參數
    val list3 = list.reduceRight(minus)
    // 源代碼其實就是調用reduceLeft()
    val list4 = list.reduce(minus)
    val list5 = list.reduceLeft(min)

    println("list2 = " + list2) // -94
    println("list3 = " + list3) // -24
    println("list4 = " + list4) // -94
    println("list5 = " + list5) // 1
  }
}
