package com.unimicron.chapter12

object HighOrderFunctionDemo01 {
  def main(args: Array[String]): Unit = {
    // 使用高階函數
    // 函數當參數傳入時，不帶括號
    // 因為帶括號代表執行該函數，會把函數的結果(即返回值)傳遞給test()當作它的參數
  val res1 = test(sum, 5.2)
  println("res1 = " + res1)

  val res2 = test(sum _ , 3.5)
  println("res2 = " + res2)

  // 在Scala，可以把一個函數直接賦給一個變量，但是不執行函數(若要不執行函數，必須加上_)，此時變量即是函數
  // 如果是val f1 = myPrint會執行函數，此時f1是Unit類型的值，也就是函數執行後的返回值
  val f1 = myPrint _
  f1()
}

  def myPrint(): Unit = {
    println("Hello World")
  }

  // 1. test是一個高階函數
  // 2. f: Double => Double 表示一個函數，該函數可以接受一個Double，返回Double
  // 3. n1: Double 普通參數
  // 4. f(n1) 在test函數中，執行你傳入的函數
  def test(f: Double => Double, n1: Double) = {
    f(n1)
  }

  // 普通的函數，可以接受一個Double，返回Double
  def sum(d: Double): Double = {
    println("sum()被調用")
    d + d
  }
}
