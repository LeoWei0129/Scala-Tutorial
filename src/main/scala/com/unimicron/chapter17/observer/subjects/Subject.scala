package com.unimicron.chapter17.observer.subjects

import com.unimicron.chapter17.observer.observers.Observer

// Subject須被定義成一個trait
trait Subject {
  // 註冊
  def registerObserver(o: Observer)
  // 移除
  def removeObserver(o: Observer)
  // 通知
  def notifyObservers()
}
