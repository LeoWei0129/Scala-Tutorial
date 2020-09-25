package com.unimicron.chapter11

import scala.collection.mutable

object QueueDemo01 {
  def main(args: Array[String]): Unit = {
    // 創建隊列
    val q1 = new mutable.Queue[Int]
    val q2 = new mutable.Queue[Any]
    println(q1)

    // 隊列增加元素
    q1 += 9
    println(q1)
    q1 ++= List(4, 5, 7)
    println(q1)
    q2 += List(10, 3) // 將List(10, 3)作為一個元素加入到隊列中

    q1.dequeue() // 從隊列的頭部取出元素，q1本身會變
    println(q1)
    q1.enqueue(12, 5, 3) // 入隊列，默認從隊列的尾部加入，redis
    println(q1)

    // 返回隊列的元素(查詢，隊列本身不變)
    println(q1.head) // 返回隊列的第一個元素
    println(q1.last) // 返回隊列最後的元素
    println(q1.tail) // 返回隊列的尾部(不包含第一個元素)
    println(q1.tail.tail) // 返回隊列的尾部(不包含第一、二個元素)，依此類推，可以級聯使用
  }
}