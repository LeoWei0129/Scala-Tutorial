package com.unimicron.chapter17.factory.simplefactory.pizzastore.pizza

class CheesePizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "奶烙披薩"
    println(this.name + "preparing...")
  }
}
