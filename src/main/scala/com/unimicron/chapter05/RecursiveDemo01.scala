package com.unimicron.chapter05

object RecursiveDemo01 {
  def main(args: Array[String]): Unit = {
    test(4)
  }

  def test(n: Int): Unit ={
    if(n > 2){
      test(n-1)
    }
    println("n = " + n)
  }

  // 函數遞歸需要遵守的原則
  // 1. 當程式執行一個函數時，就創建一個受保護的獨立空間(新函數栈stack)
  // 2. 函數的局部變量是獨立的，不互相影響(如果會互相受影響，這個變量是引用類型，不是值類型)
  // 3. 遞歸必須向遞歸條件逼近，否則會是無限遞歸
  // 4. 當一個函數執行完畢，或者遇到return，就會返回，遵守誰調用，就將結果返回給誰
}
