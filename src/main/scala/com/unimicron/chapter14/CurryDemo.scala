package com.unimicron.chapter14

object CurryDemo {
  def main(args: Array[String]): Unit = {
    // 也可以使用closure來實現
    // 柯里化一般作法
    def mulCurry(x: Int)(y: Int) = x * y
    println(mulCurry(10)(20))

    /**
     * 使用函數柯里化比較兩個字符串是否相等(不考慮大小寫的情況下)
     */
    // 簡單方式，使用一個函數就完成
    def comparison1(n1: String)(n2: String): Boolean = {
      n1.toLowerCase.equals(n2.toLowerCase)
    }
    println(comparison1("tina")("TINA"))

    def comparison2(n1: String, n2: String): Boolean = {
      n1.equals(n2)
    }

    // 隱式類
    implicit class TestEq(s: String){
      // 體現了將比較字符串的事情，分解成兩個任務完成
      // checkEq完成轉換大小寫
      // f函數完成比較任務
      def checkEq(ss: String)(f: (String, String) => Boolean): Boolean = {
        f(s.toLowerCase, ss.toLowerCase)
      }
    }

    val str = "hello"
    println(str.checkEq("HELLO")(comparison2))
  }
}
