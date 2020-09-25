package com.unimicron.chapter17.factorypattern.absfactory.pizzastore.order

import com.unimicron.chapter17.factorypattern.absfactory.pizzastore.pizza.{LDCheesePizza, LDGreecePizza, LDPepperPizza, Pizza}

// 這裡實現了AbsFactory的一個子類工廠
// 如果我們希望訂購倫敦的Pizza就使用該工廠子類
class LDFactory extends AbsFactory {
  override def createPizza(t: String): Pizza = {
    // 使用抽象工廠模式創建
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
