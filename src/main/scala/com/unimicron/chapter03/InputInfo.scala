package com.unimicron.chapter03

import scala.io.StdIn

object InputInfo {
  def main(args: Array[String]): Unit = {
    // 要求: 從console接收用戶訊息
    println("輸入用戶姓名:")
    val name = StdIn.readLine()
    println("輸入用戶年齡:")
    val age = StdIn.readInt()
    println("輸入用戶薪水:")
    val sal = StdIn.readDouble()

    printf("name: %s, age: %d, sal: %.2f", name, age, sal)

    // 伴生對象可直接調用，或繼承了trait的伴生對象可直接調用(StdIn)，不用還需要創建對象才能調用功能
    Cat.sayHi()
  }
}

// 聲明一個伴生對象
object Cat extends Animal{
  override def sayHi(): Unit = {
    println("Cat says hi.")
  }
}

// Animal是特質，等價於Java中的Interface + Abstract class
trait Animal {
  def sayHi(): Unit = {
    println("Animal says hi.")
  }
}