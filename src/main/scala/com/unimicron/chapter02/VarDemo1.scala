package com.unimicron.chapter02

object VarDemo1 {
  def main(args: Array[String]): Unit = {
    // 變量聲明時，必須初始化
    // 小數默認Double、整數默認Int
    var age: Int = 20
    var sal: Double = 10.5
    var name: String = "Leo"
    var isPass: Boolean = true
    var score: Float = 90.5f

    println(s"$age\t$isPass")
  }
}
