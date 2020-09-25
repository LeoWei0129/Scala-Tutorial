package com.unimicron.chapter15

import java.text.{DateFormat, SimpleDateFormat}
import java.util.Date

object RecursiveSum {
  def main(args: Array[String]): Unit = {
    // 使用while計算1-50的和
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println("執行前的時間: " + date)

    var res = BigInt(0) // total
    var num = BigInt(1)
    var numMax = BigInt(999999991)
    while(num <= numMax){
      res += num
      num += 1
    }
    val now2: Date = new Date()
    val date2 = dateFormat.format(now2)
    println("res = " + res)
    println("執行後的時間: " + date2)


    val now3: Date = new Date()
    val date3 = dateFormat.format(now3)
    println("執行前的時間: " + date3)
    val res2 = recursiveTotal(BigInt(0), BigInt(999999991))
    val now4: Date = new Date()
    val date4 = dateFormat.format(now4)
    println("res2 = " + res2)
    println("執行後的時間: " + date4)
  }

  // 使用遞歸
  def recursiveTotal(n1: BigInt, sum: BigInt): BigInt = {
    if(n1 <= 999999991) recursiveTotal(n1 + 1, sum + n1)
    else sum
  }
}
