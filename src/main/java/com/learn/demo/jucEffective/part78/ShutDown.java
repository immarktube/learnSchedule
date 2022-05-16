package com.learn.demo.jucEffective.part78;


import java.util.concurrent.*;

/**
 * <p> 主要用于包括演示停止线程</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2022/4/3 13:04
 **/
public class ShutDown {
    private static volatile Boolean stopRequested = false;
    public static void main(String[] args)
            throws InterruptedException {
        // Thread backgroundThread = new Thread(() -> {
        //     int i = 0;
        //     while (!stopRequested)
        //         i++;
        // });
        // backgroundThread.start();
        // TimeUnit.SECONDS.sleep(1);
        // stopRequested = true;

        ShutDown shutdown = new ShutDown();
        shutdown.test();
    }

    // private static synchronized Boolean getstopRequested(){
    //     return stopRequested;
    // }
    // private static synchronized void requestStop( ){
    //     stopRequested = true;
    // }

        /** 信号量
         * 是用来控制同时访问特定资源对线程数量，它通过协调各个线程，
         * 以保证合理的使用公共资源
         */
        private Semaphore semaphore = new Semaphore(0); // 1
        /** 线程池 */
        private ThreadPoolExecutor pool = new ThreadPoolExecutor(3, 5, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(3));
        /** Future */
        private Future future ;

        public void test(){
            future = pool.submit(() -> {
                String result = null;
                try {
                    // 同步阻塞获取信号量
                    semaphore.acquire();
                    result = "ok";
                } catch (InterruptedException e) {
                    result = "interrupted";
                }
                semaphore.release();
                return result;
            });
            String result = "timeout";
            try {
                // 等待3s
                result = (String) future.get(3, TimeUnit.SECONDS);
            }catch (Exception e) {
                System.out.println("超时异常");
            }
            // 删除线程池中任务
            boolean cancelResult = future.cancel(true);
            System.out.println("result is " + result);
            System.out.println("删除结果：" +cancelResult);
            System.out.println("当前active线程数：" +pool.getActiveCount());
        }

    }
