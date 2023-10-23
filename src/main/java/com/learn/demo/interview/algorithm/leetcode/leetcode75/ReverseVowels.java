package com.learn.demo.interview.algorithm.leetcode.leetcode75;

import lombok.val;

/**
 * <p> 主要用于包括XXXX</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">tubemark</a>
 * @Since 2023/10/23 10:44
 **/
public class ReverseVowels {
    public static String reverseVowels(String s) {
        int start = 0;
        int end = s.length()-1;
        val charArray = s.toCharArray();
        String vowels = "aeiouAEIOU";

        while(start < end) {

            while (start < end && vowels.indexOf(charArray[start]) == -1) {
                start++;
            }

            while (start < end && vowels.indexOf(charArray[end]) == -1) {
                end--;
            }
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
    }
}
