package com.unimicron.chapter02

object TypeDemo2 {
  def main(args: Array[String]): Unit = {
    println("Long的最大值: " + Long.MaxValue + "\tLong的最小值: " + Long.MinValue)

    var a = 1
    var b = 10L
    var c = 751324987412532L // 751324987412532超過int，使用Long表示

    // Double: 高精度、Float: 低精度
    // Double: 64位(~小數點14位)、Float: 32位(~小數點7位)
    var d: Float = 1.1f
    var e = 1.3
    var f: Double = 3.2f // Float -> Double

    // 自動轉換
    // 1. 有多種類型的數據混合運算時，系統首先自動將所有數據轉換成容量最大的那個數據類型，然後再
    // 進行運算
    // 2. 當我們把精度大(容量大)的數據類型賦值給經度小的樹綠類型時，就會報錯，反之進行自動轉換
    // 3. (byte, short)和char之間不會相互自動轉換
    // 4. byte, short, char三者可以計算，在計算時首先轉換為int類型
    // 5. 自動提升原則: 表達式結果的類型自動提升為操作數中最大的類型
    // 6. 若有表達式，先計算表達式的結果，再判斷結果的數據類型是否能與宣告的變量數據類型匹配或是否可以自動轉換
    var n1 = 10
    var n2 = 1.4f
    var n3 = n1 + n2

    var n4: Byte = 10
//    var n5: Char = n4 // 報錯
    var n6: Char = 'a'
    var n7 = n4 + n6

    // 強制轉換
    // 1. 當進行數據類型的大->小時，需使用強制轉換
    // 2. 強制轉換符號只對最近的操作數有效，但這樣可能與原先想要的值不合，可以使用括號提升優先級
    // 3. Char類型可以保存Int的常量值，但不能保存Int的變量值，需要強轉
    // 4. Byte和Short在運行時，當作Int類型在運算
    var n8: Int = 10 * 3.5.toInt + 2 * 3.2.toInt
    var n9: Int = (10 * 3.5 + 2 * 3.2).toInt

    var n10: Char = 1
    var n11: Int = 5
//    var n12: Char = n11
  }
}
