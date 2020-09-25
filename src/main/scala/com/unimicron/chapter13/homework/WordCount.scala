package com.unimicron.chapter13.homework

object WordCount {
  def main(args: Array[String]): Unit = {
    val lines = List("abc hi hello hi", "abc def hello hello hi abc hello hello")
    // 先分步完成，再組合
    // step 1.
    val res1 = lines.flatMap(_.split(" "))
    println("res1 = " + res1)

    // step 2. 做成一個對偶List，才能分組並統計
    val res2 = res1.map((_, 1))
    println("res2 = " + res2)

    // step 3. 分組，把不同單詞歸屬到不同的組
    // groupBy(f: (String, Int)) => k   f: (String, Int)是每個元素的格式，k是按照每個元素tuple
    // 的第幾個元素來groupBy，groupBy()返回一個Map集合
    // res2.groupBy(_._1)
    val res3 = res2.groupBy((x: (String, Int)) => x._1)
    println("res3 = " + res3)

    // step 4. res3是一個map[String, List[String, Int]]，對每個key-value進行統計相加
    // res3.map(x => (x._1, x._2.size)
    val res4 = res3.map((x: (String, List[(String, Int)])) => (x._1, x._2.size))
    println("res4 = " + res4)

    // step5. 排序(從大到小)
    // res4.toList.sortBy(_._2).reverse
    val res5 = res4.toList.sortBy((x: (String, Int)) => x._2).reverse
    println("res5 = " + res5)
  }
}
