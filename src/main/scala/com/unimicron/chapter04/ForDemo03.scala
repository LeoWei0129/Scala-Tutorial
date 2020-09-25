package com.unimicron.chapter04

object ForDemo03 {
  def main(args: Array[String]): Unit = {
    // for循環中()或{}都可以
    // for推導式有一個不成文的規定，當for推導式只有包含一個表達式時使用()，多個表達式使用{}
    // 當使用{}時，分號就不用寫了，並將表達式分行
    for {i <- 1 to 10
         j = i + 4} {
      println(s"${i}\t${j}")
    }

    // 控制步長為2 - (1)
    // Range是一個集合，透過def apply()實現
    // def apply(start: Int, end: Int, step: Int): Range(start, end, step)
    for (i <- Range(1, 10, 2)) {
      println(i)
    }

    // 控制步長為2 - (2)
    for (i <- 1 to 10 if i % 2 == 1) {
      println(i)
    }
  }
}