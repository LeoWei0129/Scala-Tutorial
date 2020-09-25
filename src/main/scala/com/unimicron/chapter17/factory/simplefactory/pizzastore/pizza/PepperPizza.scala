package com.unimicron.chapter17.factory.simplefactory.pizzastore.pizza

class PepperPizza extends Pizza{
  override def prepare(): Unit = {
    this.name = "胡椒披薩"
    println(this.name + "preparing...")
  }
}
