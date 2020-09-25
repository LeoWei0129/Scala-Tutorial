package com.unimicron.chapter09

object TraitMixinDemo03 {
  def main(args: Array[String]): Unit = {
    // File5的insert()中的super會是DB5
    val mysql5 = new MySQL5 with DB5 with File5
    mysql5.insert(100)

    // 順序顛倒會報錯
    // 因為File5左邊沒有別的特質了，會直接調用Operate5，因為其insert()是抽象方法，會報錯(編譯時期)
    // 但其實若File5和DB5之間沒有透過super綁定之間的關係，在File5.insert(id)中沒有super的情況下
    // 只執行完DB5的insert()就結束了，不會再執行File5的insert()(執行時期)
//    val mysql5_ = new MySQL5 with File5 with DB5
//    mysql5_.insert(200)

    // 也會報錯，理由同上面的編譯時期解釋
//    val mysql5__ = new MySQL5 with File5
  }
}

trait Operate5 {
  //  println("父特質...")
  def insert(id: Int)
}

trait File5 extends Operate5 {
  override def insert(id: Int): Unit = {
    // 如果我們在子特質中重寫/實現了一個父特質的抽象方法，但是同時調用父特質的抽象方法
    // 這時我們的方法"不是完全實現"，因此需要聲明為abstract override
    // super.insert(id)的調用和動態混入順序有密切關係
    // 在編譯時期，編譯器認為super.insert(id)綁定的是父特質Operate5的insert(id)，必須加上abstract override
    // 在執行時期，這裡的super是DB5，調用DB5的insert()
    println("面向文件...")
    //    super.insert(id)
  }
}

trait DB5 extends Operate5 { // 繼承Operate5，並實現其抽象方法insert()
  override def insert(id: Int): Unit = {
    println("面向數據庫...")
  }
}

class MySQL5 {}