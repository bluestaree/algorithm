package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 2697. 字典序最小回文串
 *
 * @author DHW
 * @date 2026/3/2 9: 57
 * @Version 1.0
*/
public class ProblemsNo2697 {

    @Test
    public void solution() {
        String s = "cat and mice";
        System.out.println("res = " + makeSmallestPalindrome(s));
    }

    public String makeSmallestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for (int i = 0,j = n - 1; i < j; i++, j--) {
            if (charArray[i] != charArray[j]) {
                charArray[i] = charArray[j] = (char) Math.min(charArray[i], charArray[j]);
            }
        }
        return new String(charArray);
    }
}

