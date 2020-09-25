package com.unimicron.chapter05

object ThrowDemo {
  def main(args: Array[String]): Unit = {
    // 如果希望在test01拋出異常後，代碼可以繼續執行，而不會中斷，則我們需要使用try-catch進行處理
    try {
      test01()
      //      test02()
    } catch {
      case ex: ArithmeticException => {
        println("Catch到" + ex.getMessage)
        println(ex.isInstanceOf[Throwable]) // throw拋出的異常確實是Throwable的子類，而不是Nothing類
      }
      case ex: NumberFormatException => println("Catch到" + ex.getMessage)
    } finally {

    }
    println("繼續執行...")
  }

  def test01(): Int = {
    throw new ArithmeticException("Throw異常") // 返回類型為Nothing
  }

  @throws(classOf[NumberFormatException])
  def test02(): Int = {
    "abc".toInt
  }
}
