package com.unimicron.chapter10

object ImplicitConversionDemo02 {
  def main(args: Array[String]): Unit = {
    // 編寫一個隱式函數，豐富MySQL功能
    implicit def addDelete(mysql: MySQL): DB = {
      new DB
    }

    val mysql = new MySQL
    mysql.insert()
    mysql.delete() // 底層addDelete$1(mysql).delete()
    mysql.update()
  }
}

class MySQL{
  def insert(): Unit = {
    println("insert")
  }
}

class DB{
  def delete(): Unit = {
    println("delete")
  }

  def update(): Unit = {
    println("update")
  }
}
