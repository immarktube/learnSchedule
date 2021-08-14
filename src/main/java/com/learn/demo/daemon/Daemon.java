package com.learn.demo.daemon;

import com.learn.demo.utils.SleepUtils;

public class Daemon {
    public static void main(String[] args) {
        Thread thread = new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    static class DaemonRunner implements Runnable{

        @Override
        public void run() {
            System.out.println(222);
            try {
                System.out.println("111");
                SleepUtils.second(2);
            }catch (Exception e){
//                System.out.println();
                System.out.println(e.getMessage());
            }
            finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
