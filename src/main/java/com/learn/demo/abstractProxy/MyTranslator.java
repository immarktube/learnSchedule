package com.learn.demo.abstractProxy;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2021/9/8 11:40 上午
 **/
public class MyTranslator extends ProxyTranslator{


    @Override
    public Object translate(Object var1) {
        return "null123";
    }

    public static void main(String[] args) {
        MyTranslator myTranslator = new MyTranslator();
        System.out.println(myTranslator.translate("1"));
        System.out.println(AbstractTranslator.class);
    }
}
