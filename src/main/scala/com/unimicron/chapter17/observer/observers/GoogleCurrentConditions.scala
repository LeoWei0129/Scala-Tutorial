package com.unimicron.chapter17.observer.observers

/**
 * 新增一個第三方的天氣公告版
 * 只需這裡新增一個類即可，其他地方的代碼不須更動
 * 每個第三方的業務邏輯可依自己的需求進行修改
 */

class GoogleCurrentConditions extends Observer {
  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _

  def display() = {
    println("***Google的天氣公告版 Today's temperature: " + mTemperature + "***")
    println("***Google的天氣公告版 Today's pressure: " + mPressure + "***")
    println("***Google的天氣公告版 Today's humidity: " + mHumidity + "***")
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
