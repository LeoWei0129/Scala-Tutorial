package com.unimicron.chapter09;

public class JavaInnerClass {
    public static void main(String[] args) {
        // 創建外部類
        OuterClass outerClass1 = new OuterClass();
        OuterClass outerClass2 = new OuterClass();

        // 創建成員內部類
        // Java中，成員內部類被當作一個屬性，因此使用"."的方式來創建
        OuterClass.InnerClass innerClass1 = outerClass1.new InnerClass();
        OuterClass.InnerClass innerClass2 = outerClass2.new InnerClass();

        // 這種方法的調用說明內部類只和類相關，也就是說，只要是OuterClass.InnerClass類型的對象就可以
        // 傳給型參InnerClass ic
        innerClass1.test(innerClass2);
        innerClass2.test(innerClass1);

        // 創建靜態內部類
        // Java中，靜態內部類是和類相關的，使用new OuterClass.StaticInnerClass()
        OuterClass.StaticInnerClass staticInnerClass1 = new OuterClass.StaticInnerClass();
    }
}

class OuterClass{ // 外部類
    class InnerClass{ // 成員內部類
        public void test(InnerClass ic){
            System.out.println(ic);
        }
    }

    static class StaticInnerClass{ // 靜態內部類

    }
}
