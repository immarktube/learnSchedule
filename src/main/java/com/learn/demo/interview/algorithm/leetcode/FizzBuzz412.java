package com.learn.demo.interview.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2023/8/23 08:25
 **/
public class FizzBuzz412 {

    public static List<String> fizzBuzz(int n) {
        String[] res = new String[n];
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 ==0) {
                res[i-1] = "FizzBuzz";
            } else if (i % 3 ==0) {
                res[i-1] = "Fizz";
            } else if (i % 5 ==0) {
                res[i-1] = "Buzz";
            } else {
                res[i-1] = i+"";
            }
        }
        return Arrays.asList(res.clone());
    }

    public static void main(String[] args) {
        fizzBuzz(10).forEach(System.out::println);

    }
}
