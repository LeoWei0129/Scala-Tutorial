package com.unimicron.chapter17.factorypattern.simplefactory.pizzastore.pizza

class GreecePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "希臘披薩"
    println(this.name + "preparing...")
  }
}
