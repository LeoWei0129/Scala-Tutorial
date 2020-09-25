package com.unimicron.chapter09

object TraitDemo02 {
  def main(args: Array[String]): Unit = {
    val c = new C
    val e = new E
    c.getConn()
    e.getConn()
  }
}

// 先將六個類的關係寫出來
// C和E需增加獲取連接數據庫的功能(實現可以不同)，兩者連接不同的數據庫
class A{}
class B extends A{}
class C extends A with DBConnect {
  override def getConn(): Unit = {
    println("Connect to MySQL...")
  }
}

class D{}
class E extends D with DBConnect {
  override def getConn(): Unit = {
    println("Connect to Oracle...")
  }
}
class F extends D{}

// 按照要求定義一個trait
trait DBConnect{
  // 定義一個規範(抽象方法即可)
  def getConn()
}
