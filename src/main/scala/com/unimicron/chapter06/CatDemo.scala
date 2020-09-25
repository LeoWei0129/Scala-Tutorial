package com.unimicron.chapter06

object CatDemo {
  def main(args: Array[String]): Unit = {
    // 創建一個Cat類
    val cat = new Cat

    // 屬性賦值
    // 1. 賦值時cat.name = "Lucky"其實不是直接訪問屬性，而是cat.name_$eq("Lucky")
    cat.name = "Lucky"
    cat.age = 5
    cat.color = "black"
    cat.height = "120" // 可以給String
    cat.weight = null // 只能給null

    // 2. 使用時cat.name等價於cat.name()
    println("貓的命字: " + cat.name)
  }
}

// 定義一個類，底層對應public class Cat
class Cat {
  // 定義三個屬性
  // 1. 聲明了var name: String時，在底層對應private name
  // 2. 同時會生成兩個方法: public name() -> 類似於getter 與 public name_$eq() -> 類似於setter
  var name: String = "" // 必須給初始值
  var age: Int = _ // _表示默認值，如果是Int，默認值是0
  var color: String = _ // _表示默認值，如果是String，默認值是null
  var height: String = null // 給一個null值，但類型是String
  var weight = null // 給一個null值，類型是Null

  // 如果賦值為null，一定要加類型，否則該署性的類型就是Null，但兩種情況都不會報錯
}

// 注意事項
// 1. Scala中，類不額外聲明為public，所有這些類都具有公有可見性(即所有類都默認為public)
// 2. 一個Scala源文件可以包含多個類
class Dog2 {}

class Fish {}

class Test{
  var var1: String = _ // null，引用類型也是null
  var var2: Byte = _
  var var3: Double = _ // 0.0
  var var4: Boolean = _ // false
}


//public class Cat {
//  private String name;
//  private int age;
//  private String color;
//
//  public String name(){return this.name;}
//  public void name_$eq(String x$1){this.name = x$1;}
//  public int age(){return this.age;}
//  public void age_$eq(int x$1){this.age = x$1;}
//  public String color(){return this.color;}
//  public void color_$eq(String x$1){this.color = x$1;}
//}