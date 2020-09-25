package com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.order

import com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.pizza.Pizza

import scala.io.StdIn
import util.control.Breaks._

abstract class OrderPizza {
  var orderType: String = _
  var pizza: Pizza = _

  breakable{
    do{
      println("請輸入pizza的類型")
      orderType = StdIn.readLine()

      // 使用工廠方法模式創建Pizza對象
      this.pizza = createPizza(orderType)
      if(this.pizza == null) {
        println("fuck you")
        break()
      }

//      if(orderType.equals("greece")){
//        // 創建Pizza
//        this.pizza = new GreecePizza
//      }else if(orderType.equals("pepper")){
//        // 創建Pizza
//        this.pizza = new PepperPizza
//      }else{
//        break()
//      }

      this.pizza.prepare()
      this.pizza.bake()
      this.pizza.cut()
      this.pizza.box()
    }while(true)
  }

  // 抽象的方法，createPizza(orderType)，讓各個子類的實現order
  def createPizza(str: String): Pizza
}
