package com.unimicron.chapter17.decorator.components

/**
 * Component和ConcreteComponent之間的緩衝層
 * 這是為了擴展，可能有其他大項的飲品(茶)，目前這個例子可以不用
 */

class Coffee extends Drink {
  override def cost(): Float = {
    super.getPrice()
  }
}
