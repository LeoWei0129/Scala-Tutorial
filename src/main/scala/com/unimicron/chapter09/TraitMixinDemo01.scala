package com.unimicron.chapter09

object TraitMixinDemo01 {
  def main(args: Array[String]): Unit = {
    // 在不修改類的定義基礎上，讓他們可以使用trait中的方法
    val oracleDB = new OracleDB with Operate3
    oracleDB.insert(5)

    // 雖然class OracleDB_被定義為抽象類，但因為裡面沒有任何抽象方法，所以可以被實例化
    val oracleDB_ = new OracleDB_ {
      override def connect(): Unit = ???
    }

    val mySQL = new MySQL with Operate3
    mySQL.insert(200)

    // 如果一個抽象類有抽象方法，如何動態混入特質?
    val mySQL_ = new MySQL_  with Operate3 {
      override def say(): Unit = {
        println("say~~")
      }
    }
    mySQL_.insert(300)
    mySQL_.say()
  }
}

trait Operate3{
  // 具體方法
  def insert(id: Int): Unit = {
    println("插入數據 = " + id)
  }
}

class OracleDB{

}

abstract class OracleDB_{
  def connect()
}

abstract class MySQL{

}

abstract class MySQL_{
  def say()
}


