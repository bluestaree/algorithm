package com.leetcode._2026_2;

import org.junit.Test;


/**
 * 3794. 反转字符串前缀
 *
 * @author DHW
 * @date 2026/2/9 11: 19
 * @Version 1.0
*/
public class ProblemsNo3794 {

    @Test
    public void solution() {
        String s = "QWER";
        int k = 2;
        System.out.println("res = " + reversePrefix(s, k));
    }

    public String reversePrefix(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = k - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}

