package com.unimicron.chapter17.proxy.remotes.rmi

import java.rmi.{Remote, RemoteException}

/**
 * 這是一個接口文件，該文件會給遠程端和本地端來使用
 */

trait MyRemote extends Remote{
  // 抽象方法，由遠程端服務器實現
  // 必須要拋RemoteException，否則RMI跑步起來
  @throws(classOf[RemoteException])
  def sayHello(): String
}
