package com.learn.demo.vavr;

import io.vavr.Lazy;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">tubemark</a>
 * @Since 2023/9/18 23:41
 **/
public class LazySample {

    public static void main(String[] args) {
        Lazy<Double> lazy = Lazy.of(Math::random);
        lazy.isEvaluated(); // = false
        lazy.get();         // = 0.123 (random generated)
        lazy.isEvaluated(); // = true
        System.out.println(lazy.get());
    }

    public static void classicUsage() {
        // 使用 Lazy 进行延迟初始化
        Lazy<ExpensiveObject> lazyExpensiveObject = Lazy.of(() -> {
            System.out.println("初始化 ExpensiveObject...");
            return new ExpensiveObject();
        });

        // 在需要的时候才进行初始化
        // if (someCondition) {
        //     ExpensiveObject expensiveObject = lazyExpensiveObject.get();
        //     // 使用 expensiveObject
        // }

        // 在不需要的情况下，不会进行初始化
    }


    static class ExpensiveObject {
        // 此类表示一个开销较大的对象，例如数据库连接、文件加载等
    }

}
