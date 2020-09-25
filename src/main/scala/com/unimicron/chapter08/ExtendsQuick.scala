package com.unimicron.chapter08

object ExtendsDemo01 {
  def main(args: Array[String]): Unit = {
    val student1 = new Student
    student1.name = "Tim" // 調用了從Person繼承的name()
    student1.age = 15
    student1.showInfo() // 這裡可以使用父類的方法
    student1.study()
//    student1.test1() // scala中，protected只有繼承關係的類中能調用，即使在同個package中，也有可能無法調用，如line 10
  }
}

class Tiger {
  val student = new Student
  def run(): Unit ={
//    student.test01() // 與Person不具繼承關係，無法調用protected方法
    student.showInfo() // public方法可在外部被調用
  }
}

class Person{
  // 子類繼承了父類的所有屬性
  // 但是若屬性設為private，子類中也無法訪問
  // 因為在子類中調用時，也是要調用name()和name_$eq()，但這兩個method都會被設成private，所以無法訪問
  var name: String = _
  var age: Int = _

  def showInfo(): Unit ={ // 默認public
    printf("name = %s, age = %d\n", name, age)
  }

  /**
   * 反編譯後，可以發現scala中的protected，經過JVM，在java中是public
   */
  protected def test01(): Unit ={

  }

  private def test02(): Unit ={

  }
}

class Student extends Person{
  // 這裡可以使用父類的屬性
  def study(): Unit ={
    printf("%s is studying.", name)
  }
  test01() // protected可以在子類中訪問
//  test02() // private的屬性或方法在子類中訪問不到
}
