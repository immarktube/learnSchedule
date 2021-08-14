package com.learn.demo.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class TestServiceA {

    private
    TestServiceB testServiceB;

    public void setTestServiceB(TestServiceB testServiceB){
        this.testServiceB = testServiceB;
        System.out.println("设置了bbbbb");
    }
}
