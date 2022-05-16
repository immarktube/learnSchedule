package com.learn.demo.interrupted;

/**
 * @Author Mark
 * @Description 线程在不活跃状态下被中断会抛出异常，{@link java.lang.Thread.State }
 * 如果不抛出异常便回不到运行状态，也就无法处理中断。
 * @Date 12:25 2022/4/3
 * @Param
 * @return
**/
public class Interrupted {
    public static void main(String[] args) throws Exception{
        //sleepThread 不停的尝试睡眠
        Thread sleepThread = new Thread(()->{
            long startMills = System.currentTimeMillis();
            while (System.currentTimeMillis() - startMills < 3){
                if (Thread.interrupted()){
                    System.out.println("停止==========");
                } else {
                    System.out.println("前进");
                }
            }
        });
        sleepThread.start();
        // busyThread.start();
        Thread.sleep(1);
        sleepThread.interrupt();

    }

}
