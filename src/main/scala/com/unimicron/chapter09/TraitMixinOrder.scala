package com.unimicron.chapter09

object TraitMixinOrder {
  def main(args: Array[String]): Unit = {
    /*
      1. 調用當前類的超類構造器
      2. 第一個特質的父特質構造器
      3. 第一個特質構造器
      4. 第二個特質的父特質構造器，如果已經執行過，就不再執行
      5. 第二個特質構造器
      6. 重複4. 5.步驟
      7. 當前類構造器
     */
    // E...
    // A...
    // B...
    // C...
    // D...
    // F...
    val ff1 = new FF() // 在聲明類時繼承特質，先混入特質再創建對象
    println(ff1)

    println("*********************")

    /*
      1. 調用當前類的超類構造器
      2. 當前類構造器
      3. 第一個特質的父特質構造器
      4. 第一個特質構造器
      5. 第二個特質的父特質構造器，如果已經執行過，就不再執行
      6. 第二個特質構造器
      7. 重複5. 6.步驟
     */
    // E...
    // G...
    // A...
    // B...
    // C...
    // D...
    val ff2 = new GG() with CC with DD {} // 動態混入: 先創建GG對象，再混入其他特質
    println(ff2)
  }
}

trait AA{
  println("A...")
}

trait BB extends AA{
  println("B...")
}

trait CC extends BB{
  println("C...")
}

trait DD extends BB{
  println("D...")
}

class EE{ // 普通類
  println("E...")
}

class FF extends EE with CC with DD { // 先繼承類EE，再繼承特質CC和DD
  println("F...")
}

class GG extends EE{
  println("G...")
}
