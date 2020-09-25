package com.unimicron.chapter17.factory.simplefactory.pizzastore.order

import com.unimicron.chapter17.factory.simplefactory.pizzastore.pizza.{CheesePizza, GreecePizza, PepperPizza, Pizza}

import scala.util.control.Breaks.break

object PizzaSimpleFactory {
  // 提供了一個創建Pizza的方法，有需要創建Pizza時就調用該方法
  def createPizza(t: String): Pizza = {
    var pizza: Pizza = null

    if(t.equals("greece")){
      // 創建Pizza
      pizza = new GreecePizza
    }else if(t.equals("pepper")){
      // 創建Pizza
      pizza = new PepperPizza
    } else if(t.equals("cheese")){
      // 創建Pizza
      pizza = new CheesePizza
    }

    pizza
  }
}
