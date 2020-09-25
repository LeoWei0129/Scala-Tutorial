package com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.order
import com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.pizza.Pizza
import com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.pizza.{BJCheesePizza, BJGreecePizza, BJPepperPizza, Pizza}

class BJOrderPizza extends OrderPizza {
  override def createPizza(t: String): Pizza = {
    // 使用工廠方法模式創建
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
