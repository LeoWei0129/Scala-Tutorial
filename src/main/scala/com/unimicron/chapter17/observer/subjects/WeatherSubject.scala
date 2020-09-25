package com.unimicron.chapter17.observer.subjects
import com.unimicron.chapter17.observer.observers.Observer

import scala.collection.mutable.ListBuffer

class WeatherSubject extends Subject {
  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _
  // 集合，用於管理所有的觀察者
  private var mObservers: ListBuffer[Observer] = new ListBuffer[Observer]

  def getTemperature() = {
    mTemperature
  }

  def getPressure() = {
    mPressure
  }

  def getHumidity() = {
    mHumidity
  }

  // 一旦天氣變化，就通知所有觀察者
  def dataChange() = {
    notifyObservers()
  }

  def setData(mTemperature: Float, mPressure: Float, mHumidity: Float) = {
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    dataChange()
  }

  // 註冊
  override def registerObserver(o: Observer): Unit = {
    mObservers.append(o)
  }

  // 移除，比如某個第三方不再想接入
  override def removeObserver(o: Observer): Unit = {
    if(mObservers.contains(o)){
      mObservers -= o
    }
  }

  // 通知，天氣情況改變了，就通知所有observer
  override def notifyObservers(): Unit = {
    for(observer <- mObservers){
      observer.update(mTemperature, mPressure, mHumidity)
    }
  }
}
