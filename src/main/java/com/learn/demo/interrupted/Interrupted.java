package com.learn.demo.interrupted;

import com.learn.demo.utils.SleepUtils;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static String VO = "TEST_VOLATILE";
    public static void main(String[] args) throws Exception{
        //sleepThread 不停的尝试睡眠
        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);
        //busyThread 不停的运行
        Thread busyThread = new Thread(new BusyRunner(),"BusyRunner");
        busyThread.setDaemon(true);
        sleepThread.start();
        busyThread.start();
        //休眠五秒，让sleepThread与busythread充分运行
//        TimeUnit.SECONDS.sleep(5);
//        sleepThread.interrupt();
//        busyThread.interrupt();
//        System.out.println("SleepThread interrupted is "+sleepThread.isInterrupted());
//        System.out.println("BUSYThread interrupted is "+busyThread.isInterrupted());
//        SleepUtils.second(2);
    }
    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            VO = "TEST";
            System.out.println(VO);
            System.out.println(this.hashCode());
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {

            System.out.println(VO);
            System.out.println(this.hashCode());
        }
    }
}
