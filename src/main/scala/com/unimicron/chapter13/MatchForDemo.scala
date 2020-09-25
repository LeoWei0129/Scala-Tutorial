package com.unimicron.chapter13

object MatchForDemo {
  def main(args: Array[String]): Unit = {
    val map = Map("A" -> 1, "B" -> 0, "C" -> 3)

    for((k, v) <- map){
      println(k + "->" + v) // 三對key-value("A" -> 1), ("B" -> 0), ("C" -> 3)
    }

    println("------------------")

    // 只遍歷出value=0的key-value，其他的過濾掉
    for((k, 0) <- map){
      println(k + "->" + 0)
    }

    println("------------------")

    // 這個世上面代碼的另外寫法，只是下面的用法更靈活和強大
    for((k, v) <- map if v >= 1) {
      println(k + "->" + v)
    }
  }
}
