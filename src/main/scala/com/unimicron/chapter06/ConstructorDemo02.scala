package com.unimicron.chapter06

import scala.beans.BeanProperty

object ConstructorDemo02 {
  def main(args: Array[String]): Unit = {
    val worker1 = new Worker1("Tim")
    println(worker1.name) // 不能訪問inName
    val worker2 = new Worker2("Leo")
    println(worker2.name + worker2.inName) // 可以訪問inName
//    worker2.inName = "Ken" // worker2.inName只可以讀取
    val worker3 = new Worker3("Larry")
    println(worker3.inName)
    worker3.inName = "Mark"
    val worker4 = new Worker4("Jimmy")
    worker4.name = "Alex" // 調用name_$eq()
    println(worker4.name) // 調用name()
    println(worker4.getName()) // 調用getName()
    worker4.setName("Kenny") // 調用setName()
  }
}

// 如果主構造器是Worker1(inName: String)，未加任何修飾符，inName是局部變量，作用範圍只在主構造器內
class Worker1(inName: String){
  val name = inName
}

// 如果主構造器是Worker2(val inName: String)，inName是Worker2的一個private只讀屬性(在外部object讀取)
// 反編譯後，生成屬性: private final String inName
// 且會生成這個方法: public String inName(){return this.inName = inName;}
class Worker2(val inName: String){
  val name = inName
}

// 如果主構造器是Worker3(var inName: String)，inName是Worker2的一個private可讀寫屬性(在外部object讀取)
class Worker3(var inName: String){
  val name = inName
}

class Worker4(inName: String){
  @BeanProperty
  var name = inName
}