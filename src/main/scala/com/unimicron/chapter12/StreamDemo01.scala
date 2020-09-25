package com.unimicron.chapter12

object StreamDemo01 {
  def main(args: Array[String]): Unit = {
    // 創建Stream
    // #:: numsForm(n + 1): 數據產生的規則，一次增加一個
    // 1. Stream集合存放的數據類型是BigInt
    // 2. numsForm是自定義的函數，含署名由自己指定
    // 3. 創建的集合的第一個元素是n，後續元素生成的規則是n+1
    // 4. 後續元素生成的規則是可以由自己指定的，比如numsForm(n * 4)
    def numsForm(n: BigInt): Stream[BigInt] = n #:: numsForm(n * 4)
    val stream1 = numsForm(5) // stream1是一個集合
    println(stream1) // (5, ?) ?: 後面還會友直進入流中，但不知道會是甚麼，以?代替
    // 取出第一個元素
    println("head = " + stream1.head) // 5
    println("tail = " + stream1.tail) // 根據規則自動觸發值進入流中，當對stream執行tail操作時，就會升成一個新的數據
    println("stream = " + stream1) // (5, 20, ...)
    println("tail = " + stream1.tail)
    println("stream = " + stream1)

    // 應用案例
    def multiply(x: BigInt): BigInt = {
      x * x
    }
    val stream2 = numsForm(3)

    // numsForm(5)返回的是一個集合，所以可以使用map()
    println(stream2.map(multiply))
  }
}
