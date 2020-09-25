package com.unimicron.chapter08

object FieldOverride {
  def main(args: Array[String]): Unit = {
    val obj1: A = new B
    val obj2: B = new B

    // obj1.age -> obj1.age() // 因為是方法，動態綁定機制生效，調用B的age()(底層是JVM)
    // obj2.age -> obj2.age()
    println("obj1's age = " + obj1.age) // 20
    println("obj2's age = " + obj2.age) // 20

    // 若想獲取父類的屬性值
    println(obj2.getSuperName(obj1)) // obj1編譯期的類別是A，執行期的類別是B

  }
}

class A {
  val age: Int = 10 // 會生成public age()
  def name = "Leo"

  def getSuperName(obj: A): String = {
    if (obj.isInstanceOf[B]) {
      obj.asInstanceOf[B].run()
    } else {
      "conversion error"
    }
  }
}

class B extends A {
  override val age: Int = 20 // 會生成public age()
  override val name = "Tim"

  def run(): String = {
    super.name
  }
}

