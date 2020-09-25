package com.unimicron.chapter17.proxy.dynamic

/**
 * 這個就是Subject，即代理對象，代理對象須定義為一個trait/interface
 */

trait PersonBean {
  def getName(): String

  def getGender(): String

  def getInterests(): String

  def getScore(): Int

  def setName(name: String)

  def setGender(gender: String)

  def setInterests(interests: String)

  def setScore(score: Int)
}
