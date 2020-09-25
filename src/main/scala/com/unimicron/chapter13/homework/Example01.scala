package com.unimicron.chapter13.homework

object Example01 {
  def main(args: Array[String]): Unit = {
    println(swap1((10, "idea")))
    // print Array返回地址，ArrayBuffer返回值
    println(swap2(Array(1, 2, "hello")).toBuffer)
  }

  def swap1[T, S](tup: (T, S)) = {
    tup match {
      case (x, y) => (y, x)
      case _ => println("match error.")
    }
  }

  def swap2(arr: Array[Any]) = {
    arr match {
      case Array(a, b, rest @ _*) => Array(b, a) ++ rest
      case _ => arr
    }
  }
}
