package com.unimicron.chapter17.factory.factorymethod.pizzastore.pizza

class LDGreecePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "倫敦希臘披薩"
    println(this.name + "preparing...")
  }
}
