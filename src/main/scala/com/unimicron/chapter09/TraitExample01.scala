package com.unimicron.chapter09

/**
 * 編寫一個Scala程式，使用App特質，以反序打印命令行參數，用空格隔開
 * 舉例: scala Reverse Hello World -> World Hello
 */

// App裡定義了def main(args: ...)，所以這裡不需要再寫main()，且可以使用它的args
object TraitExample01 extends App {
  val args1 = args.reverse
  println(args1.mkString(" "))
}
