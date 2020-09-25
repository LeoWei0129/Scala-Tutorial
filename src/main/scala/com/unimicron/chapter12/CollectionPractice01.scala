package com.unimicron.chapter12

import scala.collection.mutable.ArrayBuffer

/**
 * val sentence = "AAAAAAAAAAAABBBBBBBBBBBBBBCCCCCCCCCCCCCCCCDDDDDDDDDDD"，將sentence中各個字符，通過
 * foldLeft存放到一個ArrayBuffer中，目的: 理解foldLeft的用法
 */

object CollectionPractice01 {
  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAAAABBBBBBBBBBBBBBCCCCCCCCCCCCCCCCDDDDDDDDDDD"
    val arrayBuffer = new ArrayBuffer[Char]()
    // head: arrayBuffer，因為要不停地往arrayBuffer中放(折疊)數值進去
    sentence.foldLeft(arrayBuffer)(putArray)
    println("res = " + arrayBuffer)
  }

  def putArray(arr: ArrayBuffer[Char], c: Char): ArrayBuffer[Char] = {
    // 將c放入arr中
    arr.append(c)
    arr
  }
}
