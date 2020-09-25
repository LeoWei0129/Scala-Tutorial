package com.unimicron.chapter09

object TraitExample02 {
  def main(args: Array[String]): Unit = {
    // type可以用於給類型取別名
    type MyInt = Int // 給Int取了別名
    var num1: MyInt = 8
    println(num1)
    println(Suits.toString())
    println(Suits.isRed(Suits.heart))
    println(Suits.isRed(Suits.spade))
  }
}

object Suits extends Enumeration {
  type Suits = Value // 給Value類型取別名，abstract class Enumeration中又定義了abstract class Value

  // 以下4個相當於是object Suits中的4個實例
  val spade = Value("spade") // 使用apply()創建Value對象
  val club = Value("club")
  val heart = Value("heart")
  val diamond = Value("diamond")
  val num: Int = 10 // 不是Value對象，不能被Suits.values獲取

  override def toString(): String = {
    // 這裡的Suits對應的是object Suits，因為相當於是靜態類，可以直接調用
    // Suits.values相當於是object Suits中聲明的4個Values實例，可以調用.values是因為繼承了Enumeration
    Suits.values.mkString(", ") + Suits.num
  }

  // 採用類型推導
  def isRed(card: Suits) = {
//    if (card == heart || card == diamond) {
//      true
//    } else {
//      false
//    }
    card == heart || card == diamond
  }

  // 因為在Enumeration中有定義了values()
  // 若要在這裡使用，須加上override
  //  override def values(): ValueSet = {
  //
  //  }
}
