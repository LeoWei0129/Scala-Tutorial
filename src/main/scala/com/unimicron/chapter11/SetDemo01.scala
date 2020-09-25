package com.unimicron.chapter11

import scala.collection.mutable

object SetDemo01 {
  def main(args: Array[String]): Unit = {
    val set1 = Set[Int](1, 2, 3)
    println(set1)

    // 此時Set的類型是[Any]
    val set2 = mutable.Set(1, 2, "hello", 1)
    println(set2)

    // 添加
    // 如果添加的對象已經存在，則不會重複添加，也不會報錯
    set2.add(4)
    set2 += 8
    set2 += (9)
    println(set2)

    // 刪除(直接刪除值)
    // 如果刪除的對象不存在，則不會生效，也不會報錯
    set2 -= 8
    set2.remove(4)
    println(set2)

    // 遍歷
    for(x <- set2){
      print(x + "\t")
    }

//    println(set2.max)
//    println(set2.min)
  }
}
