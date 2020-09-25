package com.unimicron.chapter08

object AbstractDemo01 {
  def main(args: Array[String]): Unit = {

  }
}

// 抽象類
abstract class Animal{
  var name: String // 抽象的字段
  var age: Int // 抽象的字段
  var color: String = "black" // 普通字段
  def cry() //抽象方法
}


