package com.learn.demo.cyclicBarrier;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable{

    private CyclicBarrier c = new CyclicBarrier(4,this);

//    创建线程池
    private Executor executor = Executors.newFixedThreadPool(4);

//    设置一个流水总数（各个线程加一起的结果集
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count(){
//        循环出四个线程分别处理对应sheet的内容，然后将计算的数据存入总结果集内
        for (int i = 0;i < 4;i++){
            executor.execute(()->{
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
//                    通知此线程已经处理好任务来到了屏障前
                    c.await();
                }catch (InterruptedException |BrokenBarrierException e){
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
//        大概是取出结果集所有数据相加得出最后总的数据
        for (Map.Entry<String,Integer> sheet : sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterCount = new BankWaterService();
        bankWaterCount.count();
    }
}
