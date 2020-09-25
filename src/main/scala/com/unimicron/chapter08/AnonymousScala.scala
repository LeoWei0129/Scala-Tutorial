package com.unimicron.chapter08

object AnonymousScala {
  def main(args: Array[String]): Unit = {
    val monster = new Monster {
      override var name: String = "Howard" // override可拿掉，因為是實現，不是重寫

      override def cry(): Unit = { // // override可拿掉，因為是實現，不是重寫
        println("monster class " + name)
      }
    }
    monster.cry()
  }
}

abstract class Monster {
  var name: String

  def cry()
}