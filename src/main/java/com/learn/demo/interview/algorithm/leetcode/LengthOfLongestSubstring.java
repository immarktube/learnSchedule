package com.learn.demo.interview.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p> 无重复最长字串</p>
 *
 * @Author <a href="mailto:immarktube@gmail.com">Marktube</a>
 * @Since 2022/5/16 19:53
 **/
public class LengthOfLongestSubstring {

    private static int longestLength;
    private static String s = "abcabcbb";

    public static void main(String[] args) {
        System.out.println(solution(s));
    }

    private static int solution(String sample) {
        List<String> list = new CopyOnWriteArrayList<>();
        List<Integer> lengthArr = new ArrayList<>();
        char[] chars = sample.toCharArray();
        list.add(chars[0]+"");
        for (char aChar : chars) {
            CharSequence cs = aChar + "";
            for (String element :
                    list) {
                if (element.contains(cs)) {
                    list.clear();
                    lengthArr.add(longestLength);
                } else {
                    list.add(cs.toString());
                    longestLength++;
                }
            }
            Collections.sort(lengthArr);
            return lengthArr.get(0);
        }
        Collections.sort(lengthArr);
        return lengthArr.get(0);
    }
}
