package com.unimicron.chapter05

object MethodToFunction {
  def main(args: Array[String]): Unit = {
    // 使用方法
    val dog = new Dog
    println(dog.sum(5, 2))

    // 方法轉成函數
    val f1 = dog.sum _
    println("f1=" + f1)
    println("f1=" + f1(4, 9))

    // 直接創建一個函數
    // 將右邊定義好的函數給f2
    val f2 = (n1: Int, n2: Int) => {
      n1 + n2 // 函數體
    }
    println("f2=" + f2)
    println("f2=" + f2(1, 3))

    // 方法、函數、函數式編程、面向對象編程
    // 在Scala中，方法和函數幾乎可以等同(比如他們的定義、使用、運行機制都一樣)，只是函數的使用更加靈活
    // 函數式編程是從編程方式(範式)來談的，可以這樣理解，函數式編程把函數當作一等公民，充分利用函數，支持函數的
    // 多種使用方法
    // 在Scala當中，函數是一等公民，像變量一樣，可以做為函數的參數使用，也可以將函數賦值給一個變量，函數的創建不用
    // 依賴於類或對象，而在Java中，函數的創建需要依賴類、抽象類、接口
    // 面向對象編程是以對象為基礎的編程方式
  }
}

class Dog {
  // 方法
  def sum(a1: Int, a2: Int): Int = {
    // scala中，方法的最後一行就隱含的return
    a1 + a2
  }

  val f3 = (n1: Int, n2: Int) => {
    n1 + n2 // 函數體
  }
}