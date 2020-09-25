package com.unimicron.chapter06

object ＭemoryState {
  def main(args: Array[String]): Unit = {
    val p1 = new Person
    p1.name = "Jack"
    p1.age = 10
    val p2 = p1
    println(p1.hashCode() == p2.hashCode())
    p1.name = "Tom"
    println(p1.hashCode() == p2.hashCode())
    println(p2.name)
  }
}

class Person {
  var name = ""
  var age: Int = _ // 如果以_的方式給默認值，則屬性必須指定類型，且使用_時，必須是var
}