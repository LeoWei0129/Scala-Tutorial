package com.unimicron.chapter17.factory.absfactory.pizzastore.order

import com.unimicron.chapter17.factory.absfactory.pizzastore.pizza.Pizza

trait AbsFactory {
  // 定義一個抽象方法
  def createPizza(t: String): Pizza
}
