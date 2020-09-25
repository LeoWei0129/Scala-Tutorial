package com.unimicron.chapter17.observer.observers

/**
 * 氣象局的公告版
 */

class CurrentConditions extends Observer {
  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  def display() = {
    println("***氣象局的天氣公告版 Today's temperature: " + mTemperature + "***")
    println("***氣象局的天氣公告版 Today's pressure: " + mPressure + "***")
    println("***氣象局的天氣公告版 Today's humidity: " + mHumidity + "***")
  }

  override def update(mTemperature: Float, mPressure: Float, mHumidity: Float): Unit = {
    // 更新天氣訊息
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    // 顯示更新後的訊息
    display()
  }
}
