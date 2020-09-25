package com.unimicron.chapter17.proxy.dynamic

/**
 * 這個是真正要被調用的對象
 */

class PersonBeanImpl extends PersonBean {
  var name: String = _
  var gender: String = _
  var interests: String = _
  var score: Int = _

  override def getName(): String = {
    name
  }

  override def getGender(): String = {
    gender
  }

  override def getInterests(): String = {
    interests
  }

  override def getScore(): Int = {
    score
  }

  /**
   * 自己可以調用，其他用戶不能調用
   * @param name
   */
  override def setName(name: String): Unit = {
    this.name = name
  }

  /**
   * 自己可以調用，其他用戶不能調用
   * @param gender
   */
  override def setGender(gender: String): Unit = {
    this.gender = gender
  }

  /**
   * 自己可以調用，其他用戶不能調用
   * @param interests
   */
  override def setInterests(interests: String): Unit = {
    this.interests = interests
  }

  /**
   * 自己不能調用，其他用戶可以調用
   *
   * @param score
   */
  override def setScore(score: Int): Unit = {
    this.score = score
  }
}
