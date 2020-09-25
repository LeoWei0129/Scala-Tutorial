package com.unimicron.chapter17.factory.absfactory.pizzastore.order

import com.unimicron.chapter17.factory.absfactory.pizzastore.pizza.{BJCheesePizza, BJGreecePizza, BJPepperPizza, Pizza}

// 這裡實現了AbsFactory的一個子類工廠
// 如果我們希望訂購北京的Pizza就使用該工廠子類
class BJFactory extends AbsFactory {
  override def createPizza(t: String): Pizza = {
    // 使用抽象工廠模式創建
    var pizza: Pizza = null

    if(t.equals("greece")){
      // 創建Pizza
      pizza = new BJGreecePizza
    }else if(t.equals("pepper")){
      // 創建Pizza
      pizza = new BJPepperPizza
    } else if(t.equals("cheese")){
      // 創建Pizza
      pizza = new BJCheesePizza
    }

    pizza
  }
}
