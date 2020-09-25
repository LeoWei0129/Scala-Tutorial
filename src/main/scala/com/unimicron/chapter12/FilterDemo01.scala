package com.unimicron.chapter12

object FilterDemo01 {
  def main(args: Array[String]): Unit = {
    /*
    將val names = List("Alice", "Jack", "Alex")集合中首字母為"A"的篩選到新集合中
     */
    val names = List("Alice", "Jack", "Alex")
    val names2 = names.filter(firstLetter)
    val names3 = names.filter(str => str(0) == 'J')
    println("names2 = " + names2)
    println("names3 = " + names3)
  }

  /**
   * filter()接收的函數的返回值必須是Boolean類型
   * 藉由Boolean值決定當前遍歷到的數據是否要過濾掉
   * @param str
   * @return
   */
  def firstLetter(str: String): Boolean = {
    if (str(0).toUpper == 'A') { // str.startsWith('A')
      true
    } else {
      false
    }
  }
}
