package com.unimicron.chapter06

object ConstructorDemo {
  def main(args: Array[String]): Unit = {
//    val p1 = new Person2("Jack", 10)
//    println(p1)

    // 調用輔助構造器def this(name: String)
    val p1 = new Person2("Ray")
    println(p1)

    val testA1 = new A
    val testA2 = new A()
  }
}

/**
 * 創建Person對象的同時也初始化對象的age和name屬性
 * 主構造器中的參數不能和屬性名稱相同
 */
class Person2(inName: String, inAge: Int) {
  var name: String = inName // 主構造器中的參數賦值給屬性
  var age: Int = inAge
  age += 10
  println("1~~~~~~~~~~~~")

  // 重寫toString，便於輸出對象的訊息
  override def toString: String = {
    "name = " + this.name + "\tage = " + this.age
  }

  def this(name: String){
    // 輔助構造器必須在第一行顯式地調用主構造器(可以直接或間接的方式)，原因: 為了先執行父類的主構造器
    // 就像Java一樣，每個構造器中的第一行必須是super()，而Scala中類的主構造器在繼承時，會再去調用其
    // 父類的主構造器
    // Java中一個構造器需要調用同個類中的其他構造器時，那個構造器也要放在第一行
    this("Jack", 10)
    this.name = name // 重新賦值
    println("這是輔助構造器")
  }

  // 私有輔助構造器，無法在外部調用
  private def this(age: Int){
    // 間接調用主構造器，因為def this(name: String)中調用了主構造器
    // 先進到輔助構造器def this(name: String)，再調用主構造器，執行完主構造器後，再執行def this(name: String)
    // 中的部分，最後才執行private def this(age: Int)中的部分
    this("Ken")
    this.age = age
  }

  println("2~~~~~~~~~~~~")
  println("age = " + age) // 執行完這句後再執行line 6，因為到這一行也是主構造器的部分
}

// 主構造器的()可省略，但因為B繼承A，A的主構造器會被B調用
class A {

}

// 私有主構造器，只能通過輔助構造器構造對象(如果聲明為public)
class B private () extends A(){
  def this (name: String){
    this()
  }
}