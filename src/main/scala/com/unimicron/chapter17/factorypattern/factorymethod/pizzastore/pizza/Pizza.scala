package com.unimicron.chapter17.factorypattern.factorymethod.pizzastore.pizza

abstract class Pizza {
  var name: String = _

  // 假設每種pizza的準備材料不同，因此該方法做成抽象的
  def prepare()

  def cut(): Unit = {
    println(this.name + "cutting...")
  }

  def bake(): Unit = {
    println(this.name + "baking...")
  }

  def box(): Unit = {
    println(this.name + "boxing...")
  }
}
