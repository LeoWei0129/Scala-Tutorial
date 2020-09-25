package com.unimicron.chapter17.decorator.decorators

import com.unimicron.chapter17.decorator.components.Drink

class Milk(obj: Drink) extends Decorator(obj) {
  setDescription("Milk")
  setPrice(1.0f)
}
