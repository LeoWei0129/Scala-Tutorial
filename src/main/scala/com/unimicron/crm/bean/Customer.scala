package com.unimicron.crm.bean

class Customer {
  // 1. 屬性
  var id: Int = _
  var name: String = _
  var gender: Char = _
  var age: Short = _
  var tel: String = _
  var email: String = _

  // 2. 編寫輔助構造器(不要寫死主構造器)
  /**
   * 創建ArrayBuffer時，傳入的Customer(創建)調用
   * @param id
   * @param name
   * @param gender
   * @param age
   * @param tel
   * @param email
   */
  def this(id: Int, name: String, gender: Char, age: Short, tel: String, email: String){
    this // 調用主構造器
    this.id = id
    this.name = name
    this.gender = gender
    this.age = age
    this.tel = tel
    this.email = email
  }

  /**
   * 添加客戶時調用
   * @param name
   * @param gender
   * @param age
   * @param tel
   * @param email
   */
  def this(name: String, gender: Char, age: Short, tel: String, email: String){
    this // 調用主構造器
    this.name = name
    this.gender = gender
    this.age = age
    this.tel = tel
    this.email = email
  }

  override def toString: String = {
    this.id + "\t\t\t" + this.name + "\t\t\t" + this.gender + "\t\t\t" +
      this.age + "\t\t\t" + this.tel + "\t\t\t" + this.email
  }
}