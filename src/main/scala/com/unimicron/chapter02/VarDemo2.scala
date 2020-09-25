package com.unimicron.chapter02

object ValDemo2 {
  def main(args: Array[String]): Unit = {
    // 類型推倒
    val num = 10 // 這是num是Int類型

    // 方法1: 可以利用idea的提示來證明是Int，給出提示
    // 方法2: 使用方法判斷
    println(num.isInstanceOf[Int])

    // 類型確定後，就不能修改，說明Scala是強類型語言

    // 在聲明/定義一個變量時，可以使用var或val來修飾，var變量可改變，val變量不可改變
    var num1 = 10
    num1 = 30 // ok
    val num2 = 20
    //    num2 = 40 // not ok

    // Why var and val?
    // 1. 在實際編程，更多的需求是獲取/創建一個對象後，獲取對象的屬性
    //    或是修改對象的屬性，但很少修改這個對象本身
    //    dog = new Dog() dog.age = 10 then dog = new Dog()
    // 2. 這時我們就可以使用val，因為val沒有線程安全問題(同步)，因此效率高，Scala作者推薦使用val
    // 3. 如果對象需要改變，使用var
    // val經過編譯後，等於於會在底層加上final
    val cat = new Cat
//    dog = new Dog // 報錯
//    dog.age = 5 // 可改
//    dog.name = "Tom" // 可改
  }
}

class Cat {
  // 給了一個默認值_，相當於0
  var age: Int = _
  var name: String = ""
}