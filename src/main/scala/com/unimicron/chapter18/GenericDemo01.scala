package com.unimicron.chapter18

object GenericDemo01 {
  def main(args: Array[String]): Unit = {
    // 因為IntMessage和StringMessage已經指定類型了，不可任意傳遞類型
    val intMsg = new IntMessage[Int](10)
    val strMsg = new StringMessage[String]("Hello")
    println(intMsg.get)
    println(strMsg.get)

    // Message指定為T，代表在這個類中，我們還可以傳遞給她一個任意類型
//    val msg = new Message[Int](100)
//    println(msg.get)
  }
}

/**
 * 類別Message可以接收任意類型T
 * 定義泛型用[T]，s為泛型的引用
 * @param s
 * @tparam T
 */
abstract class Message[T](s: T) {
  def get = s
}

/**
 * 相當於Message是Collection，IntMessage是List
 * 子類擴展的時候，就可以約定具體的類型
 * @param v
 * @tparam
 */
class IntMessage[Int](v: Int) extends Message(v) {

}

class StringMessage[String](v: String) extends Message(v) {

}