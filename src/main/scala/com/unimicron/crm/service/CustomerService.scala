package com.unimicron.crm.service

import com.unimicron.crm.bean.Customer

import scala.collection.mutable.ArrayBuffer
import util.control.Breaks._

class CustomerService {
  var customerId = 1
  // customers是存放客戶的，這裡我們先初始化，為了測試
  val customers = ArrayBuffer(new Customer(1, "Tom", '男', 20,
    "555", "tom@google.com"))

  /**
   * 顯示客戶列表
   *
   * @return
   */
  def showList(): ArrayBuffer[Customer] = {
    this.customers
  }

  /**
   * 添加客戶
   *
   * @param customer
   */
  def addCustomer(customer: Customer) = {
    customerId += 1
    customer.id = customerId
    customers.append(customer)
  }

  /**
   * 根據customer的id尋找ArrayBuffer中對應的index
   *
   * @param id
   * @return
   */
  def findIndexById(id: Int): Int = {
    var index = -1 // 默認值，如果找到id對應的index，則修改index，否則保留並返回-1

    breakable {
      for (i <- 0 until this.customers.length) {
        if (customers(i).id == id) {
          index = i
          break()
        }
      }
    }
    index
  }

  /**
   * 刪除客戶
   *
   * @param id
   * @return
   */
  def delCustomer(id: Int): Boolean = {
    val index = findIndexById(id)

    index match {
      case -1 => false
      case _ => {
        customers.remove(index)
        true
      }
    }
  }
}
