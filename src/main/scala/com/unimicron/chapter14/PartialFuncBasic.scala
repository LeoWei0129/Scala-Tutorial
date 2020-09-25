package com.unimicron.chapter14

/**
 * 給定一個val list = List(1, 2, 3, 4, "abc")，有以下要求:
 * 1. 將集合中的所有數字+1，並返回一個新的集合
 * 2. 需忽略掉非數字的元素，即返回的新集合為List(2, 3, 4, 5)
 */

object PartialFuncBasic {
  def main(args: Array[String]): Unit = {
    // 使用偏函數解決
    val list = List(1, 2, 3.2, 4, "abc")

    // 定義偏函數
    // new PartialFunction[Any, Int]: 表示偏函數接收的參數類型是Any，返回類型是Int
    // isDefinedAt(x: Any): 如果返回true，就會調用apply()構建對象實例，如果是false，過濾
    // apply(v1: Any): v1是上面返回true情況下的參數x，apply構造器對傳入的值+1，並返回新的集合
    val partialFunc = new PartialFunction[Any, Int] {
      override def isDefinedAt(x: Any): Boolean = if (x.isInstanceOf[Int]) true else false

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int] + 1
      }
    }

    // 使用偏函數
    // 如果要使用偏函數，不能使用map，要使用collect
    // 偏函數的執行流程
    // 1. 遍歷list所有元素
    // 2. 然後調用val element = if(partialFunc.isDefinedAt(list單個元素)){partialFunc.apply(list單個元素)}
    // 3. 每得到一個element，放入到新的集合中，最後返回
    // 4. collect()相當於結合了filter()+map()
    val list2 = list.collect(partialFunc)
    println(list2)

    // 偏函數簡化方式1
    def partialFunc2: PartialFunction[Any, Int] = {
      case n: Int => n + 1
    }

    val list3 = list.collect(partialFunc2)
    println(list3)

    // 偏函數簡化方式2
    val list4 = list.collect({ case n: Int => n + 1 })
    println(list4)

    val list5 = list.collect({
      case n: Int => n + 1
      case n: Double => n * 2
    })
    println(list5)
  }
}
