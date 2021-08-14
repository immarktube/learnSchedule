package com.learn.demo.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    static CountDownLatch c = new CountDownLatch(3);

    public static void main(String[] args) {
        new Thread(()->{
            System.out.println(1);
//            计数器-1
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        try {
//          等待阻塞的任务完成  根据计数器来
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(3);
    }
}
