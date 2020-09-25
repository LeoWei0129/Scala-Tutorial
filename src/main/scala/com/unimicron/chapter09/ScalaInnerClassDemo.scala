package com.unimicron.chapter09

object ScalaInnerClassDemo {
  def main(args: Array[String]): Unit = {
    // 創建外部類實例
    val outer1 = new ScalaOuterClass1
    val outer2 = new ScalaOuterClass2

    // 創建內部類實例
    // 透過 "new 外部類對象.內部類" 創建，默認情況下，內部類實例和外部對象關聯
    val inner1 = new outer1.ScalaInnerClass1
    val inner2 = new outer2.ScalaInnerClass2
    inner1.info()
    inner2.info()

    val outer2a = new ScalaOuterClass2
    val outer2b = new ScalaOuterClass2

    val inner2a = new outer2a.ScalaInnerClass2
    val inner2b = new outer2b.ScalaInnerClass2

    // 兩個內部類實例分別調用test()
    // 默認情況下，scala的內部類實例會和創建該內部類實例的外部對象關聯，所以如inner1.test(inner2)會報錯
    inner2a.test(inner2a)
    inner2b.test(inner2b)
    inner2a.test(inner2b)
    inner2b.test(inner2a)

    // 創建靜態內部類實例
    val inner3 = new ScalaOuterClass.ScalaStaticInnerClass
  }
}

// 外部類
class ScalaOuterClass1 {
  var name = "Tom"
  var sal = 10000

  class ScalaInnerClass1 { // 成員內部類
    // method 1:
    // 訪問外部類的私有屬性: 外部類名.this.屬性名
    // ScalaOuterClass1.this相當於是ScalaOuterClass1這個外部類的一個實例
    // 然後通過這個實例對象去訪問屬性name, sal
    def info() = {
      println(ScalaOuterClass1.this.name + "\t" + ScalaOuterClass1.this.sal)
    }
  }
}

class ScalaOuterClass2 {
  myOuter => // myOuter代表外部類的一個對象
  class ScalaInnerClass2 {
    // method 2:
    // 內部類如果想要訪問外部類的屬性，也可以通過外部類的別名訪問
    // 外部類的別名.屬性名 (外部類名.this等價於外部類的別名)
    // 這種方式須將外部類的屬性放在別名後面***
    def info(): Unit = {
      println(myOuter.name + "\t" + myOuter.sal)
    }
    // 內部類的方法，接收ScalaInnerClass實例
    // 下面的ScalaOuterClass#ScalaInnerClass是類型投影的作法，作用是屏蔽外部類對象對內部類對象的影響
    // 當任何內部類對象調用這個方法時，可以傳入任意的內部類對象，不必再考慮內部類對象的關聯外部類對象是誰
    // 所有的這種內部類對象(ScalaInnerClass)一律可以當作型參傳入該方法
    def test(ic: ScalaOuterClass2#ScalaInnerClass2) = {
      println("使用了類型投影" + ic)
    }
  }

  var name = "Jason"
  var sal = 200
}

object ScalaOuterClass {

  class ScalaStaticInnerClass { // 靜態內部類
  }

}