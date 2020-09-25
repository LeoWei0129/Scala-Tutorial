package com.unimicron.chapter13.caseclass

/**
 * 現在有一些商品，使用Scala設計相關的樣例類，完成商品綑綁打折出售，要求
 * 1. 商品綑綁可以是單個商品，也可以是多個商品
 * 2. 打折時按照折扣x元進行設計
 * 3. 能夠統計出所有綑綁商品打折的最終價格
 */

object CaseNested {
  def main(args: Array[String]): Unit = {
    // 創建樣例類對象
    val sale = Bundle("書籍", 10.0, Book("漫畫", 40.0),
      Bundle("文學作品", 20.0, Book("Red", 30.0), Book("Rose", 50.0)))

    // case 1: 使用case語句，得到"漫畫"
    val res1 = sale match {
      // 如果我們進行對象匹配時，不想接收某些值，則使用_忽略，_*表示忽略所有
      case Bundle(_, _, Book(desc, _), _*) => desc
    }
    println("res1: " + res1)

    // case 2: 通過@表示法將嵌套的值綁定到變量，_*綁定剩餘item到rest
    val res2 = sale match {
      // 如果我們進行對象匹配時，不想接收某些值，則使用_忽略，_*表示忽略所有
      // 若樣例類裡還有樣例類，被嵌套的樣例類會以WrappedArray進行包裝
      // (Book(漫畫,40.0),WrappedArray(Bundle(文學作品,20.0,WrappedArray(Book(Red,30.0), Book(Rose,50.0)))))
      case Bundle(_, _, layer1@Book(_, _), layer2@_*) => (layer1, layer2)
    }
    println("res2: " + res2)

    // case 3: 不使用_*綁定剩餘item到rest
    val res3 = sale match {
      // 如果我們進行對象匹配時，不想接收某些值，則使用_忽略，_*表示忽略所有
      // layer2 @ _: 指定/明一層，所以直接以定義好的樣例類類名包裝
      // 但由於裡面還有樣例類，但compiler不知道裡面是否還有嵌套的，會以WrappedArray進行包裝
      // (Book(漫畫,40.0),Bundle(文學作品,20.0,WrappedArray(Book(Red,30.0), Book(Rose,50.0))))
      case Bundle(_, _, layer1@Book(_, _), layer2@_) => (layer1, layer2)
    }
    println("res3: " + res3)

    // case4: 以遞歸的形式寫*****
    def priceCalculate(item: Item): Double = {
      // val rest.map(priceCalculate).sum
      // sum(): 將rest.map(priceCalculate)返回的集合再遍歷一次並加總，返回總和值
      item match {
        case Book(_, price) => price
        case Bundle(_, discount, rest@_*) => rest.map(priceCalculate).sum - discount
      }
    }

    println("res4: " + priceCalculate(sale))
  }
}

// 設計樣例類
abstract class Item

case class Book(description: String, price: Double) extends Item

// 繼承Item:
// 1. Bundle可以只有一本書
// 2. 在item: Item*中，可以在現有Bundle中，再嵌套另一個Bundle
case class Bundle(description: String, discount: Double, item: Item*) extends Item