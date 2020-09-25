package com.unimicron.chapter06.packageway

object PrivilegeVisit {
  def main(args: Array[String]): Unit = {
    val c = new Clerk
    c.showInfo()
    c.name = "John"
    //    c.age = 20 // protected變量無法在同包中訪問，只能在子類
    val p = new Person
    p.name = "Peter"
  }
}

class Clerk {
  var name: String = "Tim"
  private var sal: Double = 100.0
  protected var age: Int = 30

  def showInfo(): Unit = {
    // 在本類中可以使用私有的
    println("name: " + name + "\tsal: " + sal)
  }
}

class Puppy extends Clerk {
  age = 10 // 因為變量age已在父類中宣告了
}

// 當一個文件中出現了class Clerk和object Clerk
// 1. class Clerk稱為伴生類
// 2. object Clerk稱為伴生對象
// 3. 因為Scala設計者將static拿掉，也就是設計了伴生類和伴生對象的概念
// 4. 伴生類寫非靜態的內容、伴生對象寫靜態的內容
object Clerk {
  def test(c: Clerk): Unit = {
    // 這裡體現出在伴生對象中，可以訪問c.name和c.sal
    println("test() name = " + c.name + "\tsal: " + c.sal)
  }
}

class Person {
  // 這裡我們增加包訪問權限
  // 下面private[packageway]: 1. 仍然是private 2. 加[packageway]後，可以在package包(包含子包)下使用name，相當於擴大訪問權限
  // 3. 也可以寫成[unimicron]、[chapter06]，代表在它們的那個包和所含子包都可訪問變量
  private[packageway] var name: String = "Adam"
}