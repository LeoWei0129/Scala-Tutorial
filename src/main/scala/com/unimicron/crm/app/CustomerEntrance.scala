package com.unimicron.crm.app

import com.unimicron.crm.view.CustomerView

object CustomerEntrance {
  def main(args: Array[String]): Unit = {
    new CustomerView().mainMenu()
  }
}
