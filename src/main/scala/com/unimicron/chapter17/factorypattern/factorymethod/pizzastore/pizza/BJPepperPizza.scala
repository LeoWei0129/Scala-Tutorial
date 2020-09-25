package com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.pizza

class BJPepperPizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "北京胡椒披薩"
    println(this.name + "preparing...")
  }
}
