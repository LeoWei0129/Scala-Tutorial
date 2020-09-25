package com.unimicron.chapter11

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable

object ScalaBufferAndJavaListConversion {
  def main(args: Array[String]): Unit = {
    // Scala集合與Java的List互轉
    val arr = ArrayBuffer("1", "2", "3")

    // implicit def bufferAsJavaList[A](b: mutable.Buffer[A]): ju.List[A]
    // 此為一個隱式函數，將Scala的Buffer轉成Java的List
    // implicit def asScalaBuffer[A](l: ju.List[A]): mutable.Buffer[A]
    import scala.collection.JavaConversions.bufferAsJavaList
    import scala.collection.JavaConversions.asScalaBuffer
    // 創建ProcessBuilder對象時，會自動觸發隱式函數bufferAsJavaList，因為類ProcessBuilder的constructor應接收的是Java的List類別
    // 而當前傳入的是Scala的ArrayBuffer類別，javaArr的類型是ProcessBuilder
    val javaArr = new ProcessBuilder(arr)
    // javaArr調用command()，command()返回的是List<String>
    val arrList = javaArr.command()
    println(arrList)

    // 透過asScalaBuffer作隱式轉換(Java List -> Scala BufferArray)
    val scalaArr: mutable.Buffer[String] = arrList
    scalaArr.append("e")
    println(scalaArr)
  }
}
