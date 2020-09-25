package com.unimicron.chapter12

object MapOperateDemo02 {
  def main(args: Array[String]): Unit = {
    /*
    將List(3, 5, 7)中的所有元素都*2，將其結果放到一個新的集合中返回，即返回新的List(6, 10, 14)
     */
    val list = List(3, 5, 7)
    // 說明list.map(multiply)
    // 1. 將list這個集合的元素依次遍歷
    // 2. 將各個元素傳遞給multiply() => 新Int
    // 3. 將得到的新Int，放入到一個新的即合並返回
    // 4. 因此multiply()被調用3次
    val list2 = list.map(multiply)
    // val list2 = list.map(multiply).sum
    // sum(): 將list.map(multiply)返回的集合再遍歷一次並加總，返回總和值
    println("list2 = " + list2)

    // 深刻理解map映射函數的機制 - 模擬實現
    // MyList()有加()，代表才有調用apply()
    val myList = MyList()
    val myList2 = myList.map(multiply)
    println("myList2 = " + myList2)

    // MyList不加()，代表變量myList3指向的是伴生對象MyList(底層對應MyList$.class)，還沒創建MyList實例
    // 需再myList3.apply()才會創建MyList對象(底層MyList.class)
    val myList3 = MyList
    println(myList3)
    println(myList3.apply())
  }

  def multiply(n: Int): Int = {
    println("被調用中~~")
    2 * n
  }
}

// 深刻理解map映射函數的機制 - 模擬實現
sealed class MyList {
  val list1 = List(3, 5, 7)
  // 新的集合
  var list2 = List[Int]()

  // 寫map
  def map(f: Int => Int): List[Int] = {
    // 遍歷集合
    for(item <- this.list1){
      // 可以在這裡進行各種業務操作，如過濾、扁平化...
      list2 = list2 :+ f(item)
    }
    list2
  }
}

object MyList{
  def apply(): MyList = new MyList()
}
