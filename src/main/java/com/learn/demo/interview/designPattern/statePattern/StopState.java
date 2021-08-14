package com.learn.demo.interview.designPattern.statePattern;

public class StopState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in StopState");
        context.setState(this);
    }
}
