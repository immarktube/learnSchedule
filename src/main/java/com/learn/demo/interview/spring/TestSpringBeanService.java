package com.learn.demo.interview.spring;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.Callable;

@Service
public class TestSpringBeanService extends TestSpringBeanDemo implements Callable,Runnable {

    static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {

        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

        Collections.synchronizedList(new ArrayList<>());

        List list = new LinkedList();
        // List list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(1,2);
        list.stream().forEach((s)->{
            System.err.println(s);
            System.out.println(list.size());
        });

        // String a = "abc";
        // String b = new String("abc");
        // // b.intern();
        // System.out.println(a == b);
        // System.out.println(a.equals(b));
        // for(;;){
        HashMap<String,String> a = new HashMap<>(9);
        print(a);
        a.put("1","b");
        a.put("2","a");
        a.put("3","b");
        a.put("4","4");
        a.put("5","56");
        a.put("6","5");
        a.put("7","s");
        a.put("8","asd");
        a.put("9","asd");
        a.put("10","asd");
        a.put("11","asd");
        a.put("12","asd");
        // a.put("13","asd");
        System.out.println(1 << 30);
        print(a);
        System.out.println(tableSizeFor(2));

    }

    @Transactional
    public static void print(Map a) {
        try {
            Class<?> mapType = a.getClass();
            Method capacity = mapType.getDeclaredMethod("capacity");
            capacity.setAccessible(true);
            System.out.println("capacity : " + capacity.invoke(a) + "    size : " + a.size());

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 返回大于 cap 的最小 2 的 N 次方
     * @param cap
     * @return
     */
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    @Override
    public void run() {

    }

    @Override
    public Object call() throws Exception {
        return null;
    }
}
