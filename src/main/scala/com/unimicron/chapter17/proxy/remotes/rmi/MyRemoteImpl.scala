package com.unimicron.chapter17.proxy.remotes.rmi

import java.rmi.registry.LocateRegistry
import java.rmi.{Naming, RemoteException}
import java.rmi.server.UnicastRemoteObject

/**
 * UnicastRemoteObject: 統一遠程傳播的對象
 * MyRemoteImpl實現了MyRemote
 */

class MyRemoteImpl extends UnicastRemoteObject with MyRemote {
  @throws(classOf[RemoteException])
  override def sayHello(): String = {
    "Hello World"
  }
}

// 這裡完成對服務(sayHello)的註冊任務
object MyRemoteImpl {
  def main(args: Array[String]): Unit = {
    val service: MyRemote = new MyRemoteImpl()

    // 準備把服務綁定到9999接口
    // 註冊的目的是要將地址與Naming綁定
    // Naming是RMI機制的管理器，對註冊的服務進行管理
    // RemoteHello就是服務，服務內可以有多個方法
//    LocateRegistry.createRegistry(9999)
//    Naming.rebind("RemoteHello", service)
    Naming.rebind("rmi://127.0.0.1:10001/RemoteHello", service)
    println("遠程服務開啟，在127.0.0.1:9999上監聽，服務名RemoteHello")
  }
}


