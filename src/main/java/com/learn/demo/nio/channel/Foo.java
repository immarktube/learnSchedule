package com.learn.demo.nio.channel;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

class Foo {

    static CountDownLatch second = new CountDownLatch(0);

    static CountDownLatch third = new CountDownLatch(0);


    public Foo() {
    }

    public synchronized void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public  void second(Runnable printSecond) throws InterruptedException {
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public  void third(Runnable printThird) throws InterruptedException {
        third.await();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
    }
}