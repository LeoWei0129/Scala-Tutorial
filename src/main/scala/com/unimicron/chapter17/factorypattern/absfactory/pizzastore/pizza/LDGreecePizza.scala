package com.unimicron.chapter17.factorypattern.absfactory.pizzastore.pizza

class LDGreecePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "倫敦希臘披薩"
    println(this.name + "preparing...")
  }
}
