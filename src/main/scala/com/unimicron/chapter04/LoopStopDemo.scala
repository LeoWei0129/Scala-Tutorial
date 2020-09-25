package com.unimicron.chapter04

import util.control.Breaks._

object LoopStopDemo {
  def main(args: Array[String]): Unit = {
    var sum1 = 0
    var sum2 = 0

    // 使用breakable實現break
    breakable {
      for (i <- 1 to 100) {
        sum1 += i
        if (sum1 > 20) {
          printf("第一次總和大於20的當前數: %d\n", i)
          break()
        }
      }
    }

    var flag = true
    // 使用循環守衛實現break
    for (i <- 1 to 100 if flag) {
      println(i + "\t" + flag.toString())
      sum2 += i
      if (sum2 > 20) {
        flag = false
      }
    }
  }
}
