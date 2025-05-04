package com.leetcode._2025_3;

import org.junit.Test;


/**
 * 3110. 字符串的分数
 *
 * @author DHW
 * @date 2025/3/15 10: 33
 * @Version 1.0
*/
public class ProblemsNo3110 {

    @Test
    public void solution() {
        String s = "hello";
        System.out.println("res = " + scoreOfString(s));
    }

    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            res += Math.abs( s.charAt(i) - s.charAt(i-1) );
        }
        return res;
    }
}

