package com.unimicron.chapter08

object ObjectApplyDemo {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3)
    println(list)

    // 一般方式創建對象
    val pig1 = new Pig("一般豬豬")

    // 使用apply方法創建對象
    val pig2 = Pig("有名豬豬") // 自動觸發def apply(pName: String)
    val pig3 = Pig() // 自動觸發def apply()，底層:　Pig pig3 = Pig.MODULE$.apply
    val pig4 = Pig // 不會觸發def apply()，底層: Pig$ pig4 = Pig.MODULE$

    println(pig1.name)
    println(pig2.name)
    println(pig3.name)
    println(pig4)
  }
}

class Pig (pName: String){
  var name: String = pName
}

// 實現伴生對象的apply方法
object Pig{
  // apply方法(可override)
  def apply(pName: String): Pig = new Pig(pName)

  def apply(): Pig = new Pig("匿名豬豬")
}