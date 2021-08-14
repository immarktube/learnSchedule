package com.learn.demo.interview.designPattern.strategyPattern;

@FunctionalInterface
public interface Strategy {
    public int doOperation(int num1,int num2);
}
