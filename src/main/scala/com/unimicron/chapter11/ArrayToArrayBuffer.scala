package com.unimicron.chapter11

import scala.collection.mutable.ArrayBuffer

object ArrayToArrayBuffer {
  def main(args: Array[String]): Unit = {
    var arr1 = ArrayBuffer[Int]()
    arr1.append(2, 1, 4)
    println(arr1)

    // arr1.toArray調用arr1的方法toArray()
    // 通常轉換操作比較花時間
    // 將ArrayBuffer -> Array
    // arr1本身沒有變化
    val newArr = arr1.toArray
    println(newArr) // Array返回地址

    // 原理同上
    val newArr2 = newArr.toBuffer
    newArr2.append(5)
    println(newArr2) // ArrayBuffer返回值
  }
}
