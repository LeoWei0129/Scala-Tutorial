package com.unimicron.chapter04

import scala.util.control.BreakControl
import util.control.Breaks._

object LoopStop {
  def main(args: Array[String]): Unit = {
    // Scala中去掉了break和continue，是為了更好地適應函數化編程，推薦使用函數式的風格解決break和continue的問題
    // 而不是一個關鍵字
    var n = 1

    // breakable()函數
    // breakable是一個高階函數，可以接收函數的函數
    //    def breakable(op: => Unit) {
    //      try {
    //        op
    //      } catch {
    //        case ex: BreakControl =>
    //          if (ex ne breakException) throw ex
    //      }
    //    }
    // op: => Unit 類似這樣的形式代表函數需要接收一個函數當作參數
    // op: => Unit 表示接收的參數(函數)是一個沒有形參(輸入)、返回值的函數
    // 即可理解為接收一個代碼塊
    // breakable對break()拋出的異常進行了處理，代碼就可以正常繼續往下執行
    // 當傳入的是代碼塊，一般使用breakable{}，取代breakable()
    breakable {
      while (n <= 10) {
        println(n)
        if (n == 8) {
          // 中斷while
          // Scala中使用函數式的break函數中斷循環
          // def break(): Nothing = { throw breakException }
          // break()拋出異常，需再對這個異常進行處理(透過breakable())
          break()
        }
        n += 1
      }
    }

    // break()拋出異常，中斷程式，到不了這一行
    println("ok~~")

    // Continue - 使用循環守衛
    for {i <- 1 to 10
         if (i != 2 && i != 5)} {
      println(i)
    }
  }
}
