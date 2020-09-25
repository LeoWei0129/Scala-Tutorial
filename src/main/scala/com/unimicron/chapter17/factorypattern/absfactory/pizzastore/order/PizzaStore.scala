package com.unimicron.chapter17.factorypattern.absfactory.pizzastore.order

object PizzaStore extends App{
  new OrderPizza(new BJFactory)
  new OrderPizza(new LDFactory)
}
