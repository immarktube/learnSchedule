package com.learn.demo.interview.algorithm.leetcode.leetcode75;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">tubemark</a>
 * https://leetcode.com/problems/can-place-flowers/
 * @Since 2023/10/15 23:25
 **/
public class CanPlaceFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int prev = (i == 0 || flowerbed[i - 1] == 0) ? 0 : 1;
                int next = (flowerbed.length - 1 == i || flowerbed[i + 1] == 0) ? 0 : 1;
                if (prev == 0 && next == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }


    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
    }
}
