package com.unimicron.chapter13.caseclass

object CaseClassUsage {
  def main(args: Array[String]): Unit = {
    // 該案例的作用就是體驗使用樣例類方式進行對象匹配的簡潔性
    for(item <- Array(Dollar(1000.0), Currency(2000.0, "TWD"), NoAmount())){ // 三個case class和CaseClassDemo02.scala在同一個pkg下(CaseClassDemoBase.scala)，所以可以使用
      val res = item match {
        // 樣例類可以和匹配對象搭配使用
        case Dollar(v) => "$" + v
        case Currency(v, u) => v + " " + u
        case NoAmount() => "Nothing"
      }
      println(item + "\t" + res)
    }
  }
}
