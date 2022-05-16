package com.learn.demo.test;

import org.thymeleaf.util.Validate;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2021/8/22 12:06 下午
 **/
public class VlidateDemo {
    public static void main(String[] args) {
        String s = "";
        // Validate.notNull(s,"s is cannot be null");
        System.out.printf(s.length()+"");
        Validate.isTrue(!s.isEmpty(),"s is null");
    }
}
