package com.unimicron.chapter13

object MatchTupleDemo {
  def main(args: Array[String]): Unit = {
    // 如果要匹配(10, 30)這樣任意兩個元素的對偶元組，如何寫?
    for(pair <- Array((0, 1), (1, 0), (10, 30), (1, 1), (1, 0, 2), (0, 2, 4))){
      val result = pair match {
        case (0, _) => "0..." // 匹配以0開頭的二元組，第二個元素(_)任意(e.g. 不想要，在代碼塊中就無法使用)，(0, 2, 4)不匹配，因為是三元組
        case (y, 0) => y // 匹配二元組，且第二個元素必須是0，第一個元素(y)任意(e.g. 指定了變量名，可以在代碼塊中使用)
        case (x, y) => (y, x) // 匹配任意的對偶元組
        case _ => "other"
      }
      // 若result為Tuple，可以直接取值(Array, ArrayList, List不行，解決方法: 可以將這三個類型轉成Tuple再使用)
      println(result)
    }
  }
}
