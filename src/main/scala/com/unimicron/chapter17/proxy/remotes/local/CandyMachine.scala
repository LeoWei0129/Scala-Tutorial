package com.unimicron.chapter17.proxy.remotes.local

class CandyMachine extends State{
  var location: String = _
  var count: Int = _

  def this(location: String, count: Int){
    this
    this.location = location
    this.count = count
  }

  def getLocation(): String = {
    location
  }

  def getCount(): Int = {
    count
  }

  def getState(): State = {
    this
  }

  override def insertCoin(): Unit = {
    println("insertCoin method")
  }

  override def returnCoin(): Unit = {
    println("returnCoin method")
  }

  override def turnCrank(): Unit = {
    println("turnCrank method")
  }

  override def printState(): Unit = {
    println("printState method")
  }

  override def getStateName(): String = {
    "getStateName method"
  }

  override def dispense(): Unit = {
    println("dispense method")
  }
}
