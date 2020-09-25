package com.unimicron.chapter08

object ObjectExample01 {
  def main(args: Array[String]): Unit = {
    val child1 = new Child("John")
    val child2 = new Child("Tim")
    val child3 = new Child("Frank")

    Child.joinGame(child1)
    Child.showNum()
    Child.joinGame(child2)
    Child.showNum()
    Child.joinGame(child3)
    Child.showNum()
  }
}

class Child(cName: String) {
  val name: String = cName
}

object Child {
  // 統計共有多少小孩的屬性
  var totalChildNum = 0
  // totalChildNum += 1也可以放這裡

  def joinGame(child: Child): Unit = {
    printf("%s加入了遊戲\n",  child.name)
    totalChildNum += 1
  }

  def showNum(): Unit = {
    printf("總共有%d個小孩\n", totalChildNum)
  }
}
