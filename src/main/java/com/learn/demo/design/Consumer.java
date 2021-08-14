package com.learn.demo.design;

/**
 *
 */
public class Consumer extends People
{
    protected volatile People people;

    protected Consumer(People people){
        this.people = people;
    }

    public Consumer() {

    }

    @Override
    public void setName() throws Exception {
        people.setName();
    }

    @Override
    public String getName() throws Exception {
        return people.getName();
    }
}
