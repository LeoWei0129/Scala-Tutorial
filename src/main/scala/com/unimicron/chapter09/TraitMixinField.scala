package com.unimicron.chapter09

object TraitMixinField {
  def main(args: Array[String]): Unit = {
    val mysql6 = new MySQL6 with DB6 {
      override var sal: Int = 1000
    } // 抽象字段沒有自具體子類中給值會在這一行報錯
    println(mysql6.sal + "\t" + mysql6.opertype)
  }
}

trait DB6{
  var sal: Int // 抽象字段
  var opertype: String = "insert"
  def insert(): Unit = {
    println("xxx")
  }
}

class MySQL6{}