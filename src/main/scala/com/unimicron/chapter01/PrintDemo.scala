package com.unimicron.chapter01

object PrintDemo {
  def main(args: Array[String]): Unit = {
    var word1: String = "Hello"
    var word2: String = " World"
    var name: String = "Leo"
    var age: Int = 25
    var height: Float = 100.0f

    // 字符串拼接
    println(word1 + word2)

    // 格式化輸出
    printf("Name: %s\tAge: %d\tHeight: %.2f\n", name, age, height)

    // 使用%輸出內容，編譯器會解析$對應變量
    // s告訴編譯器後面有變量要解析
    // 也可使用${var}的形式，如果字符串出現了類似$(height + 77)
    println(s"Personal info1: Name: $name, Age: $age, Height: $height")
    println(s"Personal info2: Name: ${name}, Age: ${age}, Height: ${height + 77}")
  }
}
