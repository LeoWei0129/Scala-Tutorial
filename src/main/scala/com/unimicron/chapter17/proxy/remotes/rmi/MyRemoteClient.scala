package com.unimicron.chapter17.proxy.remotes.rmi

import java.rmi.Naming

class MyRemoteClient {
  def go() = {
    val service = Naming.lookup("rmi://127.0.0.1:10001/RemoteService").asInstanceOf[MyRemote]
    val str = service.sayHello()
    println(str)
  }
}

object MyRemoteClient {
  def main(args: Array[String]): Unit = {
    new MyRemoteClient().go()
  }
}
