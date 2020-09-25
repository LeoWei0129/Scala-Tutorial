package com.unimicron.chapter10

object ImplicitClassDemo01 {
  def main(args: Array[String]): Unit = {
    // DB1是一個隱式類，當我們在該隱式類的作用域範圍，創建MySQL1實例
    // 該隱式類就會生效，這個工作由編譯器完成
    // 隱式類也可以寫在object的下一個層級，不一定是在object->def之下(只要求不可寫在頂層，且創建的實例要在該隱式類的作用域下)
    implicit class DB1(val m: MySQL1){ // ImplicitClassDemo$DB1$2
      def addSuffix(): String = {
        m + " Scala"
      }
    }

    // 創建一個MySQL1實例
    val mysql =  new MySQL1
    mysql.sayOk()

    // private static final ImplicitClassDemo01$DB1$1 DB1$2(MySQL1 m) {
    //    return new ImplicitClassDemo01$DB1$1(m);
    //  }
    // 這種做法可以讓MySQL1增加功能addSuffix()，但底層還是由DB1去調用addSuffix()
    // 當沒調用mysql.addSuffix()時，mysql不會進行隱式轉換
    println(mysql.addSuffix()) // 底層: DB1$2(mysql).addSuffix()，DB1$2()這個constructor會回傳一個DB1的實例，有了這個實例對象，就會去調用addSuffix()
  }
}

class MySQL1{
  def sayOk() = {
    println("sayOK~~")
  }
}
