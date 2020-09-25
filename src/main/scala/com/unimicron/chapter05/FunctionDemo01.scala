package com.unimicron.chapter05

object FunctionDemo01 {
  def main(args: Array[String]): Unit = {
    val res = getRes(3, 4, '+')
    println("res: " + res)
  }

  // 格式：def func_name([param_name: param_type], ...)[[: return_type]] = {
  //        statement
  //        return value
  // }
  // [param_name: param_type], ...,表示函數的輸入(就是參數列表)可以有，也可以沒有，如果有，多個參數使用逗號間隔
  // 函數可以有返回值，也可以沒有(Unit代表沒有)
  // 返回值型式1: : return_type = {}
  // 返回值型式2: = {} 表示返回值類型不確定，使用類型推導完成
  // 返回值型式3:      表示沒有返回值，return不生效，相當於: Unit = {}
  // 如果沒有return，默認執行到最後一行的結果為return value

  // 定義函數 / 方法
  def getRes(n1: Int, n2: Int, oper: Char) = {
    if (oper == '+') {
      n1 + n2 // return可寫可不寫
    } else if (oper == '-') {
      n1 - n2
    } else {
      null // 函數定義中的返回值不能寫Int，因為null和值類型mismatch，應該在定義時省略返回值定義，Scala會自動進行類型推倒
    }
  }
}
