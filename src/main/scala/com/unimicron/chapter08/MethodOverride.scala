package com.unimicron.chapter08

object MethodOverride {
  def main(args: Array[String]): Unit = {
    val employee = new Employee2
    employee.printName()
  }
}

class Person2 {
  val name: String = "Tim"

  def printName(): Unit = {
    println("Person: printName() = " + name)
  }

  def sayHi(): Unit ={

  }
}

class Employee2 extends Person2 {
  override def printName(): Unit ={
    // 需要顯式地使用override
    println("Employee: printName() = " + name)
    // 若方法被override，在子類中又需調用父類的方法，使用super
    super.printName()
    // 無論有沒有加super，效果都一樣
    super.sayHi()
  }
}