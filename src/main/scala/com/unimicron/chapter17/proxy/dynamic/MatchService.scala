package com.unimicron.chapter17.proxy.dynamic

import java.lang.reflect._

class MatchService {
  // 創建一個Person
  val tom = getPersonInfo("Tom", "male", "swimming")

  // 得到一個給自己的代理對象，他替代被調用的對象
  val OwnerProxy = getOwnerProxy(tom)

  println(OwnerProxy.getName())
  println(OwnerProxy.getInterests())
  OwnerProxy.setInterests("shopping")
  println(OwnerProxy.getInterests())
  println(OwnerProxy.getScore())
  OwnerProxy.setScore(5) // 會有異常處理Throwable

  // NonOwnerInvocationHandler類似

  def getPersonInfo(name: String, gender: String, interests: String): PersonBean = {
    val person = new PersonBeanImpl()
    person.setName(name)
    person.setGender(gender)
    person.setInterests(interests)
    person
  }

  def getOwnerProxy(person: PersonBean): PersonBean = {
    Proxy.newProxyInstance(person.getClass.getClassLoader(), person.getClass().getInterfaces(),
      new OwnerInvocationHandler(person)).asInstanceOf[PersonBean]
  }
}
