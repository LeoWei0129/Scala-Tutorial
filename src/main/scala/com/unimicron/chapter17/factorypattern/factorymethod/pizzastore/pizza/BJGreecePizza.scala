package com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.pizza

class BJGreecePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "北京希臘披薩"
    println(this.name + "preparing...")
  }
}
