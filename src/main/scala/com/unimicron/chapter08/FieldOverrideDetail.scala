package com.unimicron.chapter08

object FieldOverrideDetail {
  def main(args: Array[String]): Unit = {
    val bb = new BB
    // 這裡的編譯時報錯是因為val不能修改
//    bb.name = "def" 若line 7成功執行，相當於調用了父類的name_$eq()
//    println(bb.name) // 相當於調用了子類的name()
//    這樣出現數據設置和獲取不一致的問題
    // 執行時報以下錯誤
//    Error:(19, 16) overriding variable name in class AA of type String;
//    value name cannot override a mutable variable
//    override val name: String = "abc"
    println(bb.sal)

    val aa: AA = new BB
    println(aa.sal()) // 動態綁定

    bb.test()
//    bb.sal() // 報錯，這種屬性覆寫方法的情況較特殊，無法顯式地引用父類方法，只能調用自己類的屬性

    val subAAA = new SubAAA
    println(subAAA.age)
  }
}

class AA{
  // 底層生成name()、name_$eq()
  var name: String = ""
  def sal(): Int ={
    10
  }

  def test(): Unit ={

  }
}

class BB extends AA{
  // 底層只生成name()
  // 編譯時不報錯
//  override val name: String = "abc"

  // 底層生成sal()和sal_$eq()，所以等於重寫了A的sal()
  override val sal = 20
}

// 在class AAA中，有一個抽象的字段(未初始化)
// 1. 抽象的字段，就是沒有初始化的字段
// 2. 當一個類含有抽象屬性時，該類需要鰾既為abstract
// 3. 對於抽象的屬性，在底層不會升成對應的屬性聲明，而是生成對應的抽象方法: name()、name_$eq()
abstract class AAA{
  var name: String // 抽象
  var age: Int = 10
}

class SubAAA extends AAA{
  // 如果我們在子類中去重寫父類的抽象屬性，本質是實現了其對應的抽象方法
  // 因此這裡可寫可不寫override
  // 必須初始化
  override var name: String = _ // override: 代表在子類中會額外生成自己的name()、name_$eq()
//  override var age: Int = 20 // 執行時報錯
  age = 30 // 調用父類的age_$eq(30)
}