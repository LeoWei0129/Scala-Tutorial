package com.unimicron.chapter17.proxy.remotes.remote

import scala.collection.mutable.ListBuffer

/**
 * 這個是監控糖果的類
 * 尚未加入代理功能
 */

class Monitor {
  // 監控多台糖果機
  private val candyMachineList: ListBuffer[CandyMachine] = new ListBuffer[CandyMachine]

  // 給監控器增加一台糖果機
  def addMachine(mCandyMachine: CandyMachine) = {
    candyMachineList.append(mCandyMachine)
  }

  // 輸出監控器管理的各個糖果機訊息
  def report()= {
    for(mCandyMachine <- this.candyMachineList){
      println("======================")
      println("Machine location: " + mCandyMachine.getLocation())
      println("Machine candy count: " + mCandyMachine.getCount())
      println("Machine state: " + mCandyMachine.getState().getStateName())
    }
  }
}
