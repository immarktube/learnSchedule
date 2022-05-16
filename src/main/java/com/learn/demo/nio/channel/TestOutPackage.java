package com.learn.demo.nio.channel;

import com.learn.demo.optional.TestPrivate;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2022/3/16 7:58 下午
 **/
public class TestOutPackage extends TestPrivate.ProxyPrivate {

    public static void main(String[] args) {
        TestOutPackage testOutPackage = new TestOutPackage();
        testOutPackage.testPrivate();
    }
}
