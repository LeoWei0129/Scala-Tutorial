package com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.pizza

class BJCheesePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "北京奶烙披薩"
    println(this.name + "preparing...")
  }
}
