// package com.unimicron{}，創建了包com.unimicron，{}代表我們對這個包裡面內容的編寫，
// 可以是子包、類、特質trait、object
// 即scala支持，在一個文件中，可以同時創建多個包、類、trait、object，以及各個包創建類、trait、object
// 此份源文件編譯後會生成3個.class，Tree.class、WayDemo03.class、WayDemo03$.class

// 之後才創建的package com.unimicron.chapter06.packageway.subpackage、
// class package com.unimicron.chapter06.packageway.Tree、class com.unimicron.User
// class com.unimicron.chapter06.packageway.subpackage.Tree
// 會在實際目錄下生成對應的資料夾和.class文件，但在IDE中的目錄結構不會生成
import com.unimicron.chapter06.packageway.subpackage.Tree

package com.unimicron{ // package com.unimicron
  package chapter06.packageway{ // package chapter06.packageway
    object WayDemo03 { // create object WayDemo03 under package com.unimicron.chapter06.packageway
      def main(args: Array[String]): Unit = {
        println("Hello WayDemo03")
        val tree1 = new Tree
        println(tree1.name)

        // 子包有User類，父包也有User類，重名時，採就近原則
        val user1 = new User
        println(user1.name)

        // 子包可以直接使用父包的內容，但重名時，必須指定包名路徑
        val user2 = new com.unimicron.User
        println(user2.name)

        // 此時packageway作為subpackage的父類，在packageway中不可引用subpackage的class、object、trait
        // 但若真的要用子包的內容，必須額外寫import
        // 不過因為Tree重名，需要指定包名路徑(就算有指定包名路徑，也需要import)
        val tree2 = new com.unimicron.chapter06.packageway.subpackage.Tree
        println(tree2.name)
        tree2.testHello() // 調用包對象的方法
      }
    }

    class Tree{ // create class Tree under package com.unimicron.chapter06.packageway
      val name = "little"
    }

    class User {
      val name = "WayDemo03's User"
    }

    // 在包中直接寫方法或定義變量，會報錯 -> 用包對象的方式解決
    package subpackage{ // 創建子包 com.unimicron.chapter06.packageway.subpackage
      class Tree{ // 兩個Tree在不同的包下，不會衝突
        val name = "huge"

        def testHello(): Unit ={
          sayHello()
        }
      }
    }

    //package object subpackag表示創建一個包對象subpackage，他是com.unimicron.chapter06.packageway.subpackage這個包對應的包對象
    // 每一個包都可以有一個包對象
    // 包對象的名稱必須和子包一樣
    // 在包對象中可以定義方法、變量
    // 在包對象中定義的方法、變量，可以在對應的包中使用
    package object subpackage{
      val name = "object subpackage"

      def sayHello(): Unit = {
        println("Hello " +  name)
      }
    }
  }

  class User { // 在com.unimicron下創建類User
    val name = "packageway's User"
  }
}