package com.unimicron.chapter06

object DogDemo {
  def main(args: Array[String]): Unit = {
    val dog = new Dog
    dog.name = "Owen"
    dog.age = 12
    dog.weight = 5.0
    println(dog.say())
  }
}

class Dog {
  var name: String = _
  var age: Int = _
  var weight: Double = _

  def say(): String = {
    "Dog's info: " + this.name + "\t" + this.age + "\t" + this.weight
  }
}
