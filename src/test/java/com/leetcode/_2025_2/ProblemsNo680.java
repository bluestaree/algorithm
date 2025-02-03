package com.leetcode._2025_2;

import org.junit.Test;


/**
 * 680. 验证回文串 II
 *
 * @author DHW
 * @date 2025/2/3 10: 58
 * @Version 1.0
*/
public class ProblemsNo680 {

    @Test
    public void solution() {
        String s = "abcdefg";
        System.out.println("res = " + validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int n = s.length();
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if(charArray[i] != charArray[j]) {
                return check(charArray, i + 1, j) || check(charArray, i, j - 1);
            }
        }
        return true;

    }

    private boolean check(char[] charArray, int i, int j) {
        while (i < j) {
            if(charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

