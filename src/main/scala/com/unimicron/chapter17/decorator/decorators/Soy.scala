package com.unimicron.chapter17.decorator.decorators

import com.unimicron.chapter17.decorator.components.Drink

class Soy(obj: Drink) extends Decorator(obj) {
  setDescription("Soy")
  setPrice(1.5f)
}
