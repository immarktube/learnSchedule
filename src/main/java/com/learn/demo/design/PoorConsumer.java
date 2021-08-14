package com.learn.demo.design;

public class PoorConsumer extends Consumer{

    public PoorConsumer(People people) {
        super(people);
    }

    @Override
    public String getName() throws Exception {
        return super.getName();
    }
}
