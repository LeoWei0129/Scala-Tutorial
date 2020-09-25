package com.unimicron.chapter17.observer.observers

// Observer須被定義成一個trait
trait Observer {
  // 抽象方法，等待其他觀察者實現
  def update(mTemperature: Float, mPressure: Float, mHumidity: Float)
}
