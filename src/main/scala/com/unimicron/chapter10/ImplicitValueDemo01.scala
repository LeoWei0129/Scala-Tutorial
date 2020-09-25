package com.unimicron.chapter10

// 在程式中，同時有隱式值、默認值、傳值
// 編譯器的優先級: 傳值 > 隱式值 > 默認值
// 在隱式值匹配時，不能有二異性
// 如果三個都匹配不到，會報錯

object ImplicitValueDemo01 {
  def main(args: Array[String]): Unit = {
    implicit  val str1: String = "Jack" // 隱式值
    // 如果這裡再一個implicit值，會報錯，hello(implicit name: String)不知道要匹配誰，編譯器感到迷茫

    // name是隱式參數
    def hello(implicit name: String): Unit = { // 底層hello$1()
      println("Hello " + name)
      def hello() = { // 底層hello$2()
        println(name + "~~")
      }
      hello() // 調用hello$2()，order 3
    }
    hello("Tina") // 底層hello$1(str1)，使用隱式值時不要帶()，order 2
    hello

    // 當一個隱式參數匹配不到隱式值時，使用默認值
    // 但是在匹配不到的情況下，又沒有默認值時，會報錯
    def bark(implicit count: Int = 3): Unit = {
      println("This dog barked " + count + " times.")
    }
    bark
  }

  def hello() = { // 底層hello()
    println("abc")
  }

  hello() // 調用hello()，order 1，這裡相當於class中constructor的位置，最優先執行
}
