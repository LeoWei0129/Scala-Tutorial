package com.unimicron.chapter08

object AbstractDetail {
  def main(args: Array[String]): Unit = {
    // 默認情況下，抽象類是不能實例化的
//    val animial = new Animal3 {}
    // 但是可以在實例化時，同時動態地實現抽象類的所有屬性和方法
    val animal = new Animal3 {
      override def sayHello(): Unit = {
        println("Implement Abstract Animal3 sayHello()")
      }
    }
    animal.sayHello()
  }
}

abstract class Animal2{
  // 在抽象類中可以有實現的方法
  def sayHi(): Unit ={
    println("Abstract Animal2 sayHi()")
  }
}

abstract class Animal3{
  def sayHello()
}
