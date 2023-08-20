package com.learn.demo.interview.algorithm.zuochengyun;

import java.math.BigInteger;

/**
 * <p> 主要用于包括XXXX</p>
 *【算法与数据结构入门篇】零基础5天快速入门算法，超详细的手绘图解思路+代码讲解
 * @Author <a href="https://www.bilibili.com/video/BV1Zr4y1W7ww/?p=2&spm_id_from=pageDriver&vd_source=ad94b98fbf1e46d483d42a9318f7b6c2">Video</a>
 * @Since 2023/1/19 00:18
 **/
public class P2 {

    public static void print(int num){
        for (int i = 31; i >= 0 ; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void println(int n){
        for (int i = 8; i >= 0; i--) {
            System.out.print(n >>> i & 1);
        }
    }
    public static int add(int a,int b) {
        int xor=a^b;//得到原位和
        int forworad=(a&b)<<1;//得到进位和


        return forworad==0?xor:add(xor,forworad);
    }
    public static void main(String[] args) {
        // System.out.println(add(2,2));
        // print(86);

        int c = -10;
        print(c);
        int a = new BigInteger("10000000000000000000000000000000",2).intValue();
        print(~a+5);
    }

//    11111111111111111111111111101100
//    00000000000000000000000000010110
//    00000000000000000000000000010100
}
