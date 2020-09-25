package com.unimicron.chapter06.animal01.abc

// 包名com.unimicron.chapter06.animal01.abc -> com.unimicron.chapter06.animal01.abcd
// 在儲存.class實際路徑中，./abc會被刪除，新增./abcd來儲存.class

// 包名: com.unimicron.chapter06.animal01.abc
// 此份文件(TGiger.scala)所在實際路徑: C:\\Users\\a0846\\IdeaProjects\\scala-practice\\src\\main\\scala\\com\\unimicron\\chapter06\\animal01
// 上面這個路徑由第一次編譯後決定，就不會再改變
// .class檔(Tiger.class)所在實際路徑: C:\\Users\\a0846\\IdeaProjects\\scala-practice\\target\\classes\\com\\unimicron\\chapter06\\animal01\\abc
// 上面這個路徑會隨著包名改變而在每次編譯後也改變
// 好處: 源文件(Tiger.scala)在哪寫(任意目錄結構下)都可以(也就是說可以任意指定包名)，增加了靈活性
class Tiger {

}
