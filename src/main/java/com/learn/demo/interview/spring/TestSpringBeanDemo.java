package com.learn.demo.interview.spring;

import java.util.Arrays;
import java.util.List;

public class TestSpringBeanDemo {


    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        List ints = Arrays.asList(a);
        // ints.remove(1);
        System.out.println(ints.size());
    }
}
