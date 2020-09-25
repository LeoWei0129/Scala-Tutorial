package com.unimicron.chapter11

object CollectionDemo01 {
  def main(args: Array[String]): Unit = {
    val str = "hello" // 字符串在Scala中就是char的集合，IndexedSeq

    for(item <- str){
      println(item)
    }

    println(str(2))
  }
}
