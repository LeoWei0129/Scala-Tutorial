package com.unimicron.chapter13.caseclass

object CaseClassInfix {
  def main(args: Array[String]): Unit = {
    // 兩個元素間有::，叫做中置表達式，至少要有first、second兩個匹配才行
    // first匹配第一個，second匹配第二個，rest匹配剩餘部分(5, 7)
    for (item <- Array(List(1, 3, 5, 7), List(5, 8), List(9))) {
      item match {
        case first :: second :: rest => println(first + "\t" + second + "\t" + rest + "\t")
        case _ => println("match error")
      }
    }
  }
}
