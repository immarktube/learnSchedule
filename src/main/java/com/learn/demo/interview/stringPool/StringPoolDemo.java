package com.learn.demo.interview.stringPool;

import sun.misc.Version;

/**
 * @create ⌚️2021-05-11 21：10
 */
public class StringPoolDemo {
    public static void main(String[] args) {
        String stringBuilder = new StringBuilder("ali").append("baba").toString();
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.intern());
        System.out.println(stringBuilder.intern() == stringBuilder);

        System.out.println();

        String str2 = new StringBuilder("1.8.0_").append("282").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }
}
