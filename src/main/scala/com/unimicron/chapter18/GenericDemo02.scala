package com.unimicron.chapter18

object GenericDemo02 {
  def main(args: Array[String]): Unit = {
    // 使用
    val class01 = new EnglishClass[SeasonEnum.Season, String, String](SeasonEnum.spring, "0705", "haha")
    println(class01.className)
    println(class01.classSeason)
    println(class01.classType)

    val class02 = new EnglishClass[SeasonEnum.Season, String, Int](SeasonEnum.spring, "0705", 123)
    println(class02.className)
    println(class02.classSeason)
    println(class02.classType)
  }
}

/**
 * 不在類定義時指定泛型類別，可以在創建該類別時再指定泛型類別
 * @param classSeason
 * @param className
 * @param classType
 * @tparam A
 * @tparam B
 * @tparam C
 */
class EnglishClass[A, B, C](val classSeason: A, val className: B, val classType: C)

// season是enum
object SeasonEnum extends Enumeration {
  type Season = Value // 給類型取別名
  val spring, summer, autumn, winter = Value
}
