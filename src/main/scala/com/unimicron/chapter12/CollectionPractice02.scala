package com.unimicron.chapter12

import scala.collection.mutable

/**
 * val sentence = "AAAAAAAAAAAABBBBBBBBBBBBBBCCCCCCCCCCCCCCCCDDDDDDDDDDD"，使用映射集合，統計一句話中，各個
 * 字母出現的次數，提示: Map(Char, Int)
 */

object CollectionPractice02 {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAAAABBBBBBBBBBBBBBCCCCCCCCCCCCCCCCDDDDDDDDDDD"
    // 將Map[Char, Int]()放到集合sentence的最左邊
    // charCounts根據他的參數列表格式，接收兩個參數，第一個參數接收sentence當前被運行兩個元素的左值
    // 第二個參數接收sentence當前被運行兩個元素的右值，並將返回結果(Map[Char, Int]給下一次遞歸調用charCounts
    // 的第一個參數)
    // Map[Char, Int]()透過apply()創建對象
    val map1 = sentence.foldLeft(Map[Char, Int]())(charCounts)
    println(map1)

    val map2 = mutable.Map[Char, Int]()
    sentence.foldLeft(map2)(charCounts2)
    println(map2)
  }

  /**
   * 不可變map，所以每次返回的都是新的map(重新創建一個實體，將變量map重新指向這個新的實體)，最終結果是有序的
   * @param map / val，根據傳進來的參數決定是val或var
   * @param c / val
   * @return
   */
  def charCounts(map: Map[Char, Int], c: Char): Map[Char, Int] = {
    // +運算符: 也是一個方法，若map中已有c，修改對應值，並將原本map的內容複製到新創建的實體
    // +運算符: 也是一個方法，若map中沒有c，新增對應鍵值，並將修改後的整體內容複製到新創建的實體
    map + (c -> (map.getOrElse(c, 0) + 1)) // 新實體作為返回值傳給另一個暫存變量，但map在這裡的值不會變
  }

  /**
   * 可變map，每次返回的是本身map，效率更高，最終結果是無序的
   * @param map
   * @param c
   * @return
   */
  def charCounts2(map: mutable.Map[Char, Int], c: Char): mutable.Map[Char, Int] = {
    map += (c -> (map.getOrElse(c, 0) + 1))
  }
}
