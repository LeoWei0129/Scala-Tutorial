package com.unimicron.chapter17.proxy.remotes.remote

object TestCandyMachine {
  def main(args: Array[String]): Unit = {
    // 創建一個監控器
    val mMonitor = new Monitor()

    var mCandyMachine = new CandyMachine("Taipei", 4)
    mMonitor.addMachine(mCandyMachine)

    mCandyMachine = new CandyMachine("Tainan", 6)
    // 改變台南糖果區的狀態
    mCandyMachine.insertCoin()
    mMonitor.addMachine(mCandyMachine)

    mCandyMachine = new CandyMachine("Taichung", 14)
    // 改變台中糖果區的狀態
    mCandyMachine.insertCoin()
    mCandyMachine.turnCrank()
    mMonitor.addMachine(mCandyMachine)

    // 輸出監控管理器的所有糖果機情況
    mMonitor.report()
  }
}
