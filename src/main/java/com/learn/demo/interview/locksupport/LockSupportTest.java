package com.learn.demo.interview.locksupport;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class LockSupportTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Thread a = new Thread(() -> {
            LockSupport.park();
            lock.lock();
            lock.unlock();
            System.out.println("a come in");
        }, "A");

         new Thread(() -> {
             a.start();
            LockSupport.unpark(a);

             System.out.println("b come in");
        }, "B").start();
    }
}
