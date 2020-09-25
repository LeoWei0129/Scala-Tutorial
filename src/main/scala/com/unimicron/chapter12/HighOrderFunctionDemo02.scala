package com.unimicron.chapter12

object HighOrderFunctionDemo02 {
  def main(args: Array[String]): Unit = {
    test(sayOk)
//    test(sum) // 報錯
  }

  // test是一個高階函數，可以接受一個沒有輸入，返回Unit的函數
  def test(f: () => Unit) = {
    f()
  }

  def sayOk() = {
    println("sayOk~~~")
  }

  def sum(n1: Int): Unit = {

  }
}
