package com.unimicron.chapter08

object ObjectDemo01 {
  def main(args: Array[String]): Unit = {
    println(ScalaPerson.sex) // 在底層等價於ScalaPerson$.MODULE$.sex()
    ScalaPerson.sayHi() //  在底層等價於ScalaPerson$.MODULE$.sayHi()(直接調用，底層不經過ScalaPerson.class中的sayHi())
  }
}

// 1. 當在一個文件中，有class ScalaPerson和object ScalaPerson
// 2. class ScalaPerson稱為伴生類，將非靜態的內容寫到該類中
// 3. object ScalaPerson稱為伴生對象，將靜態的內容寫到該對象(類)中
// 4. class ScalaPerson編譯後底層生成ScalaPerson類ScalaPerson.class
// 5. object ScalaPerson編譯後底層生成ScalaPerson$類ScalaPerson$.class
// 6. 對於伴生對象的內容，我們可以直接通過ScalaPerson.屬性或者ScalaPerson.方法來調用

class ScalaPerson { // 若沒有下面的object ScalaPerson，只會生成ScalaPerson.class
  var name: String = _
}

object ScalaPerson {
  var sex: String = "male"

  def sayHi(): Unit = {
    println("Hi~~")
  }
}

object ScalaPerson2 { // 默認生成ScalaPerson2.class和ScalaPerson2$.class
  var sex: String = "male"

  def sayHi(): Unit = {
    println("Hi~~")
  }
}
