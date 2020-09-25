package com.unimicron.chapter14

/**
 * 編寫一個程序，具體要求如下
 * 1. 編寫一個函數 makeSuffix(suffix: String) 可以接收一個文件後綴名(ex: .jpg)，並返回一個閉包
 * 2. 調用閉包，可以傳入一個文件名，如果該文件名沒有指定的後綴，則返回文件名.jpg，如果已經有.jpg，則返回原文件名
 * 3. 要求使用閉包的方式完成，提示String.endsWith(xx)
 */

object ClosureDemo {
  def main(args: Array[String]): Unit = {
    // 只需傳入一次.jpg，就會和匿名函數綁定
    // 從這裡可以看到，suffix作為匿名函數f的一個字段，可以重複使用
    val f = makeSuffix(".jpg")
    println(f("dog")) // dog.jpg
    println(f("cat.jpg")) // cat.jpg
  }

  /**
   * 匿名函數和suffix共同形成了一個閉包
   * @param suffix
   * @return
   */
  def makeSuffix(suffix: String) = {
    // 返回一個匿名函數，使用到suffix
    (filename: String) => {
      if (filename.endsWith(suffix)) {
        filename
      } else {
        filename + suffix
      }
    }
  }
}
