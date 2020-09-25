package com.unimicron.chapter09

object TraitExtendsClass {
  def main(args: Array[String]): Unit = {

  }
}

// LogException繼承了Exception
// LogException特質就可以使用Exception的功能
trait LogException extends Exception{
  def log() = {
    println(getMessage()) // 該方法來自Exception類
  }
}

// 此時UnhappyException是Exception的子類
class UnhappyException1 extends LogException{
  // 已經是Exception的子類了，所以可以重寫方法
  override def getMessage: String = "錯誤消息"
}

// UnhappyException2繼承的父類(IndexOutOfBoundException必須是特質超類Exception的子類，否則錯誤)
class UnhappyException2 extends IndexOutOfBoundsException with LogException {
  // 已經是Exception的子類了，所以可以重寫方法
  override def getMessage: String = "錯誤消息"
}

//class happy{}
//
//class UnhappyException3 extends happy with LogException {
//  override def getMessage: String = "錯誤消息"
//}
