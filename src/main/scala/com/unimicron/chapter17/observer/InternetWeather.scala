package com.unimicron.chapter17.observer

import com.unimicron.chapter17.observer.observers.{CurrentConditions, GoogleCurrentConditions}
import com.unimicron.chapter17.observer.subjects.WeatherSubject

object InternetWeather {
  def main(args: Array[String]): Unit = {
    val mWeatherSubject = new WeatherSubject

    // 創建一個氣象站的天氣公告版
    val mCurrentCondition = new CurrentConditions()
    // 創建一個Google的天氣公告版(第三方)
    val gCurrentCondition = new GoogleCurrentConditions()

    // 註冊氣象站
    mWeatherSubject.registerObserver(mCurrentCondition)
    // 註冊Google
    mWeatherSubject.registerObserver(gCurrentCondition)

    // 比如天氣穩定，這裡設置最新數據
    mWeatherSubject.setData(30, 150, 40)

    println("------------------------------------------")

    // 每過30秒，再次調用mWeatherSubject.setData()，為所有第三方和氣象站即時更新數據
    // 如果在網路編程的應用下，如Akka，只需要編寫好第三方的類別後，發消息給mWeatherSubject，
    // 第三方就可被加入集合中，跟其他第三方一起同步更新，不須重新啟動InternetWeather.scala
  }
}
