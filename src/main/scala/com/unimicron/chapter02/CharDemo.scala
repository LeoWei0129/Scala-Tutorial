package com.unimicron.chapter02

object CharDemo {
  def main(args: Array[String]): Unit = {
    // 當我們輸出一個char類型時，他會輸出數字對應的字符(碼值表unicode)，unicode包括ascii
    var c1: Char = 97
    println("c1: " + c1)

    // char可以當作數字進行運行
    var c2: Char = 'b'
    var num = c2 + 10
    println("num: " + num)

    // 當把一個計算的結果賦值給一個變量，編譯器會進行類型轉換與判斷(都會看範圍+類型)，int -> char是從高精度轉向低精度，會報錯
    // 當把一個字面量賦值給一個變量，編譯器只會進行範圍判斷
//    var c3: Char = 'a' + 1
//    var c4: Char = 97 + 1
    var c5: Char = 98
//    var c6: Char = 99999 // 超過char的範圍
  }
}
