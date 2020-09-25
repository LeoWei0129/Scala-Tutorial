package com.unimicron.crm.view

import com.unimicron.crm.bean.Customer
import com.unimicron.crm.service.CustomerService

import scala.io.StdIn
import util.control.Breaks._

class CustomerView {
  // 定義一個循環變量，控制是否退出do-while
  var loop: Boolean = true
  // 定義一個key，用於接收用戶的選項
  var key: Char = ' '
  val customerService = new CustomerService()

  def mainMenu() = {
    do {
      println("------------------客戶關係管理系統------------------")
      println("                  1. 添 加 客 戶")
      println("                  2. 修 改 客 戶")
      println("                  3. 刪 除 客 戶")
      println("                  4. 客 戶 列 表")
      println("                  5. 退 出 系 統")
      println("請選擇(1-5): ")

      key = StdIn.readChar()
      key match {
        case '1' => this.customerAdd()
        case '2' => println("修改客戶")
        case '3' => this.customerDel()
        case '4' => this.customerList()
        case '5' => this.loop = false
      }
    } while (loop)
    println("退出成功!")
  }

  /**
   * 顯示客戶列表介面
   */
  def customerList() = {
    println()
    println("--------------------客戶列表--------------------")
    println("編號\t\t姓名\t\t性別\t\t年齡\t\t電話\t\t信箱")
    // for循環遍歷所有客戶(CustomerService的ArrayBuffer)
    val customers = customerService.showList()
    for (customer <- customers) {
      // 重寫customer的toString()，返回訊息(並且格式化)
      println(customer)
    }
  }

  def customerAdd() = {
    println()
    println("--------------------添加客戶--------------------")
    println("姓名:")
    val name = StdIn.readLine()
    println("性別:")
    val gender = StdIn.readChar()
    println("年齡:")
    val age = StdIn.readShort()
    println("電話:")
    val tel = StdIn.readLine()
    println("信箱:")
    val email = StdIn.readLine()

    // 創建customer對象
    val customer = new Customer(name, gender, age, tel, email)
    customerService.addCustomer(customer)
    println("添加完成")
  }

  def customerDel(): Unit = {
    println()
    println("--------------------刪除客戶--------------------")
    println("請輸入欲刪除的客戶編號(-1退出): ")
    val id = StdIn.readInt()
    if (id == -1) {
      println("-------------------刪除沒有完成-------------------")
      return
    }

    // 用戶必須輸入Y/N，否則循環提示
    println("確認是否刪除(Y/N): ")
    var choice = ' '
    breakable {
      do {
        choice = StdIn.readChar().toLower
        if (choice == 'y' || choice == 'n') {
          break()
        }
        println("輸入錯誤，確認是否刪除(Y/N): ")
      } while (true)
    }

    if (choice == 'y') {
      if (customerService.delCustomer(id)) {
        println("--------------------刪除完成--------------------")
        return
      }
    }
    println("-------------------刪除沒有完成-------------------")
  }
}
