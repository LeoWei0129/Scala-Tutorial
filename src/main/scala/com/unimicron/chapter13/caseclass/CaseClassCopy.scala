package com.unimicron.chapter13.caseclass

object CaseClassCopy {
  def main(args: Array[String]): Unit = {
    val amt = Currency(2000.0, "TWD")
    val amt2 = amt.copy() // 複製對象，創建的對象和amt的屬性一樣
    println("params of amt: " + amt.value + "\t" + amt.typeof)
    println("params of amt2: " + amt2.value + "\t" + amt2.typeof)
    println(amt2.toString)

    // 可以透過指定參數名或根據參數位置修改屬性值
    val amt3 = amt.copy(8000.0)
    val amt4 = amt.copy(5000.0, "USD")
    val amt5 = amt.copy(typeof = "JPY")
  }
}
