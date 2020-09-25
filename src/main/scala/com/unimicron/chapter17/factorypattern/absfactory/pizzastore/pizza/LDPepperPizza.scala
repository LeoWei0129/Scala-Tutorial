package com.unimicron.chapter17.factorypattern.absfactory.pizzastore.pizza

class LDPepperPizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "倫敦胡椒披薩"
    println(this.name + "preparing...")
  }
}
