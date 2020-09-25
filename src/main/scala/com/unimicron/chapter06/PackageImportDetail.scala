package com.unimicron.chapter06

import scala.beans._
import scala.collection.mutable
import scala.collection.mutable.{HashMap, HashSet} // 使用選擇器，選擇引入的內容

object PackageImportDetail {
  def main(args: Array[String]): Unit = {

  }
}

class BigPerson{
  import scala.beans.BeanProperty // 需要時才引入，作用域只在{}
  @BeanProperty var name: String = _

  def test01(): Unit ={
    import java.util.{HashMap=>JavaHashMap, List}
    import scala.collection.mutable.{HashMap, HashSet}
    var map1 = new HashMap() // 此時的HashMap指向的是scala中的HashMap
    var map2 = new JavaHashMap() // 此時使用的是java中HashMap的別名
  }

  def test02(): Unit ={
    import java.util.{HashMap=>_, _} // 涵義為引入java.util包的所有類，但是忽略HashMap類
    var map3 = new HashMap() // 此時的HashMap指向的是scala中的HashMap，而且Idea工具的提示也不會顯示java.util的HashMap
  }
}

class SmallPerson{
//  @BeanProperty var name: String = _ // 需另外import一次，或者在最上方Import
}