package com.unimicron.chapter11

object MultipleArray {
  def main(args: Array[String]): Unit = {
    // 多維數組必須指定類型，否則無法賦值，因為默認是Nothing(大轉小才能通過，如Any->Int，但Nothing->Int是小轉大)
    var arr = Array.ofDim[Int](3, 4)

    // 遍歷
    for(item1 <- arr){ // 取出二維數組中的各個元素(即一維數組)
      for(item2 <- item1){ // 各個一維數組中的元素遍歷
        print(item2 + "\t")
      }
      println()
    }

    // 訪問
    println(arr(0)(0))

    // 修改
    arr(0)(0) = 3
    println(arr(0)(0))

    // 使用傳統索引的方式遍歷
    for(i <- 0 until arr.length){
      for(j <- 0 until arr(i).length){
        print(arr(i)(j) + "\t")
      }
      println()
    }
  }
}