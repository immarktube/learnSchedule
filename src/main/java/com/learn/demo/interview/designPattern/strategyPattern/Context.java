package com.learn.demo.interview.designPattern.strategyPattern;

public class Context {
    private Strategy strategy;

    public Context(){

    }

    public void SetContext(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}
