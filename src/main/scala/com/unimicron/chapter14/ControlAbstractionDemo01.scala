package com.unimicron.chapter14

import java.lang.Thread

object ControlAbstractionDemo01 {
  def main(args: Array[String]): Unit = {
    // def myRunInThread就是一個控制抽象
    // 因為傳入的參數是函數f: () => Unit，且該函數沒有輸入也沒有輸出
    def myRunInThread(f: () => Unit) = {
      new Thread {
        override def run(): Unit = {
          f() // run()中執行f()
        }
      }.start()
    }

    // 實際執行的代碼塊
    myRunInThread {
      // f()實作細節，在line 12被調用，()代表沒有帶參數的匿名函數
      () => {
        println("開始執行!3秒後完成...")
        Thread.sleep(3000)
        println("已完成")
      }
    }

    println("----------------------------------")

    def myRunInThread2(f: => Unit) = {
      new Thread {
        override def run(): Unit = {
          f // run()中執行f()
        }
      }.start()
    }

    // 對於沒有輸入、沒有輸出(返回值)的函數，可以簡寫如下形式
    // 由於f()不帶參數，可省略()，但本質還是在調用和執行f()
    myRunInThread2 {
      println("開始執行!5秒後完成...")
      Thread.sleep(5000)
      println("已完成")
    }
  }
}