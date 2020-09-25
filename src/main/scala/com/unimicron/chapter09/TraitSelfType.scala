package com.unimicron.chapter09

object TraitSelfType {
  def main(args: Array[String]): Unit = {

  }
}

// Logger就是自身類型特質，當這裡做了自身類型後，那麼就等價於
// trait Logger extends Exception，強制要求混入該特質的類必須也是Exception的子類
trait Logger {
  // 明確告訴編譯器，我就是Exception，如果沒有這句話，下面的getMessage()不能調用
  this: Exception =>
  def log(): Unit = {
    // 既然就是Exception，就可以調用其中的方法
    println(getMessage())
  }
}

//class Console extends Logger{} // 報錯，自身類型特質強制要求要顯式地寫出當前類必須繼承特質的超類，避免循環依賴關係
class Console extends Exception with Logger{}

