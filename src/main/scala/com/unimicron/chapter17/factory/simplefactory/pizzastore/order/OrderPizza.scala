package com.unimicron.chapter17.factory.simplefactory.pizzastore.order

import com.unimicron.chapter17.factory.simplefactory.pizzastore.pizza.{GreecePizza, PepperPizza, Pizza}

import scala.io.StdIn
import util.control.Breaks._

class OrderPizza {
  var orderType: String = _
  var pizza: Pizza = _

  breakable{
    do{
      println("請輸入pizza的類型")
      orderType = StdIn.readLine()

      // 使用簡單工廠模式創建Pizza對象
      this.pizza = PizzaSimpleFactory.createPizza(orderType)
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
}
