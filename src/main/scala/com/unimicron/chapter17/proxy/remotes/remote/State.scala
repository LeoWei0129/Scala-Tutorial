package com.unimicron.chapter17.proxy.remotes.remote

/**
 * 糖果機的狀態
 * 每種狀態另外以class寫
 * OnReadyState
 * SoldOutState
 * SoldState
 * HasCoinState
 */

trait State extends Serializable {
  // 定義user動作，糖果機的每種狀態都會和這些動作關聯
  def insertCoin() // 插入硬幣
  def returnCoin() // 返回硬幣
  def turnCrank() // 轉動手柄
  def printState() // 輸出狀態
  def getStateName(): String // 返回狀態名字
  def dispense() // 分配狀態，比如賣出一顆糖後，就看看當前糖果機應該進入哪個狀態
  /*
  EX: SoldState的dispense()中，判斷是否還有糖果，沒有就進入/調用class SoldOutState
   */
}
