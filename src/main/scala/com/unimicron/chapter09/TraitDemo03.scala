package com.unimicron.chapter09

object TraitDemo03 {
  def main(args: Array[String]): Unit = {
    val sheep = new Sheep
    println("抽象方法:")
    sheep.sayHi()
    println("具體方法:")
    sheep.sayHello()
  }
}

// 當一個trait有抽象方法和非抽象方法時
// 一個trait在底層還是對應一個class:
// 1. Trait03.class接口
trait Trait03{
  // 抽象方法
  def sayHi()

  // 具體方法(實現普通方法)
  def sayHello(): Unit = {
    println("Say hello~~")
  }
}

// 當trait有接口和抽象類時
// class Sheep extends Trait03在底層對應
// class Sheep implements Trait03
class Sheep extends Trait03{
  override def sayHi(): Unit = {
    println("Say hi~~")
  }
}