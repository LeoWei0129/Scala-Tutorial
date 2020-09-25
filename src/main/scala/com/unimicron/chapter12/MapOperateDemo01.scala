package com.unimicron.chapter12

object MapOperateDemo01 {
  def main(args: Array[String]): Unit = {
    /*
    實際需求:
    將List(3, 5, 7)中的所有元素都*2，將其結果放到一個新的集合中返回，即返回新的List(6, 10, 14)
     */
    // 傳統作法
    // 此方法來解決問題的小結
    // 1. 優點
    //    a. 處理方法比較直接，好理解
    // 2. 缺點
    //    a. 不夠簡潔、高效
    //    b. 沒有體現函數式編程特點: 集合 -> 函數 -> 新的集合 -> 函數...
    //    c. 不利於處理複雜的數據處理業務
    val list1 = List(3, 5, 7)
    var list2 = List[Int]()
    for(item <- list1){
      list2 = list2 :+ item * 2
    }
    println("list2 = ", list2)
  }
}
