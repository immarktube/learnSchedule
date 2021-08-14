package com.learn.demo.interview.algorithm.firstDay;

public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(1+1/2);
    }

    abstract class  VersionControl{
        abstract boolean isBadVersion(int n);
    }

    public class Solution extends VersionControl{

        public int firstBadVersion(int n) {
            int left = 1,right = n;
            while (left < right){
                right = right - left / 2;
                if (isBadVersion(right)) return right;
                else {left = right;right = n;}
            }
            return left;
        }
        @Override
        boolean isBadVersion(int n) {
            return false;
        }
    }
}
