package com.leetcode._2025_1;

import org.junit.Test;

import java.util.ArrayList;


/**
 * 541. 反转字符串 II
 *
 * @author DHW
 * @date 2025/1/31 10: 21
 * @Version 1.0
*/
public class ProblemsNo541 {

    @Test
    public void solution() {
        String s = "abcdefg";
        int k = 2;
        System.out.println("res = " + reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(chars, i, Math.min(i + k, n) - 1);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }
    }
}

