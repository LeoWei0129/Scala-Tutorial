package com.unimicron.chapter12

object ViewDemo01 {
  def main(args: Array[String]): Unit = {
    def multiple(num: Int): Int = {
      num
    }

    // 如果這個數，逆序後和原來的數相等，返回true，否則返回false
    def eq(num: Int): Boolean = {
      println("eq()被調用")
      num.toString.equals(num.toString.reverse)
    }

    // 一般作法
    val list = List(12, 33, 55, 65)
    val list2 = list.filter(eq)
    println(list2)

    // 使用view，等到要用時才計算
    // 因為還沒用到返回集合裡的元素，所以還沒真正執行，等到如遍歷時，才會去計算並返回
    // 相當於先把集合緩存起來，直到跑for時才會執行filter和eq
    var res = list.view.filter(eq)
    println(res) // SeqViewF(...)
    // 到這裡才真正進行filter操作
    for(item <- res){
      println(item)
    }

    // 結論
    // 程序中，對集合進行map、filter、reduce、fold...等操作，你並不希望立即執行
    // 而是在使用到結果才執行，則可以使用view來進行優化
  }
}
