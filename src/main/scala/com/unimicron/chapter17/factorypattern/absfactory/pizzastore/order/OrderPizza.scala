package com.unimicron.chapter17.factorypattern.absfactory.pizzastore.order

import com.unimicron.chapter17.factorypattern.absfactory.pizzastore.pizza.Pizza

import scala.io.StdIn
import util.control.Breaks._

// OrderPizza，當我們使用抽象工廠模式後，我們訂購一個Pizza的思路
// 接收一個子工廠實例，根據改子工廠的創建要求去創建Pizza實例
class OrderPizza {
//  var absFactory: AbsFactory = _
  var orderType: String = _
  var pizza: Pizza = _

  def this(absFactory: AbsFactory){
    this

    breakable{
      do{
        println("請輸入pizza的類型")
        orderType = StdIn.readLine()

        // 使用抽象工廠模式創建Pizza對象
        this.pizza = absFactory.createPizza(orderType)
        if(this.pizza == null) {
          println("fuck you")
          break()
        }

        this.pizza.prepare()
        this.pizza.bake()
        this.pizza.cut()
        this.pizza.box()
      }while(true)
    }
  }

}
