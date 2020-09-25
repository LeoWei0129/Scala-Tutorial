package com.unimicron.chapter15

object RecursiveFbn {
  def main(args: Array[String]): Unit = {
    var count = 0
    println(fbn(20))
    println("調用" + count + "次")

    // 研究遞歸求費波納契數列的遞歸次數增長
    // 遞歸次數成指數增長
    def fbn(n: BigInt): BigInt = {
      count += 1
      if(n == 1 || n == 2) 1
      // 重複計算時(發生在每個BigInt，後面的BigInt的fbn(n-2)和fbn(n-1)有重複計算，需要考慮優化->迭代
      // 優化的原則: 改遞歸為迭代
      else fbn(n - 1) + fbn(n - 2)
    }
  }


}
