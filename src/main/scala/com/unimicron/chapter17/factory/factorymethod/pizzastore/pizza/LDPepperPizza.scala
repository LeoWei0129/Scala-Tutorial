package com.unimicron.chapter17.factory.factorymethod.pizzastore.pizza

class LDPepperPizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "倫敦胡椒披薩"
    println(this.name + "preparing...")
  }
}
