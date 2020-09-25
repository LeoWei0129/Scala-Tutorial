package com.unimicron.chapter02

object StringConversion {
  def main(args: Array[String]): Unit = {
    val d1 = 1.2

    // basic datatype 2 String
    val s1 = d1 + ""

    // String to basic datatype
    val s2 = "12"
    val d2 = s2.toInt // toInt is a method but without ()
    val d3 = s2.toFloat // toFloat is a method but without ()

    // 注意事項
    // String在轉Int時，要確保String類型能夠轉成有效的數據，比如我們可以把"123"轉乘123
    // 但不能把"Hello"轉成Int
    val s3 = "Hello"
    val d4 = "12.5"
//    println(s3.toInt) // 編譯時不報錯，執行時拋出異常
//    println(d4.toInt) // 編譯時不報錯，執行時拋出異常，Scala無法將小數點後進行截取
    println(d4.toDouble)

    // 首字符可為操作符(+, -, *)，後續字符必須是操作符，至少一個
    val -+ = 90
    println("-+: " + -+)

    val +*/-% = 100
    println("+*/-%: " + +*/-%)

//    val +ab- = 30 // 報錯
//    println("+ab-: " + +ab-)

    // 用反引號`...`包括任意的字符串來當作標示符，即使是關鍵字也可以
    val `true` = 30
    println("true:" + `true`)

    // 不能使用_作為標示符 val _ = "20"
  }
}