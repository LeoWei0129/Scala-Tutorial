package com.unimicron.chapter07

object BankDemo {
  def main(args: Array[String]): Unit = {
    // 開卡(創建帳號)
    val account1 = new Account("ys00001", 1000.0, "123456")
    account1.query("123456")
    account1.withdraw("123456", 500.0)
  }
}

// 編寫一個Account類
class Account(inAccount: String, inBalance: Double, inPwd: String) {
  /*
  屬性: 帳號、餘額、密碼
  方法: 查詢、存款、提款
   */
  private val accountNo = inAccount
  private var balance = inBalance
  private var pwd = inPwd

  /**
   * 查詢
   *
   * @param pwd : 輸入密碼
   */
  def query(pwd: String): Unit = {
    if (!this.pwd.equals(pwd)) {
      println("密碼錯誤")
      return
    }
    printf("帳號 %s\t當前餘額:%.2f", this.accountNo, this.balance)
  }

  /**
   * 提款
   *
   * @param pwd   輸入密碼
   * @param money 輸入提取金額
   * @return
   */
  def withdraw(pwd: String, money: Double): Any = {
    if (!this.pwd.equals(pwd)) {
      println("密碼錯誤")
      return
    }
    if (this.balance < money) {
      println("餘額不足")
      return
    }
    this.balance -= money
    return money
  }
}
