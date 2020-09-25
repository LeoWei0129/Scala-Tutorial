package com.unimicron.chapter17.singleton

/**
 * 餓漢單例模式
 */

object HungrySingletonDemo {
  def main(args: Array[String]): Unit = {
    var instance1 = HungrySingleton
    println(instance1)
    var instance2 = HungrySingleton.getInstance()
    println(instance2)
    var instance3 = HungrySingleton.getInstance()
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
class HungrySingleton private() {}

// Singleton$
// 餓漢式
// 不用if先判斷是否為空，就已經直接創建好(直接new)
object HungrySingleton {
  private var s: HungrySingleton = new HungrySingleton

  def getInstance(): HungrySingleton ={
    s
  }
}
