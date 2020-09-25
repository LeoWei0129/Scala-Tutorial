package com.unimicron.chapter14

object ControlAbstractionDemo02 {
  def main(args: Array[String]): Unit = {
    var x = 10
    while (x > 0) {
      x -= 1
      println("x = " + x)
    }

    println("-----------------------")
    x = 10

    // 使用control abstraction實現類似的效果
    // (x > 0) 和 {...}都是匿名函數的實作，而{...}又是control abstraction的實作
    // until(x > 0){...}是currying的調用方式
    // until()將匿名函數當作參數，所以until()是higher-order函數的應用
    // 既是匿名函數的實作，也可以看做是對until()的宣告，until()可利用這些宣告的細節，實作until()的內部邏輯
    // until()比較大，匿名函數比較小
    until(x > 0) {
      x -= 1
      println("x = " + x)
    }
  }

  def until(condition: => Boolean)(block: => Unit): Unit = {
    if (condition) {
      block
      // 遞歸調用until()
      until(condition)(block)
    }
  }
}