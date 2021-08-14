package com.learn.demo.interview.algorithm;

import java.util.HashMap;
import java.util.Map;


/**
 * 两数之和 经典初级算法题 暴力破解与最优解
 */
public class TwoSumDemo {
//  [7,2,11,15]

    public static void main(String[] args) {
        int[] nums = {8,44,2,7,2};
        int target = 9;
        for (int i : twoSum2(nums, target)) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums,int target){
        long l = System.currentTimeMillis();
//        int[] nums = {8,44,2,7,2};
//        int target = 9;
        boolean flag = true;
        for (int i = 0;i < nums.length;i++){
            if (flag)
                for (int j = i+1;j < nums.length;j++){
                    if ( nums[i] + nums[j] == target && flag){
                        System.out.println(nums[i]+"====="+nums[j]);
                        flag=false;
                        long l1 = System.currentTimeMillis();
                        System.out.println(l1 - l);
                    }
                }
        }
        return null;
    }

    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i =0;i < nums.length;i++){
            int partnerNumber = target - nums[i];
            if (map.containsKey(partnerNumber)){
                System.out.println(map.get(partnerNumber)+"===="+i);
                return new int[]{partnerNumber,i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
