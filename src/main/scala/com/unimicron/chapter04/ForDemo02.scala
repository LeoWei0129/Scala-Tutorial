package com.unimicron.chapter04

object ForDemo02 {
  def main(args: Array[String]): Unit = {
    // 循環守衛
    // 即循環保謢式(也稱條件判斷式)，保護式為true時，進入循環體內部，為false時跳過，類似於continue，但也可以利用這
    // 個特性實現break(Scala中沒有continue和break)
    for (i <- 1 to 3 if i != 2) {
      println("i: " + i)
    }

    // 引入變量
    // 在for邏輯式中引入變量，此變量可隨i而變化
    // 沒有關鍵字，所以一定要加;，隔開邏輯判斷
    for (i <- 1 to 3; j = 4 - i; k = 2 + i) {
      println("i: " + i + "\tj: " + j + "\tk: " + k)
    }

    // 嵌套循環
    // Scala可將傳統的嵌套循環改成同時寫在最外層的for中
    // 功能還是像2層的for，所以println()有9個
    // 但一般開發中，還是使用傳統的方式比較多
    for (i <- 1 to 3; j <- 2 to 4) {
      println(s"${i}\t${j}")
    }

    // 循環返回值
    // 將遍歷過程中處理的結果返回到一個新的vector集合中，並將vector集合返回給res變量，使用yield關鍵字
    // 這個方法體現出Scala一個重要的語法特性，就是將一個集合中的各個數據進行處理，並返回給新的集合
    var res = for (i <- 1 to 10) yield {
      if (i % 2 != 0) {
        i + 3
      } else {
        "偶數"
      }
    }

    println(res)
  }
}
