package com.unimicron.chapter17.singleton

/**
 * 懶漢單例模式
 */
object LazySingletonDemo {
  def main(args: Array[String]): Unit = {
    val instance1 = LazySingleton // 在底層創建的是LazySingleton$實體
    println(instance1)
    val instance2 = LazySingleton.getInstance()
    println(instance2)
    val instance3 = LazySingleton.getInstance()
    println(instance2)

    if (instance1 == instance2) {
      println("相等")
    } else {
      println("不相等")
    }

    if (instance2 == instance3) {
      println("相等")
    } else {
      println("不相等")
    }
  }
}


// 讓Singleton的實例只有一個
// 作法: 將Singleton的主構造器私有化
// Singleton，這是我們真正要控制的類
class LazySingleton private() {
  val name = "Tim"
}

// Singleton$
// 懶漢式
object LazySingleton {
  private var s: LazySingleton = null

  def getInstance(): LazySingleton = {
    if (s == null) {
      s = new LazySingleton
    }
    s
  }

//  def apply(): LazySingleton = {
//    if (s == null) {
//      s = new LazySingleton
//    }
//    s
//  }
}

class Test {
  val name = "Peter"
}

object Test {
  def apply(): Test = new Test()
}
