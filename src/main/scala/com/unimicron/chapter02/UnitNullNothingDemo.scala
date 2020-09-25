package com.unimicron.chapter02

object UnitNullNothingDemo {
  def main(args: Array[String]): Unit = {
    val res = sayHello()
    println("res= " + res)
  }

  // Unit等價於Java的void，只有一個實例值{}
  def sayHello(): Unit = {

  }

  // Null類只有一個實例對象: null，類似於Java中的null引用，null可以賦值給給任意引用類(AnyRef)，但
  // 是不能賦值給值類型(AnyVal: Int, Float, Double, Char...)
  val dog: Dog = null
//  var char: Char = null // 會報錯


  // Nothing類型在Scala的類層級中的最低端，他是任何類型的子類型，當一個函數，我們確定沒有正常的返回值，
  // 可以用Nothing來指定返回類型，這樣做有一個好處，就是我們可以把返回的值(異常)賦給其他的函數或變量(兼容性)
}

class Dog {

}