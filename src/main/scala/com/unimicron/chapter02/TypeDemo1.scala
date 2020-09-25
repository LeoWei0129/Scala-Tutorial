package com.unimicron.chapter02

object TypeDemo1 {
  def main(args: Array[String]): Unit = {
    // Scala中，Int是一個類型，可以創建實例(num1)，帶有方法
    var num1: Int = 10
    var num2: Double = 9.2
    var num3: Float = 4.5f

    num3 = num2.toFloat // Double(高) -> Float(低)

    // 如果一個方法沒有型參，可以省略()
    println(num1.toDouble + num1.toString + 100.toDouble)
    sayHi()
    sayHi

    // Scala和Java有相同的數據類型，在Scala中數據類型都是對象，也就是說Scala沒有Java的那種原生類型
    // Scala數據類型分為兩大類，AnyVal(值類型)，可以理解為基本數據類型，和AnyRef(引用類型)，可以理解
    // 為像Java傳統的一般類型，兩者皆為對象
    // 相對於Java的類型系統，scala複雜些，也正是這複雜的類型系統才讓面向對象編程和函數式編成完美結合
    // Scala中有一個根類型Any，是所有類的父類(如Java的Object類)
    // Scala中一切皆為對象，分為AnyVal和AnyRef兩大類，為Any的直接子類
    // Null類型是Scala的特別類型，只有一個值null，他是bottom class，是所有AnyRef的子類
    // Nothing類型也是bottom class，是所有類的子類，在開發中通常可將Nothing類型的值返回給任意變量或函數
    // 在拋出異常時用得多
    // Scala中，仍遵守低精度的值向高精度的值自動轉換(implicit convention)
    sayHello()
  }

  def sayHi(): Unit = {
    println("Hi")
  }

  def sayHello(): Nothing = {
    throw new Exception("Fuck you")
  }
}
