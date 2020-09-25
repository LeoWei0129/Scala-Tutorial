package com.unimicron.chapter13

object MatchListDemo {
  def main(args: Array[String]): Unit = {
    for(list <- Array(List(0), List(1, 0), List(0, 0, 0), List(10), List(1, 0, 0), List(0, 2, 3, 3))){
      val res = list match {
        // List需要用"::"作模式匹配
        case 0 :: Nil => "只有0一個元素的List"
        case x :: Nil => x // 原值返回，前提: 只有一個元素的情況下
        case x :: y:: Nil => x + "\t" + y // 有兩個元素的List
        case 0 :: 2 :: tail => "0..."  // tail: 除了前面寫好的元素，後面是剩下元素組成的元素
        case _ => "match error"
      }
      println("res = " + res)
    }
  }
}
