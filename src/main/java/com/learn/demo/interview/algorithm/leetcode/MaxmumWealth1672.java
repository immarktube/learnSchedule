package com.learn.demo.interview.algorithm.leetcode;

import java.util.Arrays;

class MaxmumWealth1672 {

    public static int maximumWealth(int[][] accounts) {
        int[] accountsWealth = new int[accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            accountsWealth[i] = Arrays.stream(accounts[i]).sum();
        }
        return Arrays.stream(accountsWealth).max().getAsInt();
    }
    public static int maximumWealth2(int[][] accounts) {
        int result = 0;
        for (int[] i :
                accounts) {
            int temp = 0;
            for (int j :
                    i) {
                temp+=j;
            }
            result = Math.max(result,temp);
        }
        return result;
    }
    
    public static void main(String[] args) {
        int [][] a = {{1,2,3},{4,2,1}};
        System.out.println(maximumWealth2(a));
    }
}