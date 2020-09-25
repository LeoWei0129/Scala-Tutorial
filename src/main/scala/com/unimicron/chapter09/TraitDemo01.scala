package com.unimicron.chapter09

object TraitDemo01 {
  def main(args: Array[String]): Unit = {

  }
}

// trait Serializable extends scala.Any with java.io.Serializable
// Scala中，Java的接口都可以當作trait來使用
object T1 extends Serializable{
}

object T2 extends Cloneable{

}
