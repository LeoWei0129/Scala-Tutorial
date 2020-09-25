package com.unimicron.chapter04

import scala.io.StdIn // 單獨的引入一個StdIn
import scala.io._ // _表示將scala.io下的所有內容一起引入
import scala.math.sqrt

object IfDemo {
  def main(args: Array[String]): Unit = {
    println("Please enter your age:")
    val age = StdIn.readInt()

    // 單分支
    if (age > 18) {
      println(age + " > 18")
    }

    // 雙分支
    if (age < 18) {
      println(age + " < 18")
    } else {
      println(age + " >= 18")
    }

    println("Please enter a number:")
    val num = StdIn.readInt()

    if (num % 3 == 0 && num % 5 == 0) {
      println("成立")
    } else {
      println("不成立")
    }

    // 多分支
    println("Please enter your score:")
    val score = StdIn.readInt()

    if (score == 100) {
      println("A")
    } else if (score >= 80) { // 使用範圍判斷
      println("B")
    } else if (score >= 60) {
      println("C")
    } else {
      println("F")
    }

    // 求一元二次方程式的根，根據b^2-4*a*c >=< 0判斷
    val a = 3
    val b = 100
    val c = 6
    val m = b * b - 4 * a * c
    var x1 = 0.0
    var x2 = 0.0

    if (m > 0) {
      x1 = (-b + sqrt(m)) / 2 * a
      x2 = (-b - sqrt(m)) / 2 * a
    } else if (m == 0) {
      x1 = -b / 2 * a
      x2 = -b / 2 * a
    } else {
      println("無解")
    }

    // Scala中任意表達式都是有返回值的，也就意味著if-else表達式其實是又返回值的，具體返回結果的值取決於滿足條件的
    // 代碼塊中的最後一行
    val money = 20
    val res = if (money > 20) {
      println("Hello World")
      var a = 5
      a += 10
      "yes ok"
    } else {
      var d = 3
      d += 10
      d
    }

    println("res: " + res)

    // 嵌套分支
    println("Please enter the second")
    val second = StdIn.readInt()

    if (second < 8) {
      println("Please enter the gender")
      val gender = StdIn.readLine()
      if (gender == "male") {
        println("進入男子組")
      } else {
        println("進入女子組")
      }
    } else {
      println("淘汰")
    }
  }
}
