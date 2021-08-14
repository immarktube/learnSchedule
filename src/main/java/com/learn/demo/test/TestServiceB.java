package com.learn.demo.test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class TestServiceB {

    private TestServiceA testServiceA;

    public void setTestServiceA(TestServiceA testServiceA){
        this.testServiceA = testServiceA;
        System.out.println("设置了aaaa");
    }
}
