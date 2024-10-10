package com.leetcode._2024_9;

import org.junit.Test;


/**
 * 2414. 最长的字母序连续子字符串的长度
 *
 * @author DHW
 * @date 2024/9/19 9:16
 * @Version 1.0
*/
public class ProblemsNo2414 {

    @Test
    public void solution() {
        String s = "abcde";
        System.out.println("res = " + longestContinuousSubstring(s));
    }

    public int longestContinuousSubstring(String s) {
        int res = 1;
        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1) + 1) {
                res = Math.max(res, ++num);
            } else {
                num = 1;
            }
        }
        return res;
    }
}

