package com.unimicron.chapter17.factory.factorymethod.pizzastore.pizza

class LDCheesePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "倫敦奶烙披薩"
    println(this.name + "preparing...")
  }
}
