package com.unimicron.chapter08

object TypeConversionCase {
  def main(args: Array[String]): Unit = {
    val std = new Student4
    val emp = new Employee4
    test(std)
    test(emp)
  }

  // 寫一個參數多態的代碼
  // OOP中，一個父類的引用可以接收所有子類的引用(多態)
  def test(p: Person4): Unit ={
    if(p.isInstanceOf[Student4]){
      // p.asInstanceOf[Student4]，對p的類型沒有任何變化，而是返回的是Student4
      p.asInstanceOf[Student4].printNameStd()
      p.asInstanceOf[Student4].sayHi()
    }else if(p.isInstanceOf[Employee4]){
      p.asInstanceOf[Employee4].printNameEmp()
      p.asInstanceOf[Employee4].sayHi()
    }else{
      println("轉換失敗")
    }
  }
}

class Person4{
  def printName(): Unit ={
    println("Person: printName()")
  }

  def sayHi(): Unit ={
    println("Person: sayHi()")
  }
}

class Student4 extends Person4 {
  def printNameStd(): Unit ={
    println("Student: printName()")
  }

  override def sayHi(): Unit ={
    println("Student: sayHi()")
  }
}

class Employee4 extends Person4 {
  def printNameEmp(): Unit ={
    println("Employee: printName()")
  }

  override def sayHi(): Unit ={
    println("Employee: sayHi()")
  }
}
