package com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.order

import com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.pizza.{LDCheesePizza, LDGreecePizza, LDPepperPizza, Pizza}

class LDOrderPizza extends OrderPizza {
  override def createPizza(t: String): Pizza = {
    // 使用工廠方法模式創建
    var pizza: Pizza = null

    if(t.equals("greece")){
      // 創建Pizza
      pizza = new LDGreecePizza
    }else if(t.equals("pepper")){
      // 創建Pizza
      pizza = new LDPepperPizza
    } else if(t.equals("cheese")){
      // 創建Pizza
      pizza = new LDCheesePizza
    }

    pizza
  }
}
