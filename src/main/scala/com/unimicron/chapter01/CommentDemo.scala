package com.unimicron.chapter01

object CommentDemo {
  /**
   * @example testing coding
   * @param args
   */
  def main(args: Array[String]): Unit = {
    println("Hello World")
  }

  /**
   * @deprecated 過期
   * @example
   * 輸入n1 = 10, n2 = 20, return 30
   * @param n1
   * @param n2
   * @return 和
   */
  def sum(n1: Int, n2: Int): Int = {
    return n1 + n2
  }
}