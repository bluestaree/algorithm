package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 541. 反转字符串 II
 *
 * @author DHW
 * @date 2026/2/26 10: 32
 * @Version 1.0
 */
public class ProblemsNo541 {

    @Test
    public void solution() {
        String s = "abcdefg";
        System.out.println("res = " + reverseStr(s, 2));
    }

    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for (int i = 0; i < n; i += 2 * k) {
            int r = Math.min(i + k, n) - 1;
            for (int j = i; j < r; j++, r--) {
                char temp = charArray[r];
                charArray[r] = charArray[j];
                charArray[j] = temp;
            }
        }
        return new String(charArray);
    }
}

