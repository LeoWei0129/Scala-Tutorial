package com.unimicron.chapter11

object ArrayDemo01 {
  def main(args: Array[String]): Unit = {
    // 創建一個Array對象
    // [Int]表示泛型，即該數組中，只能存放Int
    // [Any]表示該數組可以存放任意類型
    // 在沒有賦值的情況下，各個元素的值為0
    // array(3) = 10，表示修改第四個元素
    var arr01 = new Array[Int](4)
//    var arr03 = new Array(4)
    println(arr01.length)

    println(arr01(0))

    // 數組遍歷
    for(i <- arr01){
      println(i)
    }

    arr01(3) = 10
    for(i <- arr01){
      println(i)
    }

    // 也可以使用傳統的方式遍歷(下標的方式來遍歷與賦值)
    for(index <- 0 until arr01.length){
      println(arr01(index))
    }
  }
}
