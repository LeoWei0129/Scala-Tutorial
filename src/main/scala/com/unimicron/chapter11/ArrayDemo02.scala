package com.unimicron.chapter11

import scala.collection.mutable.ArrayBuffer

object ArrayDemo02 {
  def main(args: Array[String]): Unit = {
//    val arr01 = ArrayBuffer[Int]() //可以加new
    val arr01 = ArrayBuffer[Any](1, 2, 3)

    // 通過索引訪問元素
    println(arr01(1))

    // 遍歷元素
    for(i <- arr01){
      println(i)
    }

    println(arr01.length)
    println(arr01.hashCode())

    println("---------------------")
    // append支持可變參數
    arr01.append(3, "ad", 4.4)
    for(i <- arr01){
      println(i)
    }
    // append()在底層是又new一個對象，並把值複製過去，再返回這個新的對象，所以地址有變
    println(arr01.hashCode())

    println("---------------------")
    // 刪除
    arr01.remove(2) // 2: 索引值
    for(i <- arr01){
      println(i)
    }
    println(arr01.length)
  }
}
