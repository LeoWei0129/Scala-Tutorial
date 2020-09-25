package com.unimicron.chapter12

object IteratorDemo01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5) // 得到迭代器
    val iterator = list.iterator

    /*
    def iterator: Iterator[A] = new AbstractIterator[A] {
    var these = self
    def hasNext: Boolean = !these.isEmpty
    def next(): A =
      if (hasNext) {
        val result = these.head; these = these.tail; result
      } else Iterator.empty.next()
     */
    println("******遍歷方式1******")
    while(iterator.hasNext){
      println(iterator.next())
    }

    // 必須保證迭代器沒有被迭代過，不然會是空的
    // 因為迭代器就像指針一樣，每做一次iterator.next()，指針會移到下一個值，直到結束，不會重來
    println("******遍歷方式2******")
    for(enum <- iterator){
      println(enum)
    }

    println("******遍歷方式3******")
    for(item <- list){
      println(item)
    }
  }
}
