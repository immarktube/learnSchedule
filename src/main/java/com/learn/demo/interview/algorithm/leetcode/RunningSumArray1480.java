package com.learn.demo.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2023/8/22 22:47
 * @link https://leetcode.com/problems/running-sum-of-1d-array/
 **/
public class RunningSumArray1480 {
    public static int[] runningSum(int[] nums) {
        int i = 0;
        List<Integer> intList = new ArrayList<>();
        for (int num :
                nums) {
            intList.add(i+num);
            i = i+num;
        }
         return intList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] ints = runningSum(nums);
        for (int i :
                ints) {
            System.out.println(i);
        }
    }
}
