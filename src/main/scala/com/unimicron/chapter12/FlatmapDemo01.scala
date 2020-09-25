package com.unimicron.chapter12

object FlatmapDemo01 {
  def main(args: Array[String]): Unit = {
    // 每個元素是字符串，字符串也是集合
    val names = List("Alice", "Jack", "Ron")
    // 將List集合中的所有元素，進行扁平化操作，即把所有元素打散
    val names2 = names.flatMap(upper)
    println("names2 = " + names2)
  }

  def upper(str: String): String = {
    str.toUpperCase
  }
}
