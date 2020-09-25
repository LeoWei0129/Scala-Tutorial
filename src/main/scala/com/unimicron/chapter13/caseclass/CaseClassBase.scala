package com.unimicron.chapter13.caseclass

object CaseClassDemo {
  def main(args: Array[String]): Unit = {
    println("Hello")
  }
}

abstract sealed class Amount // 裡面甚麼都不寫，{}可省略

// 樣例類也對應兩個文件: Dollar.class和Dollar$.class
case class Dollar(value: Double) extends Amount // 樣例類
case class Currency(value: Double, typeof: String) extends Amount // 樣例類
case class NoAmount() extends Amount // 樣例類，主constructor的()不可省略

