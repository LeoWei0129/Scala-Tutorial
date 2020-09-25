package com.unimicron.chapter06

object AnimalPackage {
  def main(args: Array[String]): Unit = {
    // 使用不同animal包下的Tiger類
    val tiger1 = new com.unimicron.chapter06.animal01.abc.Tiger
    val tiger2 = new com.unimicron.chapter06.animal02.Tiger
    println(tiger1 + "\t" + tiger2)
  }
}
