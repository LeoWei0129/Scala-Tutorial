package com.unimicron.chapter05

object FunctionDemo02 {
  def main(args: Array[String]): Unit = {
    val tiger1 = new Tiger
    val tiger2 = test01(5, tiger1)

    // tiger1和tiger2指向同一個對象，修改的是這個對象裡的值，因為tiger1和tiger2都是用到同一個new
    println(tiger1.hashCode() + " " + tiger2.hashCode())

    println(test03())
    println(test04())
    println(test05())
    println(test06("abc"))
    println(test09())
    println(test09("Ian"))
    println(test10(name = "Peter", number = 45))
    println(test10(name = "Peter"))
    println(test10(number = 45, name = "Peter"))
    println(test11(10, 20, 30 ,40))
  }

  def test01(n: Int, tiger: Tiger): Tiger = {
    println("n = " + n)
    tiger.name = "Jack"
    tiger
  }

  // 不帶型參
  def test02: Unit = {

  }

  // 如果返回值甚麼都不寫，代表這個函數沒有返回值，即使有return，返回值為()，這是return無效
  def test03() {
    return 3
  }

  // 函數明確使用return關鍵字，那麼函數返回值就不能使用自行推斷了，這時要明確寫成: return_type = {}
  def test04(): Int = {
    return 3
  }

  def test05(): Unit = {
    return 5
  }

  def test06(s1: String) = {
    if (s1.length == 3) {
      s1
    } else {
      3
    }
  }

  def test07(): Unit = {
    // test08 can only be used in test07 because test08 is private
    // defined as private final method under class FunctionDemo02 after compiling
    def test08(): Int = { // private final test08$1()，如果在別的地方聲明了test08，底層被宣告為private final test08$2()
      return 8
    }
    println(test08())
  }

  def test09(name: String = "Tim"): String = {
    name + "//"
  }

  // 帶名參數
  def test10(name: String = "Alex", number: Int = 1000): String = {
    name + "\t" + number
  }

  // 可變參數
  def test11(args: Int*): Int = {
    var sum = 0

    println("args.length = " + args.length)
    for(item <- args){
      sum += item
    }

    sum
  }
}

class Tiger {
  var name = ""
}