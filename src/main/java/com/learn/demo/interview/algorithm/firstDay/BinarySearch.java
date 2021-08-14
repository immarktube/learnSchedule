package com.learn.demo.interview.algorithm.firstDay;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(new Solution().search(nums,2));
        // System.out.println(ints.indexOf(nums));
    }

    /**
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     */
    static class Solution {

        public int search(int[] nums, int target) {

            Integer[] integers1 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            List<Integer> integers = Arrays.asList(integers1);
            for (;;){
                if (integers.size() < 1 || !integers.contains(target)){
                    return -1;
                }
            final int last = integers.get(integers.size() / 2);
                if (target > last){
                    integers = integers.subList(integers.indexOf(last),integers.size());
                }else if (target < last){
                    integers = integers.subList(0,integers.indexOf(last));
                }else {
                    List<Integer> arr = Arrays.asList(integers1);
                    return arr.indexOf(target);
                }
            }
        }
    }
}
