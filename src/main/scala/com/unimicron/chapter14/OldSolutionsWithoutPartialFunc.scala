package com.unimicron.chapter14

/**
 * 給定一個val list = List(1, 2, 3, 4, "abc")，有以下要求:
 * 1. 將集合中的所有數字+1，並返回一個新的集合
 * 2. 需忽略掉非數字的元素，即返回的新集合為List(2, 3, 4, 5)
 */

object OldSolutionsWithoutPartialFunc {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, "abc") // 這裡創建的List類行為Any

    // 1. filter+map的方式解決(先filter，再map)
    // 此方法比較麻煩，不夠高效
    def isNumber(num: Any): Boolean = {
      if (num.isInstanceOf[Int]) {
        true
      } else {
        false
      }
    }

    def sum(n: Any): Int = {
      n.asInstanceOf[Int] + 1
    }

    val list2 = list.filter(isNumber).map(sum)
    println(list2)

    // 2. 模式匹配
    // 還不夠完美
    def addOne(n: Any): Any ={
      n match {
        case n: Int => n + 1
        case _ =>            // 若返回值為Int，line 34報錯，因為兩個case的返回值類型不同，不能單純指定為Int
      }
    }

    val list3 = list.map(addOne)
    println(list3) // List(2, 3, 4, 5, ())，()為case的代碼塊都不寫的情況下默認返回的，需再額外過濾
  }


}
