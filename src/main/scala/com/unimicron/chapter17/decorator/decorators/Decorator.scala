package com.unimicron.chapter17.decorator.decorators

import com.unimicron.chapter17.decorator.components.Drink

// 這個就是裝飾者
class Decorator extends Drink{
  // obj就是被裝飾的對象Drink
  // obj可以是單品咖啡or單品咖啡+調料組合
  private var obj: Drink = null

  def this(obj: Drink){
    this // 需先調用主構造器，否則報錯
    this.obj = obj
  }

  /**
   * 實現cost()
   * obj.cost()是遞歸調用
   * 因為obj可能是如(Decaf, Soy)的組合，此時的Decorator是Milk，欲變成(Decaf, Soy, Milk)
   * this.getPrice()是Milk的
   * obj.cost()是(Decaf, Soy)的
   *
   * @return
   */
  override def cost(): Float = {
    this.getPrice() + obj.cost()
  }

  /**
   * 獲取信息時，也需要遞歸獲取(obj.getDescription())
   * 道理同cost()
   *
   * @return
   */
  override def getDescription(): String = {
    super.getDescription() + " && " + obj.getDescription()
  }
}
