package com.unimicron.chapter05

object RecursiveDemo02 {
  def main(args: Array[String]): Unit = {
    // 1. Fibonacci
    println(fibonacci(10))

    // 2. 已知f(1)=3, f(n)=2*f(n-1)+1
    println(sum(3))

    // 3. 猴子吃桃子
    println(eatPeach(1))
  }

  /**
   * fibonacci sequence
   */
  def fibonacci(n: Int): Int = {
    // n = 1, res = 1
    // n = 2, res = 1
    // n = 3, res = 前兩個結果之和
    if(n == 1 || n == 2){
      1
    }else{
      fibonacci(n - 1) + fibonacci(n - 2)
    }
  }

  /**
   * 求函數值
   * @param n
   * @return
   */
  def sum(n: Int): Int = {
    if(n == 1){
      3
    }else{
      2 * sum(n - 1) + 1
    }
  }

  /**
   * 有一堆桃子，第1天吃其中的一半，並再多吃一個，以此類推，直到第10天，只剩一個桃子，求共有多少個桃子
   * day = 10, n = 1
   * day = 9, n = (day(10)[1] + 1) * 2
   * day = 8, n = (day(9)[4] + 1) * 2
   */
  def eatPeach(day: Int): Int ={
    if(day == 10){
      1
    }else{
      (eatPeach(day + 1) + 1) * 2
    }
  }
}
