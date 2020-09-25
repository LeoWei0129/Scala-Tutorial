package com.unimicron.chapter08;

public class SuperSubTest {
    public static void main(String[] args) {
        // Java的dynamic binding小結
        // 1. 如果調用的是方法，JVM會將這方法和對象的內存地址綁定
        // 2. 如果調用的是屬性，則沒有動態綁定機制，在哪個類調用，就返回那個類中的對應值
        Sub sub1 = new Sub();
        System.out.println(sub1.s);
        System.out.println(((Super) sub1).s);
        sub1.printString();

        Super sub2 = new Sub();
        System.out.println(sub2.s);
        sub2.printString(); // dynamic binding
    }
}

class Super {
    String s = "super";

    public void printString() {
        System.out.printf("Super function: %s\n", s);
    }
}

class Sub extends Super {
    String s = "sub"; // 全新的變量，非override

    public void printString() {
        System.out.printf("Sub function: %s\n", s);
    }
}