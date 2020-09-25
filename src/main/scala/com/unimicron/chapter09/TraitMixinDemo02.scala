package com.unimicron.chapter09

/**
 * 疊加特質(混入多個特質)
 */
object TraitMixinDemo02 {
  def main(args: Array[String]): Unit = {
    // 創建MySQL4實例時，動態混入DB4和File4

    // 研究第一個問題，當我們創建一個動態混入對象時，其順序是怎樣的?
    // 特質類似於類之間的關係，也可以彼此繼承，並且會先調用父類可執行的statement，如同普通類在繼承時的
    // 父類constructor與子類constructor之間的關係
    // 但由於DB4與File4都繼承自Operate4與Data4，執行完DB4的所有部分後，就不再重複執行File4的父類部分
    // 直接執行File4內部的部分
    // 總結: Scala在疊加特質的時候，會首先從後面的特質開始執行(從左到右)
    // 動態執行期時，每個特質執行的先後順行構建了特質彼此之間的繼承關係(File4 -> DB4 -> Data4 -> Operate4)
    // 1. Operate4...
    // 2. Data4...
    // 3. DB4...
    // 4. File4...
    val mysql = new MySQL4 with DB4 with File4
    println(mysql)

    // 研究第二個問題，當我們執行一個動態混入對象時，其順序是怎樣的?
    // 順序是: (1)從右到左執行，(2)當在File4中的insert執行到super時，指的是左邊的特質DB4
    // (3)如果左邊沒有特質了，則super就是原本定義的父特質
    // 1. 面向文件
    // 2. 面向數據庫
    // 3. 插入數據 = 100 // Data4的insert()
    mysql.insert(100)
  }
}

trait Operate4{
  println("Operate4...")
  def insert(id: Int) // 抽象方法
}

trait Data4 extends Operate4{ // 特質，繼承了Operate4
  println("Data4...")

  override def insert(id: Int): Unit = { // 實現Operate4的insert()
    println("插入數據 = " + id)
  }
}

trait DB4 extends Data4 { // 特質，繼承了Data4
  println("DB4...")

  override def insert(id: Int): Unit = { // 重寫Data4的insert()，override不可省略
    println("面向數據庫")
    super.insert(id)
  }
}

trait File4 extends Data4 { // 特質，繼承了Data4
  println("File4...")

  override def insert(id: Int): Unit = { // 重寫Data4的insert()，override不可省略
    println("面向文件")
    super.insert(id) // 調用了insert方法，這裡super在動態混入時，不一定是父類
    // 如果希望直接調用Data4的insert方法，可以指定，如下
    // super[?] ?的類型，必須是當前特質的直接父特質(超類)，?=Operate4會報錯
//    super[Data4].insert(id)
  }
}

class MySQL4{}


