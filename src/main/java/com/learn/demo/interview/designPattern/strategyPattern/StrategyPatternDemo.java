package com.learn.demo.interview.designPattern.strategyPattern;

public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context();
        context.SetContext(new OperationAdd());
        System.out.println(context.executeStrategy(0,5));

        context = new Context();
        System.out.println(context.executeStrategy(2,3));

        context = new Context();
        System.out.println(context.executeStrategy(2,3));
    }
}
