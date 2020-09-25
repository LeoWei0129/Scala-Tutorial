package com.unimicron.chapter09

object ExtendsExample01 {
  def main(args: Array[String]): Unit = {
    val account1 = new CheckingAccount(100.5)
    println(account1.deposit(10.2))
    println(account1.withdraw(3.2))
    println(account1.deposit(8.3))
    println(account1.deposit(4.5))
    println(account1.withdraw(5.8))

    val account2 = new SavingAccount(200.0)
    println(account2.earnMonthlyInterest())
    println(account2.deposit(10.2))
    println(account2.withdraw(3.2))
    println(account2.deposit(8.3))
    println(account2.deposit(4.5))
    println(account2.withdraw(5.8))
  }
}

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  // 存款操作，直接加上存款
  def deposit(amount: Double): Double = {
    balance += amount
    balance
  }

  // 提款操作，直接剪去提款
  def withdraw(amount: Double): Double = {
    balance -= amount
    balance
  }
}

// 提款和存款皆須付手續費0.1元
class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  // 這裡調用父類的deposit()
  // 但傳入參數更動，相當於重寫了這個方法
  override def deposit(amount: Double): Double = super.deposit(amount - 0.1)

  override def withdraw(amount: Double): Double = super.withdraw(amount + 0.1)
}

// 每個月都有利息產生(earnMonthlyInterest方法被調用)
// 並且有每月三次免手續費的存款或取款
// 在earnMonthlyInterest方法中重置交易計數
class SavingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private var num: Int = _ // 免手續費的次數

  def earnMonthlyInterest(): Unit = {
    num = 3 // 每個月初，系統調用該方法，計算利息，將num=3
    super.deposit(0.02) // 存入利息
  }

  override def deposit(amount: Double): Double = {
    // 取款時，如果num < 0，需收手續費，否則不收
    num -= 1
    if (num < 0) {
      super.deposit(amount - 0.1)
    } else {
      super.deposit(amount)
    }
  }

  override def withdraw(amount: Double): Double = {
    // 提款時，如果num < 0，需收手續費，否則不收
    num -= 1
    if (num < 0) {
      super.withdraw(amount + 0.1)
    } else {
      super.withdraw(amount)
    }
  }
}
