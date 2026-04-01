package com.leetcode._2026_3;

import org.junit.Test;


/**
 * 125. 验证回文串
 *
 * @author DHW
 * @date 2026/3/2 10: 19
 * @Version 1.0
*/
public class ProblemsNo125 {

    @Test
    public void solution() {
        String s = "cat and mice";
        System.out.println("res = " + isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

