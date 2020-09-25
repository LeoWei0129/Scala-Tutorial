package com.unimicron.chapter08

object InstanceTypeConversion {
  def main(args: Array[String]): Unit = {
    println(classOf[String]) // 得到該類的全類名
    val s = "king"
    println(s.getClass.getName) // 使用反射機制

    var p1 = new Person3
    var emp1 = new Employee3
    println(emp1.isInstanceOf[Person3])
    println(p1.isInstanceOf[Employee3])
    // 將子類引用給父類(向上轉型，自動)
    p1 = emp1
    println(p1.isInstanceOf[Person3])
    // 將父類的引用重新轉成子類引用(多態，向下轉型)，之後才可以使用子類的方法
    var emp2 = p1.asInstanceOf[Employee3]
    println(emp2.isInstanceOf[Person3])
    println(emp2.isInstanceOf[Employee3])
    emp2.sayHello()
  }
}

class Person3 {
  val name: String = "Tim"

  def printName(): Unit = {
    println("Person: printName() = " + name)
  }

  def sayHi(): Unit ={
    println("Person: sayHi()")
  }

  def sayHello(): Unit ={
    println("Person: sayHello()")
  }
}

class Employee3 extends Person3 {
  override def printName(): Unit ={
    // 需要顯式地使用override
    println("Employee: printName() = " + name)
    // 若方法被override，在子類中又需調用父類的方法，使用super
    super.printName()
    // sayHi()無論有沒有加super，效果都一樣
    sayHi()
  }

  override def sayHello(): Unit ={
    println("Employee: sayHello()")
  }
}
