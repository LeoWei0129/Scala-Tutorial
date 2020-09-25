package com.unimicron.chapter17.decorator

import com.unimicron.chapter17.decorator.components.{Decaf, Drink, LongBlack}
import com.unimicron.chapter17.decorator.decorators.{Chocolate, Milk}

object CoffeeBar {
  def main(args: Array[String]): Unit = {
    var order1: Drink = new Decaf
    println("order1's description: " + order1.getDescription())
    println("order1's price: " + order1.cost())

    println("-------------------------------------------------")

    // 點一份LongBlack，和兩份Chocolate+一份Milk
    var order2: Drink = new LongBlack
    order2 = new Chocolate(order2)
    order2 = new Chocolate(order2)
    order2 = new Milk(order2)
    println("order2's description: " + order2.getDescription())
    println("order2's price: " + order2.cost())

    println("-------------------------------------------------")

    // 若此時想增加一種新的調料(Salt)，只需要新增一個新的關於這個調料的類別即可
    // 並在這裡繼續調用: order2 = new Salt(order2)
    // line 25是唯一原本代碼中需要修改的
  }
}