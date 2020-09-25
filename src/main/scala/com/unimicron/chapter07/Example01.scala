package com.unimicron.chapter07

import scala.beans._

object Example01 {
  def main(args: Array[String]): Unit = {
    val time1 = new Time(10, 20)
    val time2 = new Time(10, 30)
    println(time1.before(time2))

    val student1 = new Student()
    //    student1.setName("Leo")
    //    student1.setId(123456789L)
    //    printf("By @BeanProperty: name = %s, id = %d\n", student1.getName, student1.getId)
    //    printf("By default: name = %s, id = %d", student1.name, student1.id)

    val mapping1 = new Mapping()
    mapping1.test()
  }
}

/**
 * 編寫一個Time類，加入只讀屬性(val)hours和minutes，和一個檢查某一時刻是否早於另一時刻的方法before(other: Time): Boolean，
 * Time對象應該以new Time(hrs, min)方式構建
 */
class Time(hrs: Int, min: Int) {
  val hours: Int = hrs
  val minutes: Int = min

  def before(other: Time): Boolean = {
    if (hours < other.hours) {
      true
    } else if (hours > other.hours) {
      false
    } else {
      if (minutes < other.minutes) true else false
    }
  }
}

/**
 * 創建一個Student類，加入可讀寫的JavaBeans屬性name(類型為String)和Id(類型為Long)，有哪些方法被生產?(用javap
 * 指令查看，該指令可以查看.class文件的反編譯方法聲明(還可以看到反匯編方法))，你可以在Scala中調用JavaBeans的
 * getter和setter方法嗎?
 */
class Student {
  // 讀寫屬性
  @BeanProperty var name: String = _
  @BeanProperty var id: Long = _
}

/**
 * 編寫一段程序，將Java哈希映射(HashMap)中的所有元素複製到Scala哈希映射(HashMap)，用引入語句重命名這個類
 * 當繼承了App後，就可以直接在這個類中直接執行代碼，通常是放在object中
 */
class Mapping extends App {
  // 重命名

  import java.util.{HashMap => JavaHashMap}
  import collection.mutable.{HashMap => ScalaHashMap, _}

  def test(): Unit = {
    val javaMap = new JavaHashMap[Int, String]() // [Int, String]: 泛型
    javaMap.put(0, "first") // 加入三對key-value
    javaMap.put(1, "second")
    javaMap.put(2, "third")

    // 1. javaMap.keySet().toArray()，將javaMap的key轉成數組，轉成數組後才能用for遍歷
    // 2. key.asInstanceOf[Int]，將key轉成Int，因為要符合scalaMap聲明時的定義
    // 3. javaMap.get(key)，得到這個key對應的value
    // 4. (key.asInstanceOf[Int] -> javaMap.get(key))，key->value對
    // 5. scalaMap += (key.asInstanceOf[Int] -> javaMap.get(key))，+=將key->value加入scalaMap
    val scalaMap = new ScalaHashMap[Int, String]()
    for (key <- javaMap.keySet().toArray()) {
      scalaMap += (key.asInstanceOf[Int] -> javaMap.get(key))
    }
    println(scalaMap) // 返回的是一個Map
    println(scalaMap.mkString(" ")) // 將Map的內容取出來，並以" "間隔，返回的是一個String
  }
}
