package com.unimicron.chapter14

object ParamInfer{
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5)
    println(list.map((x: Int) => x + 1)) // 匿名函數直接傳給map()
    println(list.map((x) => x + 1)) // 類型自動推斷，map()根據list的類型來推斷
    println(list.map(x => x + 1)) // 只有單個參數，省略()
    println(list.map(_ + 1)) // 個別變量只在=>右邊出現一次，用_代替(包括左邊的變量也是，同時=>要去掉)

//    val res = list.reduce(_ + _) // 如何得到這行?

    def f1(n1: Int, n2: Int): Int = {
      n1 + n2
    }

    println(list.reduce(f1))
    println(list.reduce((n1: Int, n2: Int) => n1 + n2))
    println(list.reduce((n1, n2) => n1 + n2))
    println(list.reduce(_ + _)) // 因為n1和n2分別只在=>右邊出現一次，可以用_代替
  }
}
