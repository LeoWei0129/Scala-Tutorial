package com.unimicron.chapter08;

public class AnonymousJava {
    public static void main(String[] args) {
        // 在Java中創建一個匿名子類對象
        A2 a2 = new A2(){
            @Override
            public void cry() {
                System.out.println("cry...");
            }
        };
        a2.cry();

        // 匿名子類的部分
//        new A2(){
//            @Override
//            public void cry() {
//                System.out.println("cry...");
//            }
//        }

        //匿名子類對應的實例
//        A2 a2
    }
}

abstract class A2{
    abstract public void cry();
}