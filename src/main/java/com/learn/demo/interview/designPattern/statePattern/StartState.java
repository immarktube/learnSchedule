package com.learn.demo.interview.designPattern.statePattern;

public class StartState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in StartState");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StartState ";
    }
}
