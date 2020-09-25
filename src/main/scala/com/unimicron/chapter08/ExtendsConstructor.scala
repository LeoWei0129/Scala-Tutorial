package com.unimicron.chapter08

object ExtendsConstructor {
  def main(args: Array[String]): Unit = {
    /*
    1. 因為Scala遵守先構建父類部分，會先執行extends Person5
    2. Person5...(執行Person5的主／輔助構造器)
    3. Student5...(執行Student5的主構造器)
     */
    val student1 = new Student5("Ken", 20)
    println("****************")
    /*
    1. 因為Scala遵守先構建父類部分，會先執行extends Person5
    2. Person5...(執行Person5的主/輔助構造器)
    3. def this(name: String){...}(執行Student5的輔助構造器，構造體內優先執行主構造器)
     */
//    val student2 = new Student5("Ian")
  }
}

class Person5(inName: String){
  var name: String = inName
  var age: Int = 15
  printf("Name = %s\tAge = %d\n", name, age)

  /**
   * 不寫這個輔助構造器會報錯，當子類聲明為:
   * class Student5(inName: String, inAge: Int) extends Person5(){}
   * 父類聲明為:
   * class Person5(inName: String){}
   */
  def this(){
    this("default")
  }
}

// 這裡的Person5調用了輔助構造器def this(){...}
// 只能在類聲明時調用父類的構造器
// 主構造器的型參可以傳給父類的構造器當參數，此處是傳給父類的主構造器，可選的傳
class Student5(inName: String, inAge: Int) extends Person5(inName){
  this.name = name
  this.age = 20

  println("Student...")
  printf("Student: Name = %s\tAge = %d\n", name, age)
//  super() // 報錯

  def this(name: String, age: Int, sex: String){
//    super("default") // 報錯
    this(name, age) // 第一行必須調用主構造器
    this.name = name
    printf("Name = %s\n", name)
  }
}
