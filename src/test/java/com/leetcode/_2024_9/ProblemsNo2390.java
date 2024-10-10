package com.leetcode._2024_9;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 2390. 从字符串中移除星号
 *
 * @author DHW
 * @date 2024/9/14 8:33
 * @Version 1.0
*/
public class ProblemsNo2390 {

    @Test
    public void solution() {
        String s = "TFFT";
        int k = 1;
        System.out.println("res = " + removeStars(s));
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == '*') {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

