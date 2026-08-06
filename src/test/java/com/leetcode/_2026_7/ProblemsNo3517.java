package com.leetcode._2026_7;

import org.junit.Test;

import java.util.Arrays;


/**
 * 3517. 最小回文排列 I
 *
 * @author DHW
 * @date 2026/7/21 10:04
 * @Version 1.0
*/
public class ProblemsNo3517 {

    @Test
    public void solution() {
        String s = "bbb";
        System.out.println("res = " + smallestPalindrome(s));
    }

    public String smallestPalindrome(String s) {
        int n = s.length();
        int m = n / 2;
        StringBuilder stringBuilder = new StringBuilder(n);
        char[] charArray = s.substring(0, m).toCharArray();
        Arrays.sort(charArray);
        stringBuilder.append(charArray);
        if (n % 2 > 0) {
            stringBuilder.append(s.charAt(m));
        }

        for (int i = m - 1; i >= 0; i--) {
            stringBuilder.append(charArray[i]);
        }
        return stringBuilder.toString();

    }

}
