package com.unimicron.chapter15

object RecursiveReverse {
  def main(args: Array[String]): Unit = {
    val str = "j;ljijaflm/"
    val res = reverse(str)
    println(res)
  }

  def reverse(xs: String): String = {
    if(xs.length == 1) xs else reverse(xs.tail) + xs.head
  }
}
