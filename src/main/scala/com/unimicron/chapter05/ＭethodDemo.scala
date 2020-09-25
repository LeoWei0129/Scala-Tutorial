package com.unimicron.chapter05

object ＭethodDemo {
  def main(args: Array[String]): Unit = {
    val methodExec = new MethodExec
    methodExec.printRect()
    methodExec.len = 2.1
    methodExec.width = 3.4
    println("Area: " + methodExec.area())
  }
}

class MethodExec{
  var len = 0.0
  var width = 0.0

  def printRect(): Unit = {
    for(i <- 0 until 10){
      for(j <- 0 until 8){
        print('*')
      }
      println()
    }
  }

  // 計算面積
  def area(): Double = {
    (this.len * this.width).formatted("%.2f").toDouble
  }
}
