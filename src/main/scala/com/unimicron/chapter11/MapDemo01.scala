package com.unimicron.chapter11

import scala.collection.mutable

object MapDemo01 {
  def main(args: Array[String]): Unit = {
    // 默認Map是immutable.Map
    // key-value類型支持Any
    // 在Map的底層，每對key-value是Tuple2的類型來儲存
    val map1 = Map("Alice" -> 10, "kotlin" -> "Ice")
    map1 + ("Tina" -> 15)
    println(map1)

    // 可變Map
    // 從輸出結果可以看到，可變map輸出順序和聲明順序不一致
    // 可變map支持動態變化
    val map2 = mutable.Map("Alice" -> 10, "kotlin" -> "Ice")
    println(map2)

    // 創建空的映射
    val map3 = new mutable.HashMap[String, Int]

    // 對偶元組
    // 即創建了包含鍵值對的二元組，和第一種方式等價，只是形式上不同而已
    // 對偶元組就是只含有兩個數據的元組
    val map4 = mutable.Map(("Alice", 10), ("kotlin", "Ice"))

    // 取值: 1. map(key)
    println(map1("Alice"))

    // 2. 使用contains()檢查是否存在key
    if (map1.contains("Alice~")) {
      println(map1("Alice~"))
    } else {
      println("Key Alice~不存在")
    }

    // 3. 如果key存在，map.get(key)就會返回Some類型的對象(Some是Option的子類)，然後Some.get取值
    //    如果key不存在，map.get(key)就會返回None，並拋出異常
    println(map4.get("kotlin").get)

    // 4. 使用map.getOrElse()取值
    // 如果key存在，返回key對應的值
    // 如果key不存在，返回默認值
    println(map4.getOrElse("Alice", "默認值: No value exists."))
    println(map4.getOrElse("Alex", "默認值: No value exists."))

    // 更新map元素
    // map是可變的，才可以修改，否則報錯
    // 如果key存在，則修改對應的值，key不存在，相當於添加一個key-value
    map4("kotlin") = "America"
    map4("python") = "蟒蛇"
    println(map4)

    // 增加單個元素
    map4 += ("jj" -> 5)
    map4 += ("jj" -> 152) // key存在的情況下，相當於更新
    // 增加多個元素
    map4 += ("baseball" -> 15, "basketball" -> 100)
    println(map4)

    // 刪除
    // (...)中是要刪除的key，可以寫多個
    // 如果key存在，則刪除，不存在也不會報錯
    map4 -= ("kotlin", "jj")

    // 遍歷
    for ((k, v) <- map4) println(k + "\t" + v) // 返回key-value
    for (k <- map4.keys) println(k) // 返回key
    for (v <- map4.values) println(v) // 返回value
    for (v <- map4) println(v) // 返回tuple，類型是Tuple2，println("key: " + v._1 + "\t"  + "value: " + v._2)
  }
}
