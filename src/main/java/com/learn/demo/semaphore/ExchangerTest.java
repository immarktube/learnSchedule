package com.learn.demo.semaphore;


import java.util.concurrent.*;

public class ExchangerTest {
    private static final Exchanger<String> exgr = new Exchanger<>();

    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        Future<?> submit = threadPool.submit(()->"hello world");
        try {
            System.out.println(submit.get());
//            System.out.println(threadPool.isTerminated());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        threadPool.execute(()->{
//            try {
//                String A = "银行流水B";
//                String B = exgr.exchange("银行流水B");
//                System.out.println("A和B的数据是否一致："+A.equals(B)+"，A录入的是："+A+"，B录入的是："+B);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });

        threadPool.shutdown();
    }
}
