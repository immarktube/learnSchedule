package com.learn.demo.vavr;

import io.vavr.control.Try;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">tubemark</a>
 * @Since 2023/9/17 14:02
 **/
public class TrySample {
    public static void main(String[] args) {
        final Try<Integer> integers = Try.of(() -> divide(1, 0));

        if (integers.isSuccess()) {
            System.out.println(integers.get());
        } else {
            System.out.println(integers.getCause());
        }
    }

    // 一个可能引发异常的除法操作
    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("除数不能为零");
        }
        return dividend / divisor;
    }
}
