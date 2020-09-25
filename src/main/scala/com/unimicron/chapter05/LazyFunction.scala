package com.unimicron.chapter05

object LazyFunction {
  def main(args: Array[String]): Unit = {
    lazy val res = sum(5, 2) // 實參先被加入memory中，放入緩存隊列中
    println("-------------------")
    println("res = " + res) // 在要使用res前，才執行sum()，將sum(5, 2)加入執行隊列中
  }

  def sum(n1: Int, n2: Int): Int = {
    println("sum()先執行了")
    n1 + n2
  }
}
