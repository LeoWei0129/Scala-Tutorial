package com.unimicron.chapter17.decorator.components

/**
 * Drink表示飲品，是一個抽象類
 *
 */

abstract class Drink {
  var description = ""
  private var price = 0.0f

  def setDescription(description: String): Unit = {
    this.description = description
  }

  def getDescription(): String = {
    description + "價格: " + this.getPrice()
  }

  def getPrice(): Float = {
    price
  }

  def setPrice(price: Float): Unit = {
    this.price = price
  }

  /**
   * 將計算成本的方法做成一個抽象方法
   * 因為當前設計階段不確定是要做成單品或組合
   * @return
   */
  def cost(): Float
}
