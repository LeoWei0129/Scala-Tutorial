package com.unimicron.chapter13

object MatchObjectDemo {
  def main(args: Array[String]): Unit = {
    // 不可寫36，因為經過math.sqrt(z)運算後，結果是6
    // 這個值和unapply()定義的返回類型Option[Double]不符合
    // 會走case _
//        val number = 25 // 也可以這樣寫: val number = Square(6.0)

    // 如何理解?
    // 這裡構建了Square並調用apply()(但沒有創建Square實例)，將apply()的返回值賦給number
    // 調用unapply()方法時，會將傳入的值6.0又解析出來，所以也稱為對象提取器
    val number = Square(6.0)
    println(number)
    println("Type of number is Double? " + number.isInstanceOf[Double])
//    println("Type of number is Square? " + number.isInstanceOf[Square])
//    println("Type of Square(6.0) is Double? " + Square(6.0).isInstanceOf[Double])
//    println("Type of Square(6.0) is Square? " + Square(6.0).isInstanceOf[Square])

    val res = number match {
      // case Square(n)的運行機制
      // 1. 當匹配到case Square(n)
      // 2. 調用Square的unapply(z: Double)，此時z的值就是number
      // 3. 如果對象提取器unapply(z: Double)返回的是Some(6.0)，則表示匹配成功
      //    同時將6.0賦給Square(n)的n
      // 4. 如果返回None，表示匹配不成功
      case Square(n) => "match success， n = " + n
      case _ => "match error"
    }
    println(res)

    println("---------------------")

    val names = Names("Alice,Bob,Adam")
    println(names) // Alice,Bob,Adam

    names match {
      // case Names(n1, n2, n3)的運行機制
      // 1. 當匹配到case Square(n)
      // 2. 調用Names的unapplySeq(str: String)，此時str是names
      // 3. 如果返回的是Some("Alice", "Bob", "Adam")，分別給到n1, n2, n3，必須是三個，否則匹配不成功
      // 4. 如果返回None，表示匹配不成功
      case Names(n1, n2, n3) => println(n1 + "\t" + n2 + "\t" + n3)
      case _ => println("match error")
    }
  }
}

object Square {
  // 1. unapply方法是對象提取器
  // 2. 接收z: Double類型
  // 3. 返回類型是Option[Double]，Option是一個集合
  // 4. 返回值是Some(math.sqrt(z))，返回z的開平方的值，並放入到Some集合中
  def unapply(z: Double): Option[Double] = {
    if (math.sqrt(z).isInstanceOf[Double]) {
      println("unapply()被調用，z = " + z)
      Some(math.sqrt(z))
    } else {
      None
    }
  }

  def apply(z: Double): Double = z * z
}

object Names {
  // 當構造器是多個參數時，就會觸發這個對象提取器
  def unapplySeq(str: String): Option[Seq[String]] = {
    if(str.contains(",")) Some(str.split(","))
    else None
  }

  def apply(str: String): String = str
}

