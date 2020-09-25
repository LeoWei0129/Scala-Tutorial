package com.unimicron.chapter17.decorator.decorators

import com.unimicron.chapter17.decorator.components.Drink

class Chocolate(obj: Drink) extends Decorator(obj) {
  setDescription("Chocolate")
  setPrice(2.5f)
}
