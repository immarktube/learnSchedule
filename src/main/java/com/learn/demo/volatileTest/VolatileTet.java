package com.learn.demo.volatileTest;

public class VolatileTet {
    public static String VO = "TEST_VOLATILE";
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            VO = "TEST";
            System.out.println(VO);
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(VO);
//            System.out.println(this.);
        });
        thread.start();
        thread2.start();
    }

    void test(){
        Thread thread = new Thread(() -> {
            VO = "TEST";
            System.out.println(VO);
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(VO);
        });
    }

}
