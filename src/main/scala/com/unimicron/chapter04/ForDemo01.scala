package com.unimicron.chapter04

object ForDemo01 {
  def main(args: Array[String]): Unit = {
    val start = 1
    val end = 10

    // i: 循環變量
    // start:  從哪個數開始循環
    // to: 關鍵字
    // end: 循環結束的值
    // start to end: 前後閉合
    for(i <- start to end){
      println("Hello World " + i)
    }

    // for推導式也可以直接對集合進行遍歷
    val list = List("Hello", 3, 5.2)
    for(item <- list){
      println("item: " + item)
    }

    // 使用until時，循環變量只包括start ~ end-1
    for(i <- 1 until 11){
      println("Hello Until " + i)
    }
  }
}
