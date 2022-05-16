package com.learn.demo.optional;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2022/3/16 7:23 下午
 **/
public class TestPrivate {


    private TestPrivate(){

    }

    public void testPrivate(){
        System.out.println("I'm real Private.");
    }

    public static class ProxyPrivate extends TestPrivate{

        public volatile static ProxyPrivate proxyPrivate;

        public  ProxyPrivate(){
            System.out.println("i'm ProxyPrivate.");
        }

        public static ProxyPrivate getInstance(){
            if (proxyPrivate == null) {
                synchronized (ProxyPrivate.class) {
                    if (proxyPrivate == null) {
                        proxyPrivate = new ProxyPrivate();
                    }
                }
            }
            return proxyPrivate;
        }
    }
}
