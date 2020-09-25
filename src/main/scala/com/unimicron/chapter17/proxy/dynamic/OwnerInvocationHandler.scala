package com.unimicron.chapter17.proxy.dynamic

import java.lang.reflect.{InvocationHandler, Method}

/**
 * 自己調用的代理
 */

class OwnerInvocationHandler extends InvocationHandler {
  // 被調用的對象PersonBeanImpl
  var person: PersonBean = _

  def this(person: PersonBean) {
    this
    this.person = person
  }

  /**
   * 反射原理: 方法寫前面，對象當作第一個參數傳入，是否還有第二、三..個參數
   * 根據當前方法須帶幾個參數決定
   *
   * @param proxy 和 OwnerInvocationHandler合作的代理Proxy
   * @param method
   * @param args 根據在MatchService中的NonOwnerProxy對象調用方法時傳入的參數以及個數決定
   * @throws java.lang.Throwable
   * @return
   */
  @throws(classOf[Throwable])
  override def invoke(proxy: Any, method: Method, args: Array[AnyRef]): AnyRef = {
    if (method.getName().startsWith("get")) {
      return method.invoke(person)
    } else if (method.getName().equals("setScore")) {
      return new IllegalArgumentException()
    } else if (method.getName().startsWith("set")) {
      return method.invoke(person, args(0).toString())
    }

    null
  }
}
